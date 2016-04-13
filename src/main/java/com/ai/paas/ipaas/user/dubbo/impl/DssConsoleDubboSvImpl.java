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
import com.ai.paas.ipaas.user.dubbo.interfaces.IDssConsoleDubboSv;
import com.ai.paas.ipaas.user.dubbo.vo.DocumentVo;
import com.ai.paas.ipaas.user.dubbo.vo.ProdMenuVo;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IDssConsoleSv;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class DssConsoleDubboSvImpl implements IDssConsoleDubboSv {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private IDssConsoleSv iDssConsoleSv;
	
	@Override
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInsts(
			SelectWithNoPageRequest<UserProdInstVo> request) {
		
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		try{
			this.validate(request.getSelectRequestVo());
			resultList = iDssConsoleSv.selectUserProdInsts(request.getSelectRequestVo());
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
	public ResponseHeader cancleUserProdInst(UserProdInstVo vo) {
		ResponseHeader responseHeader = new ResponseHeader();	
		try{
			this.validate(vo);
			String resultCode = iDssConsoleSv.cancleUserProdInst(vo);
			responseHeader.setResultCode(resultCode);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		return responseHeader;
	}

	@Override
	public ResponseHeader mdyServPwd(UserProdInstVo vo) {
		ResponseHeader responseHeader = new ResponseHeader();	
		try{
			this.validate(vo);
			if(StringUtil.isBlank(vo.getNewPwd())){
				throw new PaasException("Pass服务新密码为空");
			}
			if(StringUtil.isBlank(vo.getOldPwd())){
				throw new PaasException("Pass服务旧密码为空");
			}
			String resultCode = iDssConsoleSv.mdyServPwd(vo);
			responseHeader.setResultCode(resultCode);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		return responseHeader;
	}

	@Override
	public ResponseHeader fullClear(UserProdInstVo vo) {
		ResponseHeader responseHeader = new ResponseHeader();	
		try{
			this.validate(vo);
			String resultCode = iDssConsoleSv.fullClear(vo);
			responseHeader.setResultCode(resultCode);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		return responseHeader;
	}

	@Override
	public SelectWithNoPageResponse<DocumentVo> selectDocumentByKey(SelectWithNoPageRequest<UserProdInstVo> request) {
		ResponseHeader responseHeader = new ResponseHeader();	
		List<DocumentVo>   resultList  = new ArrayList<DocumentVo>();
		UserProdInstVo vo = request.getSelectRequestVo();
		try{
			this.validate(vo);
			if(StringUtil.isBlank(vo.getKey())){
				throw new PaasException("key值为空");
			}
			resultList = iDssConsoleSv.selectDocumentByKey(request.getSelectRequestVo());
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		SelectWithNoPageResponse<DocumentVo> response = new SelectWithNoPageResponse<DocumentVo>();
		response.setResultList(resultList);
		response.setResponseHeader(responseHeader);		
		return response;
	}

	@Override
	public ResponseHeader clearDocumentByKey(UserProdInstVo vo) {
		ResponseHeader responseHeader = new ResponseHeader();	
		try{
			this.validate(vo);
			if(StringUtil.isBlank(vo.getKey())){
				throw new PaasException("key值为空");
			}
			String resultCode =  iDssConsoleSv.keyClear(vo);
			responseHeader.setResultCode(resultCode);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		return responseHeader;
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
	public SelectWithNoPageResponse<UserProdInstVo> selectDssById(
			SelectWithNoPageRequest<UserProdInstVo> request) {
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		try{
			this.validate(request.getSelectRequestVo());
			resultList = iDssConsoleSv.selectDssById(request.getSelectRequestVo());
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
	public SelectWithNoPageResponse<ProdMenuVo> queryLeftMenuList(
			SelectWithNoPageRequest<ProdMenuVo> request) {
		ResponseHeader responseHeader = new ResponseHeader();	
		List<ProdMenuVo>   resultList  = new ArrayList<ProdMenuVo>();
		ProdMenuVo vo = request.getSelectRequestVo();
		try{
			if(null == vo){
				throw new PaasException("入参对象为空！");
			}
			if(StringUtil.isBlank(vo.getUserId())){
				throw new PaasException("用户编码为空！");
			}
			resultList = iDssConsoleSv.queryLeftMenuList(request.getSelectRequestVo());
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		SelectWithNoPageResponse<ProdMenuVo> response = new SelectWithNoPageResponse<ProdMenuVo>();
		response.setResultList(resultList);
		response.setResponseHeader(responseHeader);		
		return response;
	}

	@Override
	public String modifyConfiguration(String params) {
		String result="";
		try {
			result=iDssConsoleSv.modifyConfiguration(params);
		} catch (NumberFormatException | PaasException | IOException
				| URISyntaxException e) {
			Map<String, String> resultinfo=new HashMap<String, String>();
			resultinfo.put("resultCode", PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			resultinfo.put("resultMsg", e.getMessage());
			e.printStackTrace();
			return JSonUtil.toJSon(resultinfo);
		}
		return result;
	}

}
