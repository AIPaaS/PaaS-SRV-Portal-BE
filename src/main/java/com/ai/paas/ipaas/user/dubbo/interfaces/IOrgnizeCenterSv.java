package com.ai.paas.ipaas.user.dubbo.interfaces;

import java.util.List;

import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeCenter;
import com.ai.paas.ipaas.PaasException;

public interface IOrgnizeCenterSv {
	
	public List<OrgnizeCenter> getOrgnizeCenterByStatus(Integer status) throws PaasException;

}
