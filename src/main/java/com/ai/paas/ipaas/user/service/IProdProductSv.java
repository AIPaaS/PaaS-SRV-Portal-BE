package com.ai.paas.ipaas.user.service;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.ProdProduct;

public interface IProdProductSv {
	public ProdProduct selectProductByPrimaryKey(Short prodId)  throws PaasException;
	
	
	public ProdProduct selectProductByProdEnSimp(String prodEnSimp) throws PaasException;


}
