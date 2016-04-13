package com.ai.paas.ipaas.user.service;

import java.util.Map;

import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.vo.ErpProjectVo;

/**
 * OA业务操作接口
 * @author archer
 *
 */
public interface IOaSv {

	public String getOaOperators(Map paramMap) throws Exception;

	public Object oaAuditResultNotify(Map<String, Object> paramMap) throws Exception;
	
	public String getBuiCodeByNt(String Nt) throws Exception;	

	public Object oaAuditPremise(Map<String, Object> paramMap);

	public PageResult<ErpProjectVo> getErpProjects(Map<String, String> paramMap) throws Exception;;
}
