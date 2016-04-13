package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.ProdProductVo;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;

@Path("/prodProduct")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IProdProductDubboSv {
	@Path("/selectProduct")
	@POST
	public  SelectWithNoPageResponse<ProdProductVo>  selectProduct(SelectWithNoPageRequest<ProdProductVo> request) throws PaasException;
	
	
	@Path("/selectProductByProdEnSimp")
	@POST
	public String  selectProductByProdEnSimp(String prodEnSimp);
	
	
}
