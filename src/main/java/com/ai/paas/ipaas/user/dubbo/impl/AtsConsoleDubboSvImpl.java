package com.ai.paas.ipaas.user.dubbo.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.interfaces.IAtsConsoleDubboSv;
import com.ai.paas.ipaas.user.dubbo.vo.AtsSearchUsageVo;
import com.ai.paas.ipaas.user.dubbo.vo.AtsUsageResultVo;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IAtsConsoleSv;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class AtsConsoleDubboSvImpl implements IAtsConsoleDubboSv {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private IAtsConsoleSv iAtsConsoleSv;
	
	@Override
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInsts(
			SelectWithNoPageRequest<UserProdInstVo> request) {
		
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		try{
			this.validate(request.getSelectRequestVo());
			resultList = iAtsConsoleSv.selectUserProdInsts(request.getSelectRequestVo());
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		SelectWithNoPageResponse<UserProdInstVo> response = new SelectWithNoPageResponse<UserProdInstVo>();
		response.setResultList(resultList);
		response.setResponseHeader(responseHeader);		
		return response;
	}
	
	public void validate(UserProdInstVo vo) throws  PaasException{
		if(null == vo){
			throw new PaasException("入参对象为空！");
		}
		if(StringUtil.isBlank(vo.getUserId())){
			throw new PaasException("用户编码为空！");
		}
	}

	@Override
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInstById(
			SelectWithNoPageRequest<UserProdInstVo> request) {
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		try{
			this.validate(request.getSelectRequestVo());
			resultList = iAtsConsoleSv.selectUserProdInstById(request.getSelectRequestVo());
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		SelectWithNoPageResponse<UserProdInstVo> response = new SelectWithNoPageResponse<UserProdInstVo>();
		response.setResultList(resultList);
		response.setResponseHeader(responseHeader);		
		return response;
	}

	@Override
	public String searchUsages(String params) {
		SelectWithNoPageResponse<UserProdInstVo> response = new SelectWithNoPageResponse<UserProdInstVo>();
		ResponseHeader responseHeader = new ResponseHeader();
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		UserProdInstVo userProdInstVo=JSonUtil.fromJSon(params, UserProdInstVo.class);
		try {
			resultList=iAtsConsoleSv.getUsages(userProdInstVo);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		} catch (PaasException | IOException | URISyntaxException e) {
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL); 
			responseHeader.setResultMessage(e.getMessage());
			e.printStackTrace();
			
		}
		response.setResponseHeader(responseHeader);
		response.setResultList(resultList);
		return JSonUtil.toJSon(response);
	}

	@Override
	public String searchOneMessage(String params) {
		AtsUsageResultVo atsUsageResultVo=new AtsUsageResultVo();
		 
		 
		String result="";
		try {
			atsUsageResultVo=iAtsConsoleSv.searchOneMessage(params);
			result=JSonUtil.toJSon(atsUsageResultVo);
		} catch (PaasException | IOException | URISyntaxException e) {
			 
			Map<String,String> resultinfo=new HashMap<String, String>();
			resultinfo.put("resultCode", PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			resultinfo.put("resultMsg", e.getMessage());
			e.printStackTrace();
			return JSonUtil.toJSon(resultinfo);
		}
		return result;
	}

	@Override
	public String skipMessage(String params) {
		String result="";
		try {
			result=iAtsConsoleSv.skipMessage(params);
		} catch (NumberFormatException | PaasException | IOException
				| URISyntaxException e) {
			Map<String,String> resultinfo=new HashMap<String, String>();
			resultinfo.put("resultCode", PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			resultinfo.put("resultMsg", e.getMessage());
			e.printStackTrace();
			return JSonUtil.toJSon(resultinfo);
			 
		}
		return result;
	}

	@Override
	public String resendMessage(String params) {
		 String result="";
		 try {
			result=iAtsConsoleSv.resendMessage(params);
		} catch (NumberFormatException | PaasException | IOException
				| URISyntaxException e) {
			Map<String,String> resultinfo=new HashMap<String, String>();
			resultinfo.put("resultCode", PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			resultinfo.put("resultMsg", e.getMessage());
			e.printStackTrace();
			return JSonUtil.toJSon(resultinfo);
		}
		 return result;
	}

}
