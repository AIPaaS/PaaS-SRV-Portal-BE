package com.ai.paas.ipaas.user.dubbo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;

import com.ai.paas.ipaas.user.dao.interfaces.OrgnizeUserInfoMapper;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeUserInfoCriteria;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeUserInfoKey;
import com.ai.paas.ipaas.user.dubbo.interfaces.IOrgnizeUserInfoSv;
import com.ai.paas.ipaas.user.dubbo.vo.OrgnizeUserInfoVo;
import com.ai.paas.ipaas.PaasException;

@Service
public class OrgnizeUserInfoSvImpl implements IOrgnizeUserInfoSv{
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
    private SqlSessionTemplate template;
	
	@Override
	public OrgnizeUserInfoVo getOrgnizeUserInfo(String userId) throws PaasException {
		OrgnizeUserInfoVo orguserinf = new OrgnizeUserInfoVo();
		OrgnizeUserInfoMapper mapper = template.getMapper(OrgnizeUserInfoMapper.class);
		OrgnizeUserInfoCriteria condition = new OrgnizeUserInfoCriteria();
		condition.createCriteria().andUserIdEqualTo(userId);
		List<OrgnizeUserInfoKey> beans = mapper.selectByExample(condition);
		//一个用户只能属于一个组织	
		if(beans.size()!=1){ 
			new PaasException("get orgnize user info error!");
		}
		BeanUtils.copyProperties(beans.get(0), orguserinf);
		return orguserinf;
	}

	@Override
	public void saveOrgnizeUserInfo(OrgnizeUserInfoVo orgnizeuser) throws PaasException {
		OrgnizeUserInfoKey orguserInfoKey = new OrgnizeUserInfoKey();
		BeanUtils.copyProperties(orgnizeuser, orguserInfoKey);
		OrgnizeUserInfoMapper mapper = template.getMapper(OrgnizeUserInfoMapper.class);
		mapper.insert(orguserInfoKey);		
	}
		
	
}
