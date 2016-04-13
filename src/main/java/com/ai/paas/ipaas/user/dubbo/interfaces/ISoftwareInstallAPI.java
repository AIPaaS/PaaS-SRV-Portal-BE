package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 软件安装完成API
 * @author renfeng
 *
 */
@Path("/softwareInstall")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface ISoftwareInstallAPI {

	/**
	 * 软件安装完成提交
	 * @param params
	 * @return
	 */
	@Path("/softwareInstallSubmit")
	@POST
	public String softwareInstallSubmit(String params);
}
