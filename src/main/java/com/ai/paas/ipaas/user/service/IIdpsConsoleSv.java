package com.ai.paas.ipaas.user.service;

import java.util.List;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;

public interface IIdpsConsoleSv {
	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)  throws PaasException;

	public ResponseHeader stopIdpsContainer(String paraprodBackPara)   throws PaasException;
	
	public ResponseHeader startIdpsContainer(String paraprodBackPara)   throws PaasException;
}
