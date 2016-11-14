package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.user.dubbo.vo.OrgnizeUserInfoVo;
import com.ai.paas.ipaas.PaasException;

@Path("/orgnize/userInfo")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IOrgnizeUserInfoSv {

	@Path("/getOrgnizeUserInfo")
	@POST
	public OrgnizeUserInfoVo getOrgnizeUserInfo(String userId) throws PaasException;
	
	@Path("/saveOrgnizeUserInfo")
	@POST
	public void saveOrgnizeUserInfo(OrgnizeUserInfoVo orgnizeUser) throws PaasException;
}
