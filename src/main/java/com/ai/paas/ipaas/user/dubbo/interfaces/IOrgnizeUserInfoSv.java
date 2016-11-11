package com.ai.paas.ipaas.user.dubbo.interfaces;

import com.ai.paas.ipaas.user.dubbo.vo.OrgnizeUserInfoVo;
import com.ai.paas.ipaas.PaasException;

public interface IOrgnizeUserInfoSv {

	public OrgnizeUserInfoVo getOrgnizeUserInfo(String userId) throws PaasException;
	
	public void saveOrgnizeUserInfo(OrgnizeUserInfoVo orgnizeUser) throws PaasException;
}
