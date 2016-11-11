package com.ai.paas.ipaas.user.dubbo.interfaces;

import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeUserInfoKey;
import com.ai.paas.ipaas.PaasException;

public interface IOrgnizeUserInfoSv {

	public OrgnizeUserInfoKey getOrgnizeUserInfo(String userId) throws PaasException;
	
	public void saveOrgnizeUserInfo(OrgnizeUserInfoKey orgnizeUser) throws PaasException;
}
