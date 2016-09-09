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
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.AtsUsageResultVo;
import com.ai.paas.ipaas.user.dubbo.vo.AtsUserPageVo;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IAtsConsoleSv;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.IUserMgrOperateSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;
import com.google.gson.Gson;
@Service
@Transactional 
public class AtsConsoleSvImpl implements IAtsConsoleSv {
	private final Log logger = LogFactory.getLog(MdsConsoleSvImpl.class);
	@Autowired
	private SqlSessionTemplate template;
	@Autowired
	private IProdProductSv iProdProductSv;	
	@Autowired
	private IUserMgrOperateSv iUserMgrOperateSv;	
	@Autowired
	private ISysParamSv iSysParamSv;
	
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
				// 获取产品信息
				getProdInfo(userProdInstVo);
				getServiceName(userProdInstVo);
				String prodParam = userProdInstVo.getUserServParam();
				String prodBackParam = userProdInstVo.getUserServBackParam();
				Gson gson = new Gson();
				Map<String,String> map = gson.fromJson(prodParam, Map.class);	
				Map<String,Object> mapBack = gson.fromJson(prodBackParam, Map.class);	
				userProdInstVo.setUserServParamMap(map);
				userProdInstVo.setUserServBackParamMap(mapBack);
				if(Constants.ProdProduct.ProdId.ATS.equals(userProdInstVo.getUserServiceId())){
					getSignatureId(userProdInstVo);
				}
				userProdInstVoist.add(userProdInstVo);
			}
		}
		return userProdInstVoist;
	}

	@Override
	public List<UserProdInstVo> selectUserProdInstById(UserProdInstVo selectRequestVo)
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
				// 获取产品信息
				getProdInfo(userProdInstVo);
				getServiceName(userProdInstVo);				
				if(Constants.ProdProduct.ProdId.ATS.equals(userProdInstVo.getUserServiceId())){
					getSignatureId(userProdInstVo);
				}
				userProdInstVoist.add(userProdInstVo);
			}
		}
		return userProdInstVoist;
	}
	
	public void getProdInfo(UserProdInstVo userProdInstVo)
			throws PaasException {
		String prodId = userProdInstVo.getUserServiceId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);		
		userProdInstVo.setProdName(prodProduct.getProdName());
		

	}
	
	public void getServiceName(UserProdInstVo userProdInstVo)
			throws PaasException {
		String prodParam = userProdInstVo.getUserServParam();
		if (StringUtil.isBlank(prodParam)) {
			throw new PaasException("产品参数为空");
		}
	
		Gson gson = new Gson();
		Map<String,String> map = gson.fromJson(prodParam, Map.class);		
		String serviceName = map.get("serviceName");
		if(serviceName == null){
			serviceName="";
		}
		userProdInstVo.setServiceName(serviceName);

	}
	
	public void getSignatureId(UserProdInstVo userProdInstVo)
			throws PaasException {
		String userServBackParam = userProdInstVo.getUserServBackParam();	
	
		Gson gson = new Gson();
		Map<String,String> map = gson.fromJson(userServBackParam, Map.class);		
		String signatureId = map.get("signatureId");
		if(signatureId == null){
			signatureId="";
		}
		userProdInstVo.setSignatureId(signatureId);;

	}

	@Override
	public List<UserProdInstVo> getUsages(UserProdInstVo selectRequestVo) throws PaasException, IOException, URISyntaxException
			 {
		logger.info("查询已使用量");
		List<UserProdInstVo> userProdInstVos=selectUserProdInstById(selectRequestVo);
		Map<String,String> params=new HashMap<String, String>();
		params.put("userId", selectRequestVo.getUserId());
		params.put("applyType", "topicUsage");
		params.put("serviceId", userProdInstVos.get(0).getUserServIpaasId());
		params.put("topicEnName", userProdInstVos.get(0).getSignatureId());
		if(selectRequestVo.getUserServParam()!=null){ //不为空  为异常队列
			 params.put("messageType", "1");
		}else{
			 params.put("messageType","0");
		}
		
		String data=JSonUtil.toJSon(params);
		short prikey=Short.parseShort(selectRequestVo.getUserServiceId());
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(prikey);		
//		String address=CacheUtils.getValueByKey("PASS.SERVICE")+prodProduct.getProdUsedAmountRestfull();
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdUsedAmountRestfull();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+data);
		String result=HttpClientUtil.sendPostRequest(address, data);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("ATS查询使用量服务异常");
		}
		AtsUserPageVo atsUserPageVo=new Gson().fromJson(result, AtsUserPageVo.class);
		if(atsUserPageVo.getResultCode().equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL))
		{
			throw new PaasException(atsUserPageVo.getResultMsg());
		}
		userProdInstVos.get(0).setAtsUserPageVo(atsUserPageVo);
		
		
		return userProdInstVos;
	}

	@Override
	public AtsUsageResultVo searchOneMessage(String params)
			throws PaasException, IOException, URISyntaxException {
		JSONObject object=new JSONObject(params);
		long userServId=Long.parseLong(object.getString("userServId"));
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
//		String address = CacheUtils.getValueByKey("PASS.SERVICE")+ prodProduct.getProdSeltedkeyRestfull();  
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdSeltedkeyRestfull();
		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("userId",object.getString("userId"));
		param.put("applyType", "getMessage");
		param.put("serviceId", userProdInst.getUserServIpaasId());
		param.put("topicEnName", object.getString("topicEnName"));
		param.put("partition", object.getString("partition"));
		param.put("offset", object.get("offset"));
		param.put("messageType", object.getString("messageType"));
		String data=JSonUtil.toJSon(param);
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+data);
		String result=HttpClientUtil.sendPostRequest(address, data);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("获取单条服务异常");
		}
		AtsUsageResultVo atsUsageResultVo=new Gson().fromJson(result, AtsUsageResultVo.class);
		if(atsUsageResultVo.getResultCode()==PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL)
		{
			throw new PaasException(atsUsageResultVo.getResultMsg());
		}
		return atsUsageResultVo;
	}

	@Override
	public String skipMessage(String params) throws NumberFormatException, PaasException, IOException, URISyntaxException {
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort(Constants.ProdProduct.ProdId.ATS));
		
		JSONObject object=new JSONObject(params);
		object.put("applyType", "skip");
		String data=object.toString();
//		String address = CacheUtils.getValueByKey("PASS.SERVICE")+ prodProduct.getProdUnbindRestful();//跳过消息;  
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdUnbindRestful();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+data);
		String result=HttpClientUtil.sendPostRequest(address,data);
		logger.info("调用服务接口出参："+result);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("Ats跳过信息异常");
		}
		JSONObject resultinfo=new JSONObject(result);
		if(resultinfo.get("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL)){
			throw new PaasException(resultinfo.getString("resultMsg"));
		}
		return result;
	}

	@Override
	public String resendMessage(String params) throws NumberFormatException, PaasException, IOException, URISyntaxException {
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort(Constants.ProdProduct.ProdId.ATS));
		
//		String address=CacheUtils.getValueByKey("PASS.SERVICE")+prodProduct.getProdFiltertableRestful(); //重发消息；
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdFiltertableRestful();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		logger.info("调用服务接口url："+address);
		logger.info("调用服务接口入参："+params);
		String result=HttpClientUtil.sendPostRequest(address, params);
		logger.info("调用服务接口出参："+result);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("Ats重发信息异常");
		}
		JSONObject resultinfo=new JSONObject(result);
		if(resultinfo.get("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL)){
			throw new PaasException(resultinfo.getString("resultMsg"));
		}
		return result;
	}
	

	

}
