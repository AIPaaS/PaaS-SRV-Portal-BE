package com.ai.paas.ipaas.user.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.AtsSearchUsageVo;
import com.ai.paas.ipaas.user.dubbo.vo.AtsUsageResultVo;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;

public interface IAtsConsoleSv {
	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)  throws PaasException;	

	public List<UserProdInstVo> selectUserProdInstById(UserProdInstVo selectRequestVo) throws PaasException;
	
	public List<UserProdInstVo> getUsages(UserProdInstVo  selectRequestVo) throws PaasException, IOException, URISyntaxException ;
	
	public AtsUsageResultVo searchOneMessage(String params) throws PaasException, IOException, URISyntaxException;
	
	public String skipMessage(String params) throws NumberFormatException, PaasException,IOException, URISyntaxException ;
	
	public String resendMessage(String params) throws NumberFormatException, PaasException ,PaasException, IOException, URISyntaxException;
}
