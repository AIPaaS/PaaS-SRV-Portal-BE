package com.ai.paas.ipaas.user.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.ai.paas.ipaas.user.dao.interfaces.OrgnizeUserInfoMapper;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeUserInfoCriteria;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeUserInfoKey;
import com.ai.paas.ipaas.user.service.IOrgnizeUserInfoSv;
import com.ai.paas.ipaas.PaasException;

@Service
@Transactional
public class OrgnizeUserInfoSvImpl implements IOrgnizeUserInfoSv{
	
	@Autowired
    private SqlSessionTemplate template;
	
	public OrgnizeUserInfoKey getOrgnizeUserInfo(String userId) throws PaasException {
		OrgnizeUserInfoMapper mapper = template.getMapper(OrgnizeUserInfoMapper.class);
		OrgnizeUserInfoCriteria condition = new OrgnizeUserInfoCriteria();
		condition.createCriteria().andUserIdEqualTo(userId);
		List<OrgnizeUserInfoKey> beans = mapper.selectByExample(condition);
		if(beans.size()!=1){ 
			new PaasException("get orgnize user info error!");
		}
		
		return beans.get(0);
	}

	public void saveOrgnizeUserInfo(OrgnizeUserInfoKey orgnizeuser) throws PaasException {
		OrgnizeUserInfoMapper mapper = template.getMapper(OrgnizeUserInfoMapper.class);
		mapper.insert(orgnizeuser);		
	}
		
	
}
