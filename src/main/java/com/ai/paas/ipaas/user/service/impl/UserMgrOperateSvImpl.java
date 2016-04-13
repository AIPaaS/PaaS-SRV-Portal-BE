package com.ai.paas.ipaas.user.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.UserMgrOperate;
import com.ai.paas.ipaas.user.service.IUserMgrOperateSv;
import com.ai.paas.ipaas.user.service.dao.UserMgrOperateMapper;
@Service
@Transactional 
public class UserMgrOperateSvImpl implements IUserMgrOperateSv {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
    private SqlSessionTemplate template;
	@Override
	public void saveUserMgrOperate(UserMgrOperate userMgrOperate)
			throws PaasException {
		UserMgrOperateMapper userMgrOperateMapper =  template.getMapper(UserMgrOperateMapper.class);
		userMgrOperateMapper.insert(userMgrOperate);		
		
	}

}
