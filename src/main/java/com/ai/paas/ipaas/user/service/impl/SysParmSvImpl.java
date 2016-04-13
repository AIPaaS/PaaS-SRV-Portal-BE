package com.ai.paas.ipaas.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.SysConfig;
import com.ai.paas.ipaas.user.dto.SysConfigCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.SysParamVo;
import com.ai.paas.ipaas.user.dubbo.vo.SysParmRequest;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.dao.SysConfigMapper;
@Service
@Transactional 
public class SysParmSvImpl implements ISysParamSv {
	@Autowired
    private SqlSessionTemplate template;
	@Override
	public List<SysParamVo> getSysParams(SysParmRequest request) {
		SysConfigMapper mapper = template.getMapper(SysConfigMapper.class);
		SysConfigCriteria sysConfigCriteria = new SysConfigCriteria();
		SysConfigCriteria.Criteria criteria = sysConfigCriteria.createCriteria();
		criteria.andTypeCodeEqualTo(request.getTypeCode());
		criteria.andParamCodeEqualTo(request.getParamCode());
		List<SysConfig> serviceTypeOptions = mapper.selectByExample(sysConfigCriteria);
		List<SysParamVo> sysParamVoList = new ArrayList<SysParamVo>();
		if (serviceTypeOptions != null && serviceTypeOptions.size()>0) {			
			for(int i=0;i<serviceTypeOptions.size();i++){
				SysParamVo sysParamVo = new SysParamVo();
				BeanUtils.copyProperties(serviceTypeOptions.get(i), sysParamVo);
				sysParamVoList.add(sysParamVo);
			}
			
		}
		return sysParamVoList;
	}
	@Override
	public SysParamVo getSysParamsVo(SysParmRequest request) throws PaasException {
		SysConfigMapper mapper = template.getMapper(SysConfigMapper.class);
		SysConfigCriteria sysConfigCriteria = new SysConfigCriteria();
		SysConfigCriteria.Criteria criteria = sysConfigCriteria.createCriteria();
		criteria.andTypeCodeEqualTo(request.getTypeCode());
		criteria.andParamCodeEqualTo(request.getParamCode());
		criteria.andServiceValueEqualTo(request.getServiceValue());
		List<SysConfig> serviceTypeOptions = mapper.selectByExample(sysConfigCriteria);
		SysParamVo sysParamVo = new SysParamVo();
		if (serviceTypeOptions != null && serviceTypeOptions.size()>0) {			
				BeanUtils.copyProperties(serviceTypeOptions.get(0), sysParamVo);
			
		}else{
			throw new PaasException("参数不正确");
			
		}
		return sysParamVo;
	}
}
