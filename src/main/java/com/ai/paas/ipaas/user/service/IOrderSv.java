package com.ai.paas.ipaas.user.service;

import java.util.Map;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.OrderDetail;
import com.ai.paas.ipaas.user.dubbo.vo.CheckOrdersRequest;
import com.ai.paas.ipaas.user.dubbo.vo.OrderDetailRequest;
import com.ai.paas.ipaas.user.dubbo.vo.OrderDetailVo;
import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.dubbo.vo.SelectOrderRequest;
import com.ai.paas.ipaas.user.vo.OrderDataVo;

public interface IOrderSv {
	
	public void saveOrderDetail(OrderDetailRequest orderDetailVo) throws PaasException;
	
	public PageResult<OrderDetailVo>  selectOrderDetails(SelectOrderRequest request) throws PaasException;

	public void checkOrders(CheckOrdersRequest request) throws PaasException;	
	
	public PageResult<OrderDetailVo>  selectOrderList(SelectOrderRequest request) throws PaasException;

	public void checkIaasOrders(CheckOrdersRequest request) throws PaasException;

	public Object saveIaasOrder(OrderDataVo orderDataVo) throws Exception;
	
	public OrderDetail selectByPrimaryKey(long orderDetailId) throws Exception;

	public Object saveIaasIntegratedScheme(Map paramMap) throws Exception;

	public Object saveIaasOpenParam(Map<String, Object> paramMap)  throws Exception;
	
	public Object updateIaasOrderProdparam(OrderDataVo orderDataVo) throws Exception;
}
