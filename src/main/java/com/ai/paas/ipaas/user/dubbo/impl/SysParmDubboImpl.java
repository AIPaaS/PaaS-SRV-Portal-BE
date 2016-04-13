package com.ai.paas.ipaas.user.dubbo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.interfaces.ISysParamDubbo;
import com.ai.paas.ipaas.user.dubbo.vo.SysParamVo;
import com.ai.paas.ipaas.user.dubbo.vo.SysParmRequest;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class SysParmDubboImpl implements ISysParamDubbo {
	
	@Autowired
	private ISysParamSv iSysParmSv;

	@Override
	public List<SysParamVo> getSysParams(SysParmRequest request) {		
		List<SysParamVo>  sysParamList = iSysParmSv.getSysParams(request);
		return sysParamList;
	}

	@Override
	public SysParamVo getSysParamsVo(SysParmRequest request) throws PaasException  {
		
		return iSysParmSv.getSysParamsVo(request);
	}

}
