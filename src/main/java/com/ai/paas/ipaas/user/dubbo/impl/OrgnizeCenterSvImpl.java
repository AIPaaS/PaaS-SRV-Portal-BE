package com.ai.paas.ipaas.user.dubbo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;

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
		List<OrgnizeCenter> beans = mapper.selectByExample(condition);
		if(beans.size() < 1){ 
			logger.info("get orgnize info null!");
			new PaasException("get orgnize info error!");
		}
		for(OrgnizeCenter org : beans) {
			OrgnizeCenterVo orgcenterVo = new OrgnizeCenterVo();
			BeanUtils.copyProperties(org, orgcenterVo);
			orgs.add(orgcenterVo);
		}
		return orgs;
	}
	
	@Override
	public OrgnizeCenterVo getOrgnizeCenterById(Integer orgId) throws PaasException {
		OrgnizeCenterMapper mapper = template.getMapper(OrgnizeCenterMapper.class);
		OrgnizeCenterCriteria condition = new OrgnizeCenterCriteria();
		condition.createCriteria().andOrgIdEqualTo(orgId);
		List<OrgnizeCenterVo> orgs = new ArrayList<OrgnizeCenterVo>();		
		List<OrgnizeCenter> beans = mapper.selectByExample(condition);
		if(beans.size() < 1){ 
			logger.info("get orgnize info null!");
			new PaasException("get orgnize info error!");
		}
		for(OrgnizeCenter org : beans) {
			OrgnizeCenterVo orgcenterVo = new OrgnizeCenterVo();
			BeanUtils.copyProperties(org, orgcenterVo);
			orgs.add(orgcenterVo);
		}
		return orgs.get(0);
	}
	
	@Override
	public int insertOrgnizeCenter(OrgnizeCenterVo vo) throws PaasException {
		OrgnizeCenterMapper mapper = template.getMapper(OrgnizeCenterMapper.class);
		OrgnizeCenter record = new OrgnizeCenter();
		BeanUtils.copyProperties(vo, record);
		int insertResult = mapper.insert(record);
		if (insertResult > 0) {
			logger.info("##### finish to insert orgnize center####### result is :"+ insertResult);
		} else {
			throw new RuntimeException("fail to insert orgnize center");
		}
		return insertResult;
	}
	
	@Override
	public int updateOrgnizeCenter(OrgnizeCenterVo vo) throws PaasException {
		OrgnizeCenterMapper mapper = template.getMapper(OrgnizeCenterMapper.class);
		OrgnizeCenter record = new OrgnizeCenter();
		BeanUtils.copyProperties(vo, record);
		int updateResult = mapper.updateByPrimaryKeySelective(record);//根据主key更新组织信息
		if (updateResult > 0) {
			logger.info("##### finish to update orgnize center####### result is :"+ updateResult);
		} else {
			throw new RuntimeException("fail to update orgnize center");
		}
		return updateResult;
	}
	
	@Override
	public int deleteOrgnize(Integer orgId) throws PaasException {
		OrgnizeCenterMapper mapper = template.getMapper(OrgnizeCenterMapper.class);
		int delResult = mapper.deleteByPrimaryKey(orgId);
		if (delResult > 0) {
			logger.info("##### finish to delete orgnize ####### result is :"+ delResult);
		} else {
			throw new RuntimeException("fail to delete orgnize ");
		}	
		return delResult;
	}	
	
}
