package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.CheckOrdersRequest;
import com.ai.paas.ipaas.user.dubbo.vo.CheckOrdersResponse;
import com.ai.paas.ipaas.user.dubbo.vo.OrderDetailRequest;
import com.ai.paas.ipaas.user.dubbo.vo.OrderDetailResponse;
import com.ai.paas.ipaas.user.dubbo.vo.SelectOrderRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectOrderResponse;

@Path("/user/order")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IOrder {
	@Path("/saveOrderDetail")
	@POST
	public OrderDetailResponse saveOrderDetail(OrderDetailRequest request);
	
	@Path("/selectOrderDetails")
	@POST
	public SelectOrderResponse selectOrderDetails(SelectOrderRequest request) throws PaasException;
	
	@Path("/selectOrderList")
	@POST
	public SelectOrderResponse selectOrderList(SelectOrderRequest request) throws PaasException;

	@Path("/checkOrders")
	@POST
	public CheckOrdersResponse  checkOrders(CheckOrdersRequest request) ;
	
	@Path("/checkIaasOrders")
	@POST
	public CheckOrdersResponse  checkIaasOrders(CheckOrdersRequest request) ;
	
	@Path("/verifyOrders")
	@POST
	public String verifyOrders(String params);
	
	
	@Path("/applyOrders")
	@POST
	public String applyOrders(String params);
	
	
	@Path("/selectConfirmList")
	@POST
	public String selectConfirmList(String params);
	
}
