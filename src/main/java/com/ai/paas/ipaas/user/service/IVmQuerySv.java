package com.ai.paas.ipaas.user.service;

import com.ai.paas.ipaas.user.vo.OrdersForm;

/**
 * 虚拟机工单查询
 * @author renfeng
 *
 */
public interface IVmQuerySv {
	/**
	 * 查询虚拟机订单列表
	 * @return
	 */
	public String queryOrderDetail(OrdersForm orderform);
	/**
	 * 查询工单处理流程
	 * @param orderDetailId
	 * @return
	 */
	public String queryOrderWo(String orderDetailId);
}
