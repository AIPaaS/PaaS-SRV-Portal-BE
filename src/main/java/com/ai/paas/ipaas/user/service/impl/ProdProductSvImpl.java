package com.ai.paas.ipaas.user.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.ProdProductCriteria;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.dao.ProdProductMapper;
@Service
@Transactional 
public class ProdProductSvImpl implements IProdProductSv{

	@Autowired
    private SqlSessionTemplate template;
	
	
	public ProdProduct selectProductByPrimaryKey(Short prodId) throws PaasException {
		ProdProductMapper prodProductMapper =  template.getMapper(ProdProductMapper.class);
		ProdProduct prodProduct = prodProductMapper.selectByPrimaryKey(prodId);
		if(null == prodProduct){
			throw new PaasException("查询产品为空！");
		}
		return prodProduct;
	}
	
	@Override
	public ProdProduct selectProductByProdEnSimp(String prodEnSimp) throws PaasException {
		ProdProductMapper prodProductMapper =  template.getMapper(ProdProductMapper.class);
		ProdProductCriteria prodProductCriteria =new ProdProductCriteria();
		prodProductCriteria.createCriteria().andProdEnSimpEqualTo(prodEnSimp);
		List<ProdProduct> prodProductList = prodProductMapper.selectByExample(prodProductCriteria);
		if(null == prodProductList || prodProductList.size() <= 0){
			throw new PaasException("查询产品为空！");
		}
		return prodProductList.get(0);
	}
	

}
