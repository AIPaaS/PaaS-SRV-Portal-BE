package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/vmQuery")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IVmQueryAPI {
	/**
	 * 查询虚拟机订单列表
	 * @return
	 */
	@Path("/queryOrderDetail")
	@POST
	public String queryOrderDetail(String params);
	/**
	 * 查询工单处理流程
	 * @param orderDetailId
	 * @return
	 */
	@Path("/queryOrderWo")
	@POST
	public String queryOrderWo(String orderDetailId);

}
