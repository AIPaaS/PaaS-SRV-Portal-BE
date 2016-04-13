package com.ai.paas.ipaas.user.service;

import java.util.List;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.SysParamVo;
import com.ai.paas.ipaas.user.dubbo.vo.SysParmRequest;

public interface ISysParamSv {
	public List<SysParamVo> getSysParams(SysParmRequest request);

	public SysParamVo getSysParamsVo(SysParmRequest request) throws PaasException;
}
