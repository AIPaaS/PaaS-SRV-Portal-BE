package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user/iUserApi")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IUserApi {
	
	/**
	 * 根据nt账号获取亚信OA系统员工信息
	 * @param param
	 * @return
	 */
	@Path("/getAiEmployeeInfo")
	@POST
	public String getAiEmployeeInfo(String param);

}
