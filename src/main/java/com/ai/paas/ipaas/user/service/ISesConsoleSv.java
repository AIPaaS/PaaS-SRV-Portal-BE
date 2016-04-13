package com.ai.paas.ipaas.user.service;

import java.io.IOException;
import java.net.URISyntaxException;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;

public interface ISesConsoleSv {
	public String startService(UserProdInstVo vo)throws PaasException, IOException, URISyntaxException ;
	public String stopService(UserProdInstVo vo)throws PaasException, IOException, URISyntaxException ;
	public String cancleService(UserProdInstVo vo)throws PaasException, IOException, URISyntaxException ;
	
}
