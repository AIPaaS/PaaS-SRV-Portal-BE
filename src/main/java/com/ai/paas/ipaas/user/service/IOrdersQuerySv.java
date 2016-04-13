package com.ai.paas.ipaas.user.service;

import java.sql.SQLException;

import com.ai.paas.ipaas.user.vo.OrdersForm;

/**
 * 订单查询
 * @author renfeng
 *
 */
public interface IOrdersQuerySv {
	/**
	 * 订单查询
	 * @param orderform
	 * @return
	 * @throws SQLException
	 */
	public String queryOrders(OrdersForm orderform) throws SQLException;
}
