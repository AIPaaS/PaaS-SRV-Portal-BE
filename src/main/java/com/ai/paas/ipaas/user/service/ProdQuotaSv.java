package com.ai.paas.ipaas.user.service;

import java.util.List;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.ProdQuota;



public interface ProdQuotaSv {
	
	public List<ProdQuota>  getProdQuotaInfo(ProdQuota prodQuota) ;	
	
	public String updateProdQuota(ProdQuota record) throws PaasException;//修改 ProdQuota表


}


