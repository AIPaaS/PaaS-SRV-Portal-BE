package com.ai.paas.ipaas.user.dubbo.interfaces;

import java.util.List;

import com.ai.paas.ipaas.user.dubbo.vo.OrgnizeCenterVo;
import com.ai.paas.ipaas.PaasException;

public interface IOrgnizeCenterSv {
	
	public List<OrgnizeCenterVo> getOrgnizeCenterByStatus(Integer status) throws PaasException;

}
