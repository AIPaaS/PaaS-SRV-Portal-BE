package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.user.dto.ProdQuota;

@Path("/user/prodQuotaApi")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface ProdQuotaApi {
	

	@Path("/prodQuotaByNt")
	@POST
	public String prodQuotaByNt(String Nt); //根据nt 查找prodQuota
	

	@Path("/prodQuotaByOrderId")
	@POST 
	public String prodQuotaByOrderId(String orderId); //根据orderid 查找prodQuota
	
	
	@Path("/updateProdQuota")
	@POST
	public String updateProdQuota(ProdQuota record); //根据orderid 查找prodQuota
	
	
}
