package com.ai.paas.ipaas.user.service.impl;

import java.io.IOException;
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

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IIdpsConsoleSv;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.IUserProdInstSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;
import com.google.gson.Gson;
@Service
@Transactional 
public class IdpsConsoleSvImpl implements IIdpsConsoleSv {
	private final Log logger = LogFactory.getLog(IdpsConsoleSvImpl.class);
	@Autowired
	private SqlSessionTemplate template;
	@Autowired
	private IProdProductSv iProdProductSv;	
	@Autowired
	private IUserProdInstSv iUserProdInstSv;
	
	@Override
	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)
			throws PaasException {
		UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
		UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();		
		criteria.andUserIdEqualTo(vo.getUserId()).andUserProdBynameEqualTo("IDPS");
		criteria.andUserServRunStateNotEqualTo(Constants.UserProdInst.UserServRunState.CANCEL);
		
		UserProdInstCriteria.Criteria criteria2 = userProdInstCriteria.createCriteria();		
		criteria2.andUserIdEqualTo(vo.getUserId());
		criteria2.andUserProdBynameEqualTo("IDPS");
		criteria2.andUserServRunStateIsNull();		
		userProdInstCriteria.or(criteria2);		
		
		UserProdInstMapper UserProdInstMapper = template.getMapper(UserProdInstMapper.class);
		List<UserProdInst> userProdInsts = UserProdInstMapper.selectByExample(userProdInstCriteria);
		List<UserProdInstVo> userProdInstVoist = new ArrayList<UserProdInstVo>();
		if (userProdInsts != null && userProdInsts.size() > 0) {
			for (int i = 0; i < userProdInsts.size(); i++) {
				UserProdInstVo userProdInstVo = new UserProdInstVo();
				BeanUtils.copyProperties(userProdInsts.get(i), userProdInstVo);
				
				//获得ProName-------start
				String prodId = userProdInstVo.getUserServiceId();
				if (StringUtil.isBlank(prodId)) {
					throw new PaasException("用户产品实例产品编码为空");
				}
				short priKey = Short.parseShort(prodId);
				ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
				userProdInstVo.setProdName(prodProduct.getProdName());
				//获得ProName-------end
				
				//获得UserServParam字段中对应map的值---------start
				String prodParam = userProdInstVo.getUserServParam();
				String prodBackParam = userProdInstVo.getUserServBackParam();
				Gson gson = new Gson();
				Map<String,String> map = gson.fromJson(prodParam, Map.class);	
				Map<String,Object> mapBack = gson.fromJson(prodBackParam, Map.class);	
				String serviceName = map.get("serviceName");
				if(serviceName == null){
					serviceName="";
				}
				userProdInstVo.setServiceName(serviceName);
				//获得UserServParam字段中对应map的值---------end
				userProdInstVo.setUserServParamMap(map);
				userProdInstVo.setUserServBackParamMap(mapBack);
				userProdInstVo.setUserServBackParam(prodBackParam.replaceAll("\"", ""));
				userProdInstVoist.add(userProdInstVo);
			}
		}
		return userProdInstVoist;
	}

	public ResponseHeader stopIdpsContainer(String paraprodBackPara)  throws PaasException{
		ResponseHeader responseHeader = new ResponseHeader();
		logger.info("调用停止idps容器服务接口");			
		String prodId = "16";
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
//		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdStopRestfull();
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdStopRestfull();
		if (StringUtil.isBlank(address)) {
			throw new PaasException("调用停止idps容器服务接口");
		}	
		String param = paraprodBackPara;//this.createServOpenParam(orderDetail); //调用统一方法	
		
		String result ="";
		logger.info("调用停止idps容器服务接口url："+address);
		logger.info("调用停止idps容器服务接口入参："+param);

		try {
			result =HttpClientUtil.sendPostRequest(address, param);
			logger.info("调用停止idps容器服务接口结果："+result);
			
			JSONObject json = new JSONObject();
			json=JsonUtils.parse(result);
			responseHeader.setResultCode(json.getString("resultCode"));
		} catch (IOException e) {
			String errorMessage = e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("停止idps容器服务异常");
		} catch (URISyntaxException e) {
			String errorMessage = e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("停止idps容器服务异常");
		}
		return responseHeader;
	}

	public ResponseHeader startIdpsContainer(String paraprodBackPara)   throws PaasException{
		ResponseHeader responseHeader = new ResponseHeader();
		logger.info("调用启动idps容器服务接口");			
		String prodId = "16";
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdStartRestfull();
//		String address = "http://localhost:10888/services/idps/manage/start";
		if (StringUtil.isBlank(address)) {
			throw new PaasException("调用启动idps容器服务接口");
		}	
		String param = paraprodBackPara;//this.createServOpenParam(orderDetail); //调用统一方法	
		
		String result ="";
		logger.info("调用启动idps容器服务接口url："+address);
		logger.info("调用启动idps容器服务接口入参："+param);

		try {
			result =HttpClientUtil.sendPostRequest(address, param);
			logger.info("调用启动idps容器服务接口结果："+result);
			
			JSONObject json = new JSONObject();
			json=JsonUtils.parse(result);
			responseHeader.setResultCode(json.getString("resultCode"));
		} catch (IOException e) {
			String errorMessage = e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("启动idps容器服务异常");
		} catch (URISyntaxException e) {
			String errorMessage = e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("启动idps容器服务异常");
		}
		
		return responseHeader;
	}

	
	public ResponseHeader cleanIdpsContainer(String paraprodBackPara,String destroy)  throws PaasException{
		ResponseHeader responseHeader = new ResponseHeader();
		logger.info("调用删除idps容器服务接口");			
		String prodId = "16";
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
//		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdFullclearRestfull();
		String address = null;
		if("yes".equals(destroy)){
			address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdKeyclearRestfull();
		}else {
			address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdFullclearRestfull();
		}
		if (StringUtil.isBlank(address)) {
			throw new PaasException("调用删除idps容器服务接口");
		}	
		String param = paraprodBackPara;//this.createServOpenParam(orderDetail); //调用统一方法	
		
		String result ="";
		logger.info("调用删除idps容器服务接口url："+address);
		logger.info("调用删除idps容器服务接口入参："+param);

		try {
			result =HttpClientUtil.sendPostRequest(address, param);
			logger.info("调用删除idps容器服务接口结果："+result);
			
			JSONObject json = new JSONObject();
			json=JsonUtils.parse(result);
			responseHeader.setResultCode(json.getString("resultCode"));
		} catch (IOException e) {
			String errorMessage = e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("删除idps容器服务异常");
		} catch (URISyntaxException e) {
			String errorMessage = e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("删除idps容器服务异常");
		}
		
		return responseHeader;
	}
	
	public ResponseHeader upgradelIdpsContainer(String paraprodBackPara)  throws PaasException{
		ResponseHeader responseHeader = new ResponseHeader();
		logger.info("调用升级idps容器服务接口");			
		String prodId = "16";
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
//		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdSubscribeRestful();
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdSubscribeRestful();
		if (StringUtil.isBlank(address)) {
			throw new PaasException("调用升级idps容器服务接口");
		}	
		String param = paraprodBackPara;//this.createServOpenParam(orderDetail); //调用统一方法	
		
		String result ="";
		logger.info("调用升级idps容器服务接口url："+address);
		logger.info("调用升级idps容器服务接口入参："+param);

		try {
			result =HttpClientUtil.sendPostRequest(address, param);
			logger.info("调用升级idps容器服务接口结果："+result);
			
			JSONObject json = new JSONObject();
			json=JsonUtils.parse(result);
			responseHeader.setResultCode(json.getString("resultCode"));
		} catch (IOException e) {
			String errorMessage = e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("升级idps容器服务异常");
		} catch (URISyntaxException e) {
			String errorMessage = e.getMessage();
			logger.error(errorMessage,e);
			throw new PaasException("升级idps容器服务异常");
		}
		
		return responseHeader;
	}
	
	@Override
	public ResponseHeader upgradeContainer(String paraprodBackPara) throws PaasException {
		ResponseHeader responseHeader = new ResponseHeader();
		logger.info("调用升级idps容器服务接口");
		logger.info("调用升级idps容器服务接口---------第一步：调用 停用docker容器的命令");
		stopIdpsContainer(paraprodBackPara);
		logger.info("调用升级idps容器服务接口---------第二步：调用 删除docker容器的命令");
		cleanIdpsContainer(paraprodBackPara,"no");
		logger.info("调用升级idps容器服务接口---------第三步： 调用 创建docker容器的命令");
		responseHeader = upgradelIdpsContainer(paraprodBackPara);
		return responseHeader;
	}

	@Override
	public ResponseHeader destroyContainer(String paraprodBackPara) throws PaasException {
		ResponseHeader responseHeader = new ResponseHeader();
		logger.info("调用销毁idps容器服务接口---------第一步：调用 更新创建docker容器时，插入表记录的状态为注销");
		updateUserprodInstById(paraprodBackPara);
		logger.info("调用销毁idps容器服务接口---------第二步： 调用 停用docker的命令");
		stopIdpsContainer(paraprodBackPara);
		logger.info("调用销毁idps容器服务接口---------第三步： 调用 删除docker的命令，及清除zk");
		responseHeader = cleanIdpsContainer(paraprodBackPara,"yes");
		return responseHeader;
	}
	
	//更新订单实例的状态
	public void updateUserprodInstById(String paraprodBackPara)  throws PaasException{
		String userServId = paraprodBackPara.substring(paraprodBackPara.indexOf("userServId")+11,paraprodBackPara.length()-1);;
		UserProdInst uerProdInst =iUserProdInstSv.selectUserProdInstsById(Long.valueOf(userServId));
		uerProdInst.setUserServRunState("2");
		iUserProdInstSv.updateUserprodInstById(uerProdInst);
	}
	
}
