package com.ai.paas.ipaas.user.service.impl;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.RestfullReq;
import com.ai.paas.ipaas.user.dto.RestfullReturn;
import com.ai.paas.ipaas.user.dto.UserMessage;
import com.ai.paas.ipaas.user.dto.UserMgrOperate;
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.DocumentVo;
import com.ai.paas.ipaas.user.dubbo.vo.ProdMenuVo;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IDssConsoleSv;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.IUserMgrOperateSv;
import com.ai.paas.ipaas.user.service.IUserProdInstSv;
import com.ai.paas.ipaas.user.service.dao.UserMessageMapper;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.HttpRequestUtil;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;
import com.google.gson.Gson;
@Service
@Transactional 
public class DssConsoleSvImpl implements IDssConsoleSv {
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private SqlSessionTemplate template;
	@Autowired
	private IProdProductSv iProdProductSv;	
	@Autowired
	private IUserMgrOperateSv iUserMgrOperateSv;	
	@Autowired
	private ISysParamSv iSysParamSv;
	
	@Autowired
	private IUserProdInstSv iUserProdInstSv;
	
	@Override
	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)
			throws PaasException {
		UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
		UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();		
		criteria.andUserIdEqualTo(vo.getUserId());
		criteria.andUserServiceIdEqualTo(vo.getUserServiceId());
		criteria.andUserServRunStateNotEqualTo(Constants.UserProdInst.UserServRunState.CANCEL);
		
		UserProdInstCriteria.Criteria criteria2 = userProdInstCriteria.createCriteria();		
		criteria2.andUserIdEqualTo(vo.getUserId());
		criteria2.andUserServiceIdEqualTo(vo.getUserServiceId());
		criteria2.andUserServRunStateIsNull();		
		userProdInstCriteria.or(criteria2);		
		userProdInstCriteria.setOrderByClause(" USER_SERV_OPEN_TIME desc");
		UserProdInstMapper UserProdInstMapper = template.getMapper(UserProdInstMapper.class);
		List<UserProdInst> userProdInsts = UserProdInstMapper.selectByExample(userProdInstCriteria);
		List<UserProdInstVo> userProdInstVoist = new ArrayList<UserProdInstVo>();
		if (userProdInsts != null && userProdInsts.size() > 0) {
			for (int i = 0; i < userProdInsts.size(); i++) {
				UserProdInstVo userProdInstVo = new UserProdInstVo();
				BeanUtils.copyProperties(userProdInsts.get(i), userProdInstVo);
				// 获取已使用量、产品名称
				getAmountUsed(userProdInstVo);
				//获取单文件大小、服务名称
				getSingleFileSize(userProdInstVo);				
				userProdInstVoist.add(userProdInstVo);
			}
		}
		return userProdInstVoist;
	}

	public void getAmountUsed(UserProdInstVo userProdInstVo)
			throws PaasException {
		logger.info("查询已使用量");
		String prodId = userProdInstVo.getUserServiceId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);

	
		
//		String address = CacheUtils.getValueByKey("PASS.SERVICE") +prodProduct.getProdUsedAmountRestfull();
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdUsedAmountRestfull();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的已使用量查询地址为空");
		}
			
		RestfullReq restfullReq = new RestfullReq();
		restfullReq.setUserId(userProdInstVo.getUserId());
		restfullReq.setServiceId(userProdInstVo.getUserServIpaasId());
		restfullReq.setApplyType( "getStatus");
		String param = JSonUtil.toJSon(restfullReq);
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+param);
		String result = HttpClientUtil.send(address, param);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("服务异常");
		}
		RestfullReturn restfullReturn = JSonUtil.fromJSon(result, RestfullReturn.class);
		String resultCode = restfullReturn.getResultCode();
		if (PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL.equals(resultCode)) {
			throw new PaasException("调用restful失败");
		}
		String usedSize = restfullReturn.getUsedSize();
		BigInteger  size = BigInteger.valueOf(Long.parseLong(usedSize));
		BigInteger mSize = size.divide(BigInteger.valueOf(1024l).multiply(BigInteger.valueOf(1024l)));
		BigInteger kbSize = size.divide(BigInteger.valueOf(1024l));
		userProdInstVo.setTotalAmount(restfullReturn.getSize());
		if(1 > mSize.doubleValue()){
			userProdInstVo.setUsedAmount(kbSize.toString()+Constants.UsedAmount.KB);
		}else{
			userProdInstVo.setUsedAmount(mSize.toString()+Constants.UsedAmount.M);
		}
		
		userProdInstVo.setProdName(prodProduct.getProdName());
		

	}
	
	public void getSingleFileSize(UserProdInstVo userProdInstVo)
			throws PaasException {
		logger.info("获取单文件大小、服务名称");
		String prodParam = userProdInstVo.getUserServParam();
		if (StringUtil.isBlank(prodParam)) {
			throw new PaasException("产品参数为空");
		}
		JSONObject json = new JSONObject();
		json=JsonUtils.parse(prodParam);
		String singleFileSize = json.getString("singleFileSize");		
		if(StringUtil.isBlank(singleFileSize)){
			throw new PaasException("获取单文件大小失败");
	    }
		
		Gson gson = new Gson();
		Map<String,String> map = gson.fromJson(prodParam, Map.class);		
		String serviceName = map.get("serviceName");
		if(serviceName == null){
			serviceName="";
		}
		
		userProdInstVo.setSingleFileSize(singleFileSize);
		userProdInstVo.setServiceName(serviceName);

	}

	@Override
	public String cancleUserProdInst(UserProdInstVo vo) throws PaasException {
		long userServId = vo.getUserServId();
		UserProdInstMapper userProdInstMapper = template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst = userProdInstMapper.selectByPrimaryKey(userServId);
		if (null == userProdInst) {
			throw new PaasException("用户产品实例不存在");
		}
		String prodId = userProdInst.getUserServiceId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
		
//		String address =  CacheUtils.getValueByKey("PASS.SERVICE") + prodProduct.getProdCancleRestfull(); // 获取注销restful
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdCancleRestfull();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		RestfullReq restfullReq = new RestfullReq();
		restfullReq.setUserId(vo.getUserId());
		restfullReq.setServiceId(userProdInst.getUserServIpaasId());
		restfullReq.setApplyType("cancel");
		String param = JSonUtil.toJSon(restfullReq);
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+param);
		String result = HttpClientUtil.send(address, param);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("服务异常");
		}
		RestfullReturn restfullReturn = JSonUtil.fromJSon(result, RestfullReturn.class);
		String resultCode = restfullReturn.getResultCode();
		// 修改用户产品实例
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)){
			userProdInst.setUserServRunState(Constants.UserProdInst.UserServRunState.CANCEL);
			userProdInstMapper.updateByPrimaryKey(userProdInst);
		}		
		// 写用户管理操作
		UserMgrOperate userMgrOperate = new UserMgrOperate();
		userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.CANCLE);
		this.makeUserMgrOperate(userProdInst, resultCode, userMgrOperate);
		this.saveUserMgrOperate(userMgrOperate);
        return resultCode;
	}
	
	public void makeUserMgrOperate(UserProdInst userProdInst,String resultCode,UserMgrOperate userMgrOperate){
		userMgrOperate.setUserId(userProdInst.getUserId());
		userMgrOperate.setUserProdType(userProdInst.getUserServType());
		userMgrOperate.setUserProdId(userProdInst.getUserServiceId());
		userMgrOperate.setUserServId(userProdInst.getUserServId().toString());
		userMgrOperate.setUserServIpaasId(userProdInst.getUserServIpaasId());
		userMgrOperate.setUserProdParam(userProdInst.getUserServParam());
		userMgrOperate.setUserProdByname(userProdInst.getUserProdByname());
		userMgrOperate.setUserOperateDate(DateUtil.getSysDate());
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)){
			userMgrOperate.setUserOperateResult(Constants.UserMgrOperate.UserOperateResult.SUCCESS);
		}else{
			userMgrOperate.setUserOperateResult(Constants.UserMgrOperate.UserOperateResult.FAIL);
		}
	}
	
	public void saveUserMgrOperate(UserMgrOperate userMgrOperate) throws PaasException{		
		iUserMgrOperateSv.saveUserMgrOperate(userMgrOperate);
	}
	
	public void  saveUserMessage(UserMgrOperate userMgrOperate,String resultCode) throws PaasException{
		String content = "";
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)){
			content = "您对服务："+userMgrOperate.getUserServIpaasId()+"的"
					+Constants.UserMgrOperate.userOperateActionMap.get( userMgrOperate.getUserOperateAction())
					+"操作成功";
		}else{
			content = "您对服务："+userMgrOperate.getUserServIpaasId()+"的"
					+Constants.UserMgrOperate.userOperateActionMap.get( userMgrOperate.getUserOperateAction())
					+"操作失败";
		}
		UserMessage userMessage  = new UserMessage();
		userMessage.setUserId(userMgrOperate.getUserId());
		userMessage.setUserMsgContent(content);
		userMessage.setUserMsgSendTime(DateUtil.getSysDate());
		UserMessageMapper userMessageMapper=template.getMapper(UserMessageMapper.class);
		userMessageMapper.insert(userMessage);
	}

	@Override
	public String mdyServPwd(UserProdInstVo vo) throws PaasException {
		long userServId = vo.getUserServId();
		UserProdInstMapper userProdInstMapper = template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst = userProdInstMapper.selectByPrimaryKey(userServId);
		if (null == userProdInst) {
			throw new PaasException("用户产品实例不存在");
		}
		String prodId = userProdInst.getUserServiceId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
		
		
//		String address = CacheUtils.getValueByKey("IPAAS-UAC.SERVICE") +prodProduct.getProdMdypwdRestfull();
		String address = SystemConfigHandler.configMap.get("IPAAS-UAC.SERVICE.IP_PORT_SERVICE")+prodProduct.getProdMdypwdRestfull();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}	
		String param = "userId="+vo.getUserId()+"&serviceId="+userProdInst.getUserServIpaasId()
	            +"&newPwd="+vo.getNewPwd()+"&oldPwd="+vo.getOldPwd();	
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+param);
		String result  = HttpRequestUtil.sendPost(address, param);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("服务异常");
		}
		RestfullReturn restfullReturn = JSonUtil.fromJSon(result, RestfullReturn.class);
		String resultCode = restfullReturn.getResultCode();
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL.equals(resultCode)){
			throw new PaasException("修改密码错误，请确认原密码是否输入错误");
		}

		// 写用户管理操作
		UserMgrOperate userMgrOperate = new UserMgrOperate();
		userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.MDYPWD);
		userMgrOperate.setUserUpdateBefore(vo.getOldPwd());
		userMgrOperate.setUserUpdateAfter(vo.getOldPwd());
		this.makeUserMgrOperate(userProdInst, resultCode, userMgrOperate);
		this.saveUserMgrOperate(userMgrOperate);
        return resultCode;
	}

	@Override
	public String fullClear(UserProdInstVo vo)  throws PaasException {
		long userServId = vo.getUserServId();
		UserProdInstMapper userProdInstMapper = template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst = userProdInstMapper.selectByPrimaryKey(userServId);
		if (null == userProdInst) {
			throw new PaasException("用户产品实例不存在");
		}
		String prodId = userProdInst.getUserServiceId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
		
	
//		String address = CacheUtils.getValueByKey("PASS.SERVICE") + prodProduct.getProdFullclearRestfull();
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdFullclearRestfull();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		RestfullReq restfullReq = new RestfullReq();
		restfullReq.setUserId(vo.getUserId());
		restfullReq.setServiceId(userProdInst.getUserServIpaasId());
		restfullReq.setApplyType("cleanAll");
		String param = JSonUtil.toJSon(restfullReq);
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+param);
		String result  = HttpClientUtil.send(address, param);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("服务异常");
		}
		RestfullReturn restfullReturn = JSonUtil.fromJSon(result, RestfullReturn.class);
		String resultCode = restfullReturn.getResultCode();
		// 写用户管理操作
		UserMgrOperate userMgrOperate = new UserMgrOperate();
		userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.FULLCLEAR);
		this.makeUserMgrOperate(userProdInst, resultCode, userMgrOperate);
		this.saveUserMgrOperate(userMgrOperate);
        return resultCode;
	}

	@Override
	public List<DocumentVo> selectDocumentByKey(UserProdInstVo vo)  throws PaasException {
		long userServId = vo.getUserServId();
		UserProdInstMapper userProdInstMapper = template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst = userProdInstMapper.selectByPrimaryKey(userServId);
		if (null == userProdInst) {
			throw new PaasException("用户产品实例不存在");
		}
		String prodId = userProdInst.getUserServiceId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
		
		
//		String address = CacheUtils.getValueByKey("PASS.SERVICE") + prodProduct.getProdSeltedkeyRestfull();
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdSeltedkeyRestfull();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		RestfullReq restfullReq = new RestfullReq();
		restfullReq.setUserId(vo.getUserId());
		restfullReq.setServiceId(userProdInst.getUserServIpaasId());
		restfullReq.setApplyType("getRecord");
		restfullReq.setKey(vo.getKey());
		String param = JSonUtil.toJSon(restfullReq);	
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+param);
		String result = HttpClientUtil.send(address, param);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("服务异常");
		}
		DocumentVo documentVo = new Gson().fromJson(result, DocumentVo.class);
		String resultCode = documentVo.getResultCode();
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL.equals(resultCode)){
			throw new PaasException(documentVo.getResultMsg());
		}		
		List<DocumentVo> documentVoist = new ArrayList<DocumentVo>();
		documentVoist.add(documentVo);
		return documentVoist;
	}

	@Override
	public String keyClear(UserProdInstVo vo) throws PaasException {
		long userServId = vo.getUserServId();
		UserProdInstMapper userProdInstMapper = template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst = userProdInstMapper.selectByPrimaryKey(userServId);
		if (null == userProdInst) {
			throw new PaasException("用户产品实例不存在");
		}
		String prodId = userProdInst.getUserServiceId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
		
//		String address = CacheUtils.getValueByKey("PASS.SERVICE") + prodProduct.getProdKeyclearRestfull();
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdKeyclearRestfull();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}		
		RestfullReq restfullReq = new RestfullReq();
		restfullReq.setUserId(vo.getUserId());
		restfullReq.setServiceId(userProdInst.getUserServIpaasId());
		restfullReq.setApplyType("cleanOne");
		restfullReq.setKey(vo.getKey());
		String param = JSonUtil.toJSon(restfullReq);
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+param);
		String result  = HttpClientUtil.send(address, param);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("服务异常");
		}
		RestfullReturn restfullReturn = JSonUtil.fromJSon(result, RestfullReturn.class);
		String resultCode = restfullReturn.getResultCode();
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL.equals(resultCode)){
			throw new PaasException(restfullReturn.getResultMsg());
		}
		// 写用户管理操作
		UserMgrOperate userMgrOperate = new UserMgrOperate();
		userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.KEYCLEAR);
		userMgrOperate.setUserUpdateBefore(vo.getKey());
		this.makeUserMgrOperate(userProdInst, resultCode, userMgrOperate);
		this.saveUserMgrOperate(userMgrOperate);
        return resultCode;
		
	}

	@Override
	public List<UserProdInstVo> selectDssById(UserProdInstVo selectRequestVo)
			throws PaasException {
		UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
		UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();	
		long userServId = selectRequestVo.getUserServId();
		criteria.andUserServIdEqualTo(userServId);
		UserProdInstMapper UserProdInstMapper = template.getMapper(UserProdInstMapper.class);
		List<UserProdInst> userProdInsts = UserProdInstMapper.selectByExample(userProdInstCriteria);
		List<UserProdInstVo> userProdInstVoist = new ArrayList<UserProdInstVo>();
		if (userProdInsts != null && userProdInsts.size() > 0) {
			for (int i = 0; i < userProdInsts.size(); i++) {
				UserProdInstVo userProdInstVo = new UserProdInstVo();
				BeanUtils.copyProperties(userProdInsts.get(i), userProdInstVo);
				// 获取已使用量、产品名称
				getAmountUsed(userProdInstVo);
				//获取单文件大小、服务名称
				getSingleFileSize(userProdInstVo);				
				userProdInstVoist.add(userProdInstVo);
			}
		}
		return userProdInstVoist;
	}

	@Override
	public List<ProdMenuVo> queryLeftMenuList(ProdMenuVo selectRequestVo)
			throws PaasException {
		UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
		UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();		
		criteria.andUserIdEqualTo(selectRequestVo.getUserId());
		criteria.andUserServiceIdNotEqualTo("13");
		criteria.andUserServRunStateNotEqualTo(Constants.UserProdInst.UserServRunState.CANCEL);
		
		UserProdInstCriteria.Criteria criteria2 = userProdInstCriteria.createCriteria();		
		criteria2.andUserIdEqualTo(selectRequestVo.getUserId());
		criteria2.andUserServRunStateIsNull();
		criteria2.andUserServiceIdNotEqualTo("13");
		userProdInstCriteria.or(criteria2);		
		userProdInstCriteria.setOrderByClause(" user_serv_type asc");
		UserProdInstMapper UserProdInstMapper = template.getMapper(UserProdInstMapper.class);
		List<UserProdInst> userProdInsts = UserProdInstMapper.selectByExample(userProdInstCriteria);
		
		List<String> prodIdList = new ArrayList<String>();		
		if (userProdInsts != null && userProdInsts.size() > 0) {
			String prodId = null;
			for (int i = 0; i < userProdInsts.size(); i++) {
				
				prodId = userProdInsts.get(i).getUserServiceId();
				if(!prodIdList.contains(prodId)){
					prodIdList.add(prodId);
				}								
			}
		}
		
		List<ProdMenuVo> prodMenuVoist = new ArrayList<ProdMenuVo>();
		if (prodIdList != null && prodIdList.size() > 0) {
			for (int i = 0; i < prodIdList.size(); i++) {
				ProdMenuVo prodMenuVo = new ProdMenuVo();
				prodMenuVo.setProdId(prodIdList.get(i));								
				prodMenuVoist.add(prodMenuVo);
			}
			
			for (int i = 0; i < prodMenuVoist.size(); i++) {
				ProdMenuVo prodMenuVo = prodMenuVoist.get(i);
				getProdInfo(prodMenuVo);
				getConsoleUrl(prodMenuVo);
			}			
		}		
		
		return prodMenuVoist;
	}
	
	public void getProdInfo(ProdMenuVo prodMenuVo)
			throws PaasException {
		String prodId = prodMenuVo.getProdId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);		
		prodMenuVo.setProdName(prodProduct.getProdName());
		prodMenuVo.setProdType(prodProduct.getProdType());
		

	}
	
	public void getConsoleUrl(ProdMenuVo prodMenuVo)
			throws PaasException {					
//		String consoleUrl = CacheUtils.getOptionByKey("IPAAS-WEB.CONSOLE_URL",prodMenuVo.getProdId());
		String consoleUrl = SystemConfigHandler.configMap.get("IPAAS-WEB.CONSOLE_URL."+prodMenuVo.getProdId());

		prodMenuVo.setConsoleUrl(consoleUrl);
	}

	@Override
	public String modifyConfiguration(String params) throws NumberFormatException, PaasException, IOException, URISyntaxException {
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort(Constants.ProdProduct.ProdId.DSS));
		
//		String address=CacheUtils.getValueByKey("PASS.SERVICE")+prodProduct.getProdBindRestful();//修改DSS配置
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdBindRestful();

		if(StringUtil.isBlank(address)){
			throw new PaasException("产品的的服务地址为空");
		}
		JSONObject object=new JSONObject(params);
		object.put("applyType", "modify");
		Long userServId=Long.parseLong(object.getString("userServId"));
		if(userServId==null||userServId==0){
			throw new PaasException("用户服务标识为空");
		}
		object.remove("userServId");
		String data=object.toString();
		
		logger.info("DSS修改配置入参:"+data);
		logger.info("DSS修改配置接口url:"+address);
		String result=HttpClientUtil.sendPostRequest(address, data);
		if(StringUtil.isBlank(result)){
			throw new PaasException("DSS修改配置信息异常");
		}
		JSONObject resultinfo=new JSONObject(result);
		if(resultinfo.getString("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL)){
			throw new PaasException(resultinfo.getString("resultMsg"));
		}else{
			UserProdInst userProdInst=iUserProdInstSv.selectUserProdInstsById(userServId);
			String oldParam=userProdInst.getUserServParam();
			JSONObject pobject=new JSONObject(userProdInst.getUserServParam());
			pobject.put("capacity", object.getString("size"));
			pobject.put("singleFileSize", object.getString("limitFileSize"));
			String newParam=pobject.toString();
			userProdInst.setUserServParam(newParam);
			int resultid=iUserProdInstSv.updateUserprodInstById(userProdInst);
			if(resultid==0){
				throw new PaasException("修改DSS配置信息失败");
			}
			UserMgrOperate userMgrOperate=new UserMgrOperate();
			userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.ModifyConfiguration);
			userMgrOperate.setUserUpdateBefore(oldParam);
			userMgrOperate.setUserUpdateAfter(newParam);
			this.makeUserMgrOperate(userProdInst, resultinfo.getString("resultCode"), userMgrOperate);
			this.saveUserMgrOperate(userMgrOperate);
		}
		
		
		
		
		return result;
	}
	
	 

}
