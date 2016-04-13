package com.ai.paas.ipaas.user.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.ProdQuota;
import com.ai.paas.ipaas.user.dto.ProdQuotaCriteria;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.ProdQuotaSv;
import com.ai.paas.ipaas.user.service.dao.ProdQuotaMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProdQuotaSvImpl implements ProdQuotaSv {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
    private SqlSessionTemplate template;
	
	@Autowired
	private ISysParamSv iSysParamSv;
	
	
	@Override
	public List<ProdQuota> getProdQuotaInfo(ProdQuota prodQuota) {
		
		ProdQuotaMapper prodQuotaMapper=  template.getMapper(ProdQuotaMapper.class);	
		ProdQuotaCriteria prodQuotaCriteria = new ProdQuotaCriteria();
		ProdQuotaCriteria.Criteria criteria = prodQuotaCriteria.createCriteria();		
		criteria.andProdIdEqualTo(prodQuota.getProdId());
		criteria.andUserOrgNameEqualTo(prodQuota.getUserOrgName());
		List<ProdQuota> prodQuotaList = prodQuotaMapper.selectByExample(prodQuotaCriteria);		
		List<ProdQuota> listPQ = prodQuotaMapper.selectByExample(prodQuotaCriteria);
		return listPQ;
	}


	@Override
	public String updateProdQuota(ProdQuota record) throws PaasException {
	
		ProdQuotaMapper prodQuotaMapper = template.getMapper(ProdQuotaMapper.class);
		ProdQuotaCriteria prodQuotaCriteria= new ProdQuotaCriteria();
		prodQuotaCriteria.createCriteria().andProdIdEqualTo(record.getProdId()).andUserOrgNameEqualTo(record.getUserOrgName());
		int count = 0;
		count = prodQuotaMapper.updateByExampleSelective(record, prodQuotaCriteria);
		return ""+count;

	}

	


}
