package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sun.net.www.content.text.plain;

@Path("des/console")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface IDesConsoleDubboSv {

	
	/**
	 * 查询用户订购的产品列表
	 * @param params
	 * @return
	 */
	@Path("/selectUserProdInsts")
	@POST
	public String selectUserProdInsts(String params);
	
	
	@Path("/desBind")
	@POST
	public String desBind(String params);
	
	
	@Path("/desGetBound")
	@POST
	public String desGetBound(String params);
	
	@Path("/desgetBoundTableInfo")
	@POST
	public String desBoundTableInfo(String params);
	
	@Path("/desUnbind")
	@POST
	public String desUnbind(String params);
	
	@Path("/filterTable")
	@POST
	public String filterTable(String params);
	
}
