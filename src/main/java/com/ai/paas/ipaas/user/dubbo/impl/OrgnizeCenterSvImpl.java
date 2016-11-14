package com.ai.paas.ipaas.user.dubbo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import com.ai.paas.ipaas.user.dao.interfaces.OrgnizeCenterMapper;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeCenter;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeCenterCriteria;
import com.ai.paas.ipaas.user.dubbo.interfaces.IOrgnizeCenterSv;
import com.ai.paas.ipaas.user.dubbo.vo.OrgnizeCenterVo;
import com.ai.paas.ipaas.PaasException;

@Service
@Transactional
public class OrgnizeCenterSvImpl implements IOrgnizeCenterSv{
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
    private SqlSessionTemplate template;
	
	@Override
	public List<OrgnizeCenterVo> getOrgnizeCenterByStatus(Integer status) throws PaasException {
		OrgnizeCenterMapper mapper = template.getMapper(OrgnizeCenterMapper.class);
		OrgnizeCenterCriteria condition = new OrgnizeCenterCriteria();
		condition.createCriteria().andOrgStatusEqualTo(status);
		List<OrgnizeCenterVo> orgs = new ArrayList<OrgnizeCenterVo>();
		OrgnizeCenterVo orgcenterVo = new OrgnizeCenterVo();
		List<OrgnizeCenter> beans = mapper.selectByExample(condition);
		if(beans.size() < 1){ 
			new PaasException("get orgnize info error!");
		}
		for(OrgnizeCenter org : beans) {
			BeanUtils.copyProperties(org, orgcenterVo);
			orgs.add(orgcenterVo);
		}
		return orgs;
	}
		
	
}
