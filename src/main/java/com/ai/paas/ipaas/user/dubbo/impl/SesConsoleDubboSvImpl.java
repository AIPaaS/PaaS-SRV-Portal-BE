package com.ai.paas.ipaas.user.dubbo.impl;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.interfaces.ISesConsoleDubboSv;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.ISesConsoleSv;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class SesConsoleDubboSvImpl implements ISesConsoleDubboSv{

	@Autowired 
	private ISesConsoleSv sesConsoleSv;
	@Override
	public ResponseHeader startService(UserProdInstVo vo) {
		ResponseHeader responseHeader=new ResponseHeader();
		try {
			this.validateParam(vo);
			String resultCode=sesConsoleSv.startService(vo);
			responseHeader.setResultCode(resultCode);
		} catch (PaasException | IOException | URISyntaxException e) {
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
			e.printStackTrace();
		}
		return responseHeader;
	}

	@Override
	public ResponseHeader stopService(UserProdInstVo vo) {
		ResponseHeader responseHeader=new ResponseHeader();
		try {
			this.validateParam(vo);
			String resultCode=sesConsoleSv.stopService(vo);
			responseHeader.setResultCode(resultCode);
		} catch (PaasException | IOException | URISyntaxException e) {
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
			e.printStackTrace();
		}
		
		return responseHeader;
	}

	@Override
	public ResponseHeader cancleService(UserProdInstVo vo) {
		ResponseHeader responseHeader=new ResponseHeader();
		try {
			this.validateParam(vo);
			String resultCode=sesConsoleSv.cancleService(vo);
			responseHeader.setResultCode(resultCode);
		} catch (PaasException | IOException | URISyntaxException e) {
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
			e.printStackTrace();
		}
		return responseHeader;
	}
	
	private void validateParam(UserProdInstVo vo) throws PaasException {
		if(vo == null){
			throw new PaasException("入参对象为空");
		}
		if(StringUtil.isBlank(vo.getUserId())){
			throw new PaasException("用户编码为空");
		}
	}

}
