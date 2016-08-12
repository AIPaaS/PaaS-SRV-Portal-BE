package com.ai.paas.ipaas.user.dubbo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.interfaces.IRdsConsoleDubboSv;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IRdsConsoleSv;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class RdsConsoleDubboSvImpl implements IRdsConsoleDubboSv {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private IRdsConsoleSv iRdsConsoleSv;
	
	@Override
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInsts(
			SelectWithNoPageRequest<UserProdInstVo> request) {
		
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		try{
			this.validate(request.getSelectRequestVo());
			resultList = iRdsConsoleSv.selectUserProdInsts(request.getSelectRequestVo());
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
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInstById(
			SelectWithNoPageRequest<UserProdInstVo> request) {
		
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		try{
			this.validate(request.getSelectRequestVo());
			resultList = iRdsConsoleSv.selectUserProdInstById(request.getSelectRequestVo());
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
	public ResponseHeader stopRdsContainer(String paraprodBackPara) {
		ResponseHeader responseHeader = new ResponseHeader();	
		try {
			responseHeader=iRdsConsoleSv.stopRdsContainer(paraprodBackPara);
		} catch (PaasException e) {
			e.printStackTrace();
		}
		 return responseHeader;
	}

	@Override
	public ResponseHeader startRdsContainer(String paraprodBackPara) {
		ResponseHeader responseHeader = new ResponseHeader();	
		try {
			responseHeader=iRdsConsoleSv.startRdsContainer(paraprodBackPara);
		} catch (PaasException e) {
			e.printStackTrace();
		}
		 return responseHeader;
	}

	@Override
	public ResponseHeader destroyContainer(String paraprodBackPara) {
		ResponseHeader responseHeader = new ResponseHeader();	
		try {
			responseHeader=iRdsConsoleSv.destroyContainer(paraprodBackPara);
		} catch (PaasException e) {
			e.printStackTrace();
		}
		 return responseHeader;
	}

}
