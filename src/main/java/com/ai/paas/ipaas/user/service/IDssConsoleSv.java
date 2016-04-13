package com.ai.paas.ipaas.user.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.DocumentVo;
import com.ai.paas.ipaas.user.dubbo.vo.ProdMenuVo;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;

public interface IDssConsoleSv {
	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)  throws PaasException;

	public String cancleUserProdInst(UserProdInstVo vo) throws PaasException;

	public String mdyServPwd(UserProdInstVo vo) throws PaasException;

	public String fullClear(UserProdInstVo vo) throws PaasException;

	public List<DocumentVo> selectDocumentByKey(UserProdInstVo selectRequestVo) throws PaasException;
	
	public String keyClear(UserProdInstVo vo) throws PaasException;

	public List<UserProdInstVo> selectDssById(UserProdInstVo selectRequestVo) throws PaasException;

	public List<ProdMenuVo> queryLeftMenuList(ProdMenuVo selectRequestVo)  throws PaasException;
	
	public String modifyConfiguration(String params) throws NumberFormatException, PaasException, IOException, URISyntaxException ;
}
