package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 订单查询
 * @author renfeng
 *
 */
@Path("/order")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IOrdersQueryAPI {

	/**
	 * 订单信息查询
	 * @param params
	 * @return
	 */
	@Path("/queryOrdersInfo")
	@POST
	public String ordersQuery(String params);
	
}
