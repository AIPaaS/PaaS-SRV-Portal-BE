package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.UserMessageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.UserMessageResponse;
@Path("/messageDisplay")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface MessageDisplayDubboSv {
	
	/**
	 * 分页查询用户的消息列表
	 */
	@Path("/searchPage")
	@POST
	public abstract UserMessageResponse searchPage(UserMessageRequest request) throws PaasException;

}
