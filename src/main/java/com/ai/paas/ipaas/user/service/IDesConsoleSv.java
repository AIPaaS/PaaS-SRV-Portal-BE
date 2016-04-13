package com.ai.paas.ipaas.user.service;

import java.util.List;
import java.util.Map;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.DesBindRequest;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.dubbo.vo.UserVo;

public interface IDesConsoleSv {
	public List<UserProdInstVo>  selectUserProdInsts(UserProdInstVo vo)throws PaasException;
	
	public Map<String,String> toDesBind(DesBindRequest desBindRequest)throws PaasException;
	
	public String toGetBound(String userId) throws PaasException;
	
	public String toDesUnbind(Map<String, String>unBinRequest) throws PaasException;
	
	public String tofilterTable(Map<String, String> filterRequest) throws PaasException;
	
	public String toBoundTableInfo(Map<String , String> request)throws PaasException;
}
