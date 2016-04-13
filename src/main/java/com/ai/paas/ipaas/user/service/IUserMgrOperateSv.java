package com.ai.paas.ipaas.user.service;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.UserMgrOperate;

public interface IUserMgrOperateSv {
	public void saveUserMgrOperate(UserMgrOperate userMgrOperate) throws PaasException;

}
