package com.ai.paas.ipaas.user.service;

import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.dubbo.vo.UserMessageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.UserMessageVo;


public interface MessageDisplaySv{
	     public abstract PageResult<UserMessageVo> searchPage(UserMessageRequest request);
}
