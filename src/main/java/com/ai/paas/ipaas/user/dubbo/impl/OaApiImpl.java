package com.ai.paas.ipaas.user.dubbo.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.user.constants.ExceptionConstants;
import com.ai.paas.ipaas.user.dubbo.interfaces.IOaApi;
import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.exception.BusinessException;
import com.ai.paas.ipaas.user.service.IOaSv;
import com.ai.paas.ipaas.user.utils.StringUtil;
import com.ai.paas.ipaas.user.utils.gson.GsonUtil;
import com.ai.paas.ipaas.user.vo.ErpProjectVo;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Transactional
public class OaApiImpl implements IOaApi{
	private static final Log logger = LogFactory.getLog(OrderApiImpl.class);
	@Autowired
	private IOaSv oaSv;
	
	@Override
	public String getOaOperators(String param) {
		logger.info(" input OaApiImpl class getOaOperators function ...");
		logger.info(" input params:"+param);		
		Map<String,Object> resMap  = new HashMap<String,Object>();
		try {
			if (StringUtil.isBlank(param)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "请求参数为空");
			}			
			Map<String,Object> paramMap = GsonUtil.fromJSon(param, HashMap.class);
			String busiParam = (String) paramMap.get("param");
			if (StringUtil.isBlank(busiParam)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "param值为空");
			}
			String object = oaSv.getOaOperators(paramMap);
			
			resMap.put("reslut","0");	
			resMap.put("message", object);
		} catch(BusinessException be){
			logger.error(be.getMessage(), be);	
			resMap.put("reslut","1");	
			resMap.put("message", be.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);	
			resMap.put("reslut","1");	
			resMap.put("message", "系统繁忙，请稍后重试");
		}
		String responseJson = GsonUtil.toJSon(resMap);
		logger.info(" output OaApiImpl class getOaOperators function ...");
		logger.info(" output json:"+responseJson);
		return responseJson;
	}

	@Override
	public String oaAuditResultNotify(String param) {
		logger.info(" input OaApiImpl class getOaOperators function ...");
		logger.info(" input params:"+param);		
		Map<String,Object> resMap  = new HashMap<String,Object>();
		try {
			if (StringUtil.isBlank(param)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "请求参数为空");
			}			
			Map<String,Object> paramMap = GsonUtil.fromJSon(param, HashMap.class);
			String applyNbr = (String) paramMap.get("orderDetailId");
			if (StringUtil.isBlank(applyNbr)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "参数: 申请单号值为空");
			}
			String operType = (String) paramMap.get("operType");
			if (StringUtil.isBlank(operType)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "参数: 操作类型值为空");
			}			
			Object object = oaSv.oaAuditResultNotify(paramMap);
			
			resMap.put("reslut","0");	
			resMap.put("message", object);
		} catch(BusinessException be){
			logger.error(be.getMessage(), be);	
			resMap.put("reslut","1");	
			resMap.put("message", be.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);	
			resMap.put("reslut","1");	
			resMap.put("message", "系统繁忙，请稍后重试");
		}
		String responseJson = GsonUtil.toJSon(resMap);
		logger.info(" output OaApiImpl class getOaOperators function ...");
		logger.info(" output json:"+responseJson);
		return responseJson;
	}

	@Override
	public String oaAuditPremise(String param) {
		logger.info(" input OaApiImpl class oaAuditPremise function ...");
		logger.info(" input params:"+param);		
		Map<String,Object> resMap  = new HashMap<String,Object>();
		try {
			if (StringUtil.isBlank(param)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "请求参数为空");
			}			
			Map<String,Object> paramMap = GsonUtil.fromJSon(param, HashMap.class);
			String orderDetailId = (String) paramMap.get("orderDetailId");
			if (StringUtil.isBlank(orderDetailId)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "参数: 申请单号值为空");
			}
						
			resMap = (Map<String, Object>) oaSv.oaAuditPremise(paramMap);			
			
		} catch(BusinessException be){
			logger.error(be.getMessage(), be);	
			resMap.put("reslut","1");	
			resMap.put("message", be.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);	
			resMap.put("reslut","1");	
			resMap.put("message", "系统繁忙，请稍后重试");
		}
		String responseJson = GsonUtil.toJSon(resMap);
		logger.info(" output OaApiImpl class oaAuditPremise function ...");
		logger.info(" output json:"+responseJson);
		return responseJson;
	}

	@Override
	public String getErpProjects(String param) {
		logger.info(" input OaApiImpl class getErpProjects function ...");
		logger.info(" input params:"+param);		
		PageResult<ErpProjectVo> pageResult = new PageResult<ErpProjectVo>();	
		try {
			if (StringUtil.isBlank(param)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "请求参数为空");
			}			
			Map<String,String> paramMap = GsonUtil.fromJSon(param, HashMap.class);
							
			pageResult =  oaSv.getErpProjects(paramMap);						

			
		} catch(BusinessException be){
			logger.error(be.getMessage(), be);	
		}catch (Exception e) {
			logger.error(e.getMessage(), e);	
		}
		String responseJson = GsonUtil.toJSon(pageResult);
		logger.info(" output OaApiImpl class getErpProjects function ...");
		logger.info(" output json:"+responseJson);
		return responseJson;
	}

}
