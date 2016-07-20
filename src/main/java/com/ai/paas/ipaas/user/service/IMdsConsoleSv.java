package com.ai.paas.ipaas.user.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.MdsGetSubscribeRestfullRes;
import com.ai.paas.ipaas.user.dto.MdsSearchRestfullRes;
import com.ai.paas.ipaas.user.dto.MdsSubscribeRestfullRes;
import com.ai.paas.ipaas.user.dubbo.vo.MdsSearchMessageVo;
import com.ai.paas.ipaas.user.dubbo.vo.MdsUserSubscribeVo;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;

public interface IMdsConsoleSv {

	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)  throws PaasException;

	
	
	public List<UserProdInstVo> selectMdsById(UserProdInstVo selectRequestVo) throws PaasException;
	
	public List<String> getListSubPath(UserProdInstVo selectRequestVo) throws PaasException;
	
	public String cancleUserProdInst(UserProdInstVo vo) throws PaasException;



	public MdsSearchRestfullRes searchMessage(MdsSearchMessageVo vo)  throws PaasException;
	
	public MdsSubscribeRestfullRes createSubscribe(MdsUserSubscribeVo vo)  throws PaasException;
	
	public MdsGetSubscribeRestfullRes getSubscribe(MdsUserSubscribeVo vo)  throws PaasException;
	
	public String resendMessage(String params) throws NumberFormatException, PaasException,IOException, URISyntaxException;
	
	public String skipMessage(String params)throws NumberFormatException, PaasException ,IOException, URISyntaxException ;
}
