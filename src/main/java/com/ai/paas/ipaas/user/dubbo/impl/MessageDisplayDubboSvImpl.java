package com.ai.paas.ipaas.user.dubbo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dubbo.interfaces.MessageDisplayDubboSv;
import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.UserMessageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.UserMessageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserMessageVo;
import com.ai.paas.ipaas.user.service.MessageDisplaySv;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class MessageDisplayDubboSvImpl implements MessageDisplayDubboSv{
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private MessageDisplaySv messageDisplaySv;

	@Override
	public UserMessageResponse searchPage(UserMessageRequest request) throws PaasException{
		
		ResponseHeader responseHeader = new ResponseHeader();	
		PageResult<UserMessageVo>   pageResult  = new PageResult<UserMessageVo>();
		try{
			pageResult = messageDisplaySv.searchPage(request);
			responseHeader.setResultCode(Constants.OPERATE_CODE_SUCCESS);
		}catch(Exception e){
			responseHeader.setResultCode(Constants.OPERATE_CODE_FAIL);
			e.printStackTrace();
			logger.error(e.getMessage());
		}		
		UserMessageResponse response = new UserMessageResponse();
		response.setPageResult(pageResult);
		response.setResponseHeader(responseHeader);		
		return response;
	}
	
	
	

}
