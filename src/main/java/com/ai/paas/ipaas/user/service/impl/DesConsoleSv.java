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
import com.ai.paas.ipaas.user.dubbo.vo.DesBindRequest;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IDesConsoleSv;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;
import com.google.gson.Gson;
@Service
@Transactional 
public class DesConsoleSv implements IDesConsoleSv{
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private SqlSessionTemplate template;
	@Autowired
	private IProdProductSv iProdProductSv;	
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

	@Override
	public Map<String, String> toDesBind(DesBindRequest desBindRequest)
			throws PaasException {
		Map<String, String> result=new HashMap<String, String>();		
		
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort("14"));
//		String address=CacheUtils.getValueByKey("PASS.SERVICE")+prodProduct.getProdBindRestful();
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdBindRestful();

		String params=JSonUtil.toJSon(desBindRequest);
		logger.info("des绑定地址："+address);
		logger.info("des绑定入参："+params);
		String data="";
		try {
			data=HttpClientUtil.sendPostRequest(address, params);
			logger.info("DES绑定结果:"+data);
		} catch (IOException e) {
			 String errorMessage=e.getMessage();
			 logger.error(errorMessage,e);
			 throw new PaasException("服务绑定异常");
		} catch (URISyntaxException e) {
			 String errorMessage=e.getMessage();
			 logger.error(errorMessage,e);
			 throw new PaasException("服务绑定异常");
		}
		Gson gson=new Gson();
		result=gson.fromJson(data, Map.class);
		if(result.get("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL))
		{
			throw new PaasException(result.get("resultMsg"));
		}
		
		 
		
		return result;
	}

	@Override
	public String toGetBound(String userId) throws PaasException {
		
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort("14"));
//		String address=CacheUtils.getValueByKey("PASS.SERVICE")+prodProduct.getProdGetboundRestful();
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdGetboundRestful();

		JSONObject parameter=new JSONObject();
		parameter.put("userId", userId);
		String result="";
		try {
			logger.info("获取DES绑定服务地址"+address);
			logger.info("取DES绑定服务入参："+parameter.toString());
			result=HttpClientUtil.sendPostRequest(address, parameter.toString());
			logger.info("DES绑定服务结果："+result);
		} catch (IOException e) {
			String errorMessage=e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("查询绑定服务异常");
		} catch (URISyntaxException e) {
			String errorMessage=e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("查询绑定服务异常");
		}
			
		JSONObject object=new JSONObject();
		object=JsonUtils.parse(result);
		if(object.getString("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL))
		{
			throw new PaasException(object.getString("resultMsg"));
		}
		return result;
	}

	@Override
	public String toDesUnbind(Map<String, String> unBinRequest) throws PaasException {
		
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort("14"));
//		String address= CacheUtils.getValueByKey("PASS.SERVICE") +prodProduct.getProdUnbindRestful();
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdUnbindRestful();

		String params=JSonUtil.toJSon(unBinRequest);
		String result="";
		try {
			logger.info("DES解绑定地址："+address);
			logger.info("DES解绑定入参:"+params);
			result=HttpClientUtil.sendPostRequest(address, params);
			logger.info("DES解绑定输出结果："+result);
		} catch (IOException e) {
			String errorMessage=e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("DES解绑定服务异常");
		} catch (URISyntaxException e) {
			String errorMessage=e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("DES解绑定服务异常");
		}
		JSONObject object=JsonUtils.parse(result);
		if(object.getString("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL))
		{
			throw new PaasException(object.getString("resultMsg"));
		}
		return result;
	}

	@Override
	public String tofilterTable(Map<String, String> filterRequest)
			throws PaasException {
		
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort("14"));
//		String address= CacheUtils.getValueByKey("PASS.SERVICE") +prodProduct.getProdFiltertableRestful();
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdFiltertableRestful();

		String params=JSonUtil.toJSon(filterRequest);
		String result="";
		try {
			logger.info("DES设置观察表地址："+address);
			logger.info("DES设置观察表入参:"+params);
			result=HttpClientUtil.sendPostRequest(address, params);
			logger.info("DES设置观察表结果:"+result);
		} catch (IOException e) {
			String errorMessage=e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("设置观察表服务异常");
		} catch (URISyntaxException e) {
			String errorMessage=e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("设置观察表服务异常");
		}
		JSONObject object=JsonUtils.parse(result);
		if(object.getString("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL))
		{
			throw new PaasException(object.getString("resultMsg"));
		}
		return result;
	}

	@Override
	public String toBoundTableInfo(Map<String, String> request)
			throws PaasException {
		
		ProdProduct prodProduct=iProdProductSv.selectProductByPrimaryKey(Short.parseShort("14"));
//		String address=CacheUtils.getValueByKey("PASS.SERVICE") +prodProduct.getProdGetboundtableinfoRestful();
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdGetboundtableinfoRestful();
		String parameter=JSonUtil.toJSon(request);
		String result="";
		try {
			logger.info("获取DES绑定配置表服务地址"+address);
			logger.info("取DES绑定配置表服务入参："+parameter.toString());
			result=HttpClientUtil.sendPostRequest(address, parameter);
			logger.info("DES绑定服务结果："+result);
		} catch (IOException e) {
			String errorMessage=e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("查询配置表服务异常");
		} catch (URISyntaxException e) {
			String errorMessage=e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("查询配置表服务异常");
		}
			
		JSONObject object=new JSONObject();
		object=JsonUtils.parse(result);
		if(object.getString("resultCode").equals(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL))
		{
			throw new PaasException(object.getString("resultMsg"));
		}
		return result;
		 
	}
	
	
	
	 
	
	


	

}
