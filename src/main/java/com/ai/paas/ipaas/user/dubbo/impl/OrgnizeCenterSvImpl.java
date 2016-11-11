package com.ai.paas.ipaas.user.dubbo.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.ai.paas.ipaas.user.dao.interfaces.OrgnizeCenterMapper;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeCenter;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeCenterCriteria;
import com.ai.paas.ipaas.user.dubbo.interfaces.IOrgnizeCenterSv;
import com.ai.paas.ipaas.PaasException;

@Service
@Transactional
public class OrgnizeCenterSvImpl implements IOrgnizeCenterSv{
	
	@Autowired
    private SqlSessionTemplate template;
	
	public List<OrgnizeCenter> getOrgnizeCenterByStatus(Integer status) throws PaasException {
		OrgnizeCenterMapper mapper = template.getMapper(OrgnizeCenterMapper.class);
		OrgnizeCenterCriteria condition = new OrgnizeCenterCriteria();
		condition.createCriteria().andOrgStatusEqualTo(status);
		List<OrgnizeCenter> beans = mapper.selectByExample(condition);
		if(beans.size() < 1){ 
			new PaasException("get orgnize info error!");
		}
		
		return beans;
	}
		
	
}
