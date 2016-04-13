package com.ai.paas.ipaas.user.dubbo.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.interfaces.IDesConsoleDubboSv;
import com.ai.paas.ipaas.user.dubbo.vo.DesBindRequest;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IDesConsoleSv;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@Service	
public class DesConsoleDubboSvImpl implements IDesConsoleDubboSv{

	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private IDesConsoleSv iDesConsoleSv;
	@Override
	public String selectUserProdInsts(String params) {
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		
		Gson gson=new Gson();
		SelectWithNoPageRequest<UserProdInstVo> request=gson.fromJson(params,new TypeToken<SelectWithNoPageRequest<UserProdInstVo>>() {
		}.getType());
		try{
			this.validate(request.getSelectRequestVo());
			resultList=iDesConsoleSv.selectUserProdInsts(request.getSelectRequestVo());
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}
		SelectWithNoPageResponse<UserProdInstVo> response = new SelectWithNoPageResponse<UserProdInstVo>();
		response.setResultList(resultList);
		response.setResponseHeader(responseHeader);
		String  result=JSonUtil.toJSon(response);
		
		
		return result;
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
	public String desBind(String params) {
		DesBindRequest desBindRequest=JSonUtil.fromJSon(params, DesBindRequest.class);
		ResponseHeader responseHeader=new ResponseHeader();
		Map<String, String> result=new HashMap<String, String>();
		try {
			result=iDesConsoleSv.toDesBind(desBindRequest);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
			responseHeader.setResultMessage(result.get("resultMsg"));
		} catch (Exception e) {
			
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}
		
		return JSonUtil.toJSon(responseHeader);
	}

	@Override
	public String desGetBound(String params) {
		JSONObject object=JsonUtils.parse(params);
		ResponseHeader responseHeader=new ResponseHeader();
		String result="";
		try {
			result=iDesConsoleSv.toGetBound(object.getString("userId"));
		} catch (Exception e) {
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
			return JSonUtil.toJSon(responseHeader);
		}
		return result;
	}

	@Override
	public String desUnbind(String params) {
		Map<String, String> unbindRequest=JSonUtil.fromJSon(params, Map.class);
		ResponseHeader responseHeader=new ResponseHeader();
		try {
			String result=iDesConsoleSv.toDesUnbind(unbindRequest);
			JSONObject object=JsonUtils.parse(result);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
			responseHeader.setResultMessage(object.getString("resultMsg"));
		} catch (PaasException e) {
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}
		return JSonUtil.toJSon(responseHeader);
	}

	@Override
	public String filterTable(String params) {
		Map<String, String>filterRequest=JSonUtil.fromJSon(params, Map.class);
		ResponseHeader responseHeader=new ResponseHeader();
		try {
			String result=iDesConsoleSv.tofilterTable(filterRequest);
			JSONObject object=JsonUtils.parse(result);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
			responseHeader.setResultMessage(object.getString("resultMsg"));
		} catch (PaasException e) {
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}
		return JSonUtil.toJSon(responseHeader);
	}

	@Override
	public String desBoundTableInfo(String params) {
		Map<String , String> request=JSonUtil.fromJSon(params, Map.class);
		ResponseHeader responseHeader=new ResponseHeader();
		String result="";
		try {
			result=iDesConsoleSv.toBoundTableInfo(request);
		} catch (Exception e) {
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
			return JSonUtil.toJSon(responseHeader);
		}
		return result;
	}
}
