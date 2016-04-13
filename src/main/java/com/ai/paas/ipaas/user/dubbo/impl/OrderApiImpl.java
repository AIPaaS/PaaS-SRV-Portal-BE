package com.ai.paas.ipaas.user.dubbo.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.user.constants.ExceptionConstants;
import com.ai.paas.ipaas.user.dubbo.interfaces.IOrderApi;
import com.ai.paas.ipaas.user.exception.BusinessException;
import com.ai.paas.ipaas.user.service.IOrderSv;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.StringUtil;
import com.ai.paas.ipaas.user.utils.gson.GsonUtil;
import com.ai.paas.ipaas.user.vo.OrderDataVo;
import com.ai.paas.ipaas.user.vo.ServResponse;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Transactional
public class OrderApiImpl implements IOrderApi {
	
	private static final Log logger = LogFactory.getLog(OrderApiImpl.class);
	@Autowired
	private IOrderSv orderDetailSv;

	@Override
	public String saveIaasOrder(String param) {
		logger.info(" input OrderApiImpl class saveIaasOrder function ...");
		logger.info(" input params:"+param);			
		ServResponse servResponse  = new ServResponse();
		try {
			if (StringUtil.isBlank(param)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "请求参数为空");
			}
			OrderDataVo orderDataVo = GsonUtil.fromJSon(param, OrderDataVo.class);
			Object object = orderDetailSv.saveIaasOrder(orderDataVo);
			
			servResponse.setResponseCode(ExceptionConstants.Trade.TRADE_SUCCESS);	
			servResponse.setObject(object);

		} catch(BusinessException be){
			logger.error(be.getMessage(), be);	
			servResponse.setResponseCode(be.getErrcode());
			servResponse.setResponseMsg(be.getMessage());;

		}catch (Exception e) {
			logger.error(e.getMessage(), e);	
			servResponse.setResponseCode(ExceptionConstants.Trade.TRADE_FAILURE);
			servResponse.setResponseMsg("系统繁忙，请稍后重试");
		}
		String responseJson = GsonUtil.toJSon(servResponse);
		
		logger.info(" output json:"+responseJson);
		logger.info(" output OrderApiImpl class saveIaasOrder function ...");
		return responseJson;
	}

	@Override
	public String saveIaasIntegratedScheme(String param) {
		
		logger.info(" input OrderApiImpl class saveIaasIntegratedScheme function ...");
		logger.info(" input params:"+param);			
		ServResponse servResponse  = new ServResponse();
		try {
			if (StringUtil.isBlank(param)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "请求参数为空");
			}
			Map<String, Object>  paramMap = GsonUtil.fromJSon(param, HashMap.class);
			Object object = orderDetailSv.saveIaasIntegratedScheme(paramMap);
			
			servResponse.setResponseCode(ExceptionConstants.Trade.TRADE_SUCCESS);	

		} catch(BusinessException be){
			logger.error(be.getMessage(), be);	
			servResponse.setResponseCode(be.getErrcode());
			servResponse.setResponseMsg(be.getMessage());;

		}catch (Exception e) {
			logger.error(e.getMessage(), e);	
			servResponse.setResponseCode(ExceptionConstants.Trade.TRADE_FAILURE);
			servResponse.setResponseMsg("系统繁忙，请稍后重试");
		}
		String responseJson = GsonUtil.toJSon(servResponse);
		
		logger.info(" output json:"+responseJson);
		logger.info(" output OrderApiImpl class saveIaasIntegratedScheme function ...");
		return responseJson;
	}

	@Override
	public String saveIaasOpenParam(String param) {
		logger.info(" input OrderApiImpl class saveIaasOpenParam function ...");
		logger.info(" input params:"+param);			
		ServResponse servResponse  = new ServResponse();
		try {
			if (StringUtil.isBlank(param)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "请求参数为空");
			}
			Map<String, Object>  paramMap = GsonUtil.fromJSon(param, HashMap.class);
			Object object = orderDetailSv.saveIaasOpenParam(paramMap);
			
			servResponse.setResponseCode(ExceptionConstants.Trade.TRADE_SUCCESS);	

		} catch(BusinessException be){
			logger.error(be.getMessage(), be);	
			servResponse.setResponseCode(be.getErrcode());
			servResponse.setResponseMsg(be.getMessage());;

		}catch (Exception e) {
			logger.error(e.getMessage(), e);	
			servResponse.setResponseCode(ExceptionConstants.Trade.TRADE_FAILURE);
			servResponse.setResponseMsg("系统繁忙，请稍后重试");
		}
		String responseJson = GsonUtil.toJSon(servResponse);
		
		logger.info(" output json:"+responseJson);
		logger.info(" output OrderApiImpl class saveIaasOpenParam function ...");
		return responseJson;
	}

	@Override
	public String updateIaasOrder(String param) {
		logger.info(" input OrderApiImpl class updateIaasOrderProdparam function ...");
		logger.info(" input params:"+param);			
		ServResponse servResponse  = new ServResponse();
		try {
			if (StringUtil.isBlank(param)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "请求参数为空");
			}
			OrderDataVo orderDataVo = GsonUtil.fromJSon(param, OrderDataVo.class);
			Object object = orderDetailSv.updateIaasOrderProdparam(orderDataVo);
			
			servResponse.setResponseCode(ExceptionConstants.Trade.TRADE_SUCCESS);	
			servResponse.setObject(object);

		}catch (Exception e) {
			logger.error(e.getMessage(), e);	
			servResponse.setResponseCode(ExceptionConstants.Trade.TRADE_FAILURE);
			servResponse.setResponseMsg("系统繁忙，请稍后重试");
		}
		String responseJson = GsonUtil.toJSon(servResponse);
		
		logger.info(" output json:"+responseJson);
		logger.info(" output OrderApiImpl class updateIaasOrderProdparam function ...");
		return responseJson;
	}
}
