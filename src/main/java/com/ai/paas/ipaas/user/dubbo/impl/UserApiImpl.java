package com.ai.paas.ipaas.user.dubbo.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.user.constants.ExceptionConstants;
import com.ai.paas.ipaas.user.dubbo.interfaces.IUserApi;
import com.ai.paas.ipaas.user.exception.BusinessException;
import com.ai.paas.ipaas.user.service.IUserSv;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.HttpRequestUtil;
import com.ai.paas.ipaas.user.utils.StringUtil;
import com.ai.paas.ipaas.user.utils.gson.GsonUtil;
import com.ai.paas.ipaas.user.utils.oamd5.OaMd5Util;
import com.ai.paas.ipaas.user.vo.ServResponse;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Transactional
public class UserApiImpl implements IUserApi {
	
	private static final Log logger = LogFactory.getLog(UserApiImpl.class);
	
	@Autowired
	private IUserSv iUserSv;

	@Override
	public String getAiEmployeeInfo(String param) {
		logger.info(" input params:"+param);		
		ServResponse servResponse  = new ServResponse();
		try {
			if (StringUtil.isBlank(param)) {
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NULL, "请求参数为空");
			}
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap = GsonUtil.fromJSon(param, Map.class);
		
			Object object = null;
			object = iUserSv.getAiEmployeeInfo(paramMap);
			
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
		logger.info("output json:"+responseJson);
		return responseJson;
	}

}
