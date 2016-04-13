package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 方案确认API
 * @author renfeng
 *
 */
@Path("/schemeConfirm")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface ISchemeConfirmDubboSv {
	/**
	 * 方案确认提交
	 * @param params
	 * @return
	 */
	@Path("/schemeSubmit")
	@POST
	public String schemeSubmit(String params);
}
