package com.ai.paas.ipaas.user.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.ai.paas.ipaas.user.dto.MdsRestfullReq;
import com.ai.paas.ipaas.user.dto.MdsSearchRestfullReq;
import com.ai.paas.ipaas.user.dto.MdsSearchRestfullRes;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.RestfullReq;
import com.ai.paas.ipaas.user.dto.RestfullReturn;
import com.ai.paas.ipaas.user.dto.UserMgrOperate;
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.MdsSearchMessageVo;
import com.ai.paas.ipaas.user.dubbo.vo.MdsUserPageVo;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IMdsConsoleSv;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.IUserMgrOperateSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;
import com.google.gson.Gson;

@Service
@Transactional 
public class MdsConsoleSvImpl implements IMdsConsoleSv{
	
	private final Log logger = LogFactory.getLog(MdsConsoleSvImpl.class);
	@Autowired
	private SqlSessionTemplate template;
	@Autowired
	private IProdProductSv iProdProductSv;	
	@Autowired
	private ISysParamSv iSysParamSv;
	@Autowired
	private IUserMgrOperateSv iUserMgrOperateSv;	

	@Override
	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)
			throws PaasException {
		// TODO Auto-generated method stub
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
				// 获取容量
				getCapacity(userProdInsts.get(i), userProdInstVo);
				userProdInstVoist.add(userProdInstVo);
			}
		}
		return userProdInstVoist;
	}

	private void getCapacity(UserProdInst userProdInst, UserProdInstVo userProdInstVo) throws PaasException{
		logger.info("查询缓存容量");
		if (userProdInst == null) {
			throw new PaasException("用户产品实例产品为空");
		}
		String prodId = userProdInstVo.getUserServiceId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		String userServParam = userProdInst.getUserServParam();
		UserProdInstVo vo = JSonUtil.fromJSon(userServParam, UserProdInstVo.class);
		userProdInstVo.setCapacity(vo.getCapacity());
	}
	
	
	@Override
	public List<UserProdInstVo> selectMdsById(UserProdInstVo selectRequestVo)
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
				userProdInstVo.getUserServParam();
				
				getAmountUsed(userProdInstVo);
				
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
			
		MdsRestfullReq restfullReq = new MdsRestfullReq();
		restfullReq.setUserId(userProdInstVo.getUserId());
		restfullReq.setServiceId(userProdInstVo.getUserServIpaasId());
		restfullReq.setApplyType( "topicUsage");
		
		Map<String , String> map = new HashMap<String,String>();
		String str = userProdInstVo.getUserServParam();
		map = new Gson().fromJson(str, map.getClass());
		restfullReq.setTopicEnName(map.get("topicEnName"));
		String param = JSonUtil.toJSon(restfullReq);
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+param);
		String result = HttpClientUtil.send(address, param);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("服务异常");
		}
		MdsUserPageVo pageVo = new Gson().fromJson(result, MdsUserPageVo.class);
		userProdInstVo.setMdsUserPageVo(pageVo);
		

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
		
//		String address = CacheUtils.getValueByKey("PASS.SERVICE") + prodProduct.getProdCancleRestfull(); // 获取注销restful
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdCancleRestfull();
		
		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		MdsRestfullReq req = new MdsRestfullReq();
		RestfullReq restfullReq = new RestfullReq();
		req.setUserId(vo.getUserId());
		req.setServiceId(userProdInst.getUserServIpaasId());
		
		req.setApplyType("cancel");
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

	@Override
	public MdsSearchRestfullRes searchMessage(MdsSearchMessageVo vo) throws PaasException{
		// TODO Auto-generated method stub
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
		
		
//		String address = CacheUtils.getValueByKey("PASS.SERVICE") + prodProduct.getProdKeyclearRestfull(); // 获取注销restful
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdKeyclearRestfull();
		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		MdsRestfullReq req = new MdsRestfullReq();
		MdsSearchRestfullReq restfullReq = new MdsSearchRestfullReq();
		restfullReq.setUserId(vo.getUserId());
		restfullReq.setServiceId(userProdInst.getUserServIpaasId());
		restfullReq.setOffset(vo.getOffset());
		restfullReq.setPartition(vo.getPartition());
		restfullReq.setTopicEnName(vo.getTopicEnName());
		restfullReq.setApplyType("getMessage");
		String param = JSonUtil.toJSon(restfullReq);
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+param);
		String result = HttpClientUtil.send(address, param);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("服务异常");
		}
		MdsSearchRestfullRes restfullReturn = JSonUtil.fromJSon(result, MdsSearchRestfullRes.class);
		String resultCode = restfullReturn.getResultCode();
		
        return restfullReturn;
	}

	@Override
	public String resendMessage(String params) throws NumberFormatException, PaasException, IOException, URISyntaxException {
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort(Constants.ProdProduct.ProdId.MDS));
		
		JSONObject object=new JSONObject(params);
		object.put("applyType", "send");
//		String address=CacheUtils.getValueByKey("PASS.SERVICE")+prodProduct.getProdFiltertableRestful(); //重发消息；
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdFiltertableRestful();
		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+object.toString());
		String result=HttpClientUtil.sendPostRequest(address, object.toString());
		logger.info("调用服务接口出参："+result);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("MDS重发信息异常");
		}
		JSONObject resultinfo=new JSONObject(result);
		if(resultinfo.get("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL)){
			throw new PaasException(resultinfo.getString("resultMsg"));
		}
		return result;
		
		 
	}

	@Override
	public String skipMessage(String params) throws NumberFormatException, PaasException, IOException, URISyntaxException {
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort(Constants.ProdProduct.ProdId.MDS));
		
		JSONObject object=new JSONObject(params);
		object.put("applyType", "adjust");
		String data=object.toString();
//		String address = CacheUtils.getValueByKey("PASS.SERVICE") + prodProduct.getProdUnbindRestful();//跳过消息;  
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") + prodProduct.getProdUnbindRestful();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+data);
		String result=HttpClientUtil.sendPostRequest(address,data);
		logger.info("调用服务接口出参："+result);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("MDS跳过信息异常");
		} 
		JSONObject resultinfo=new JSONObject(result);
		if(resultinfo.get("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL)){
			throw new PaasException(resultinfo.getString("resultMsg"));
		}
		return result;
	}
	
}
