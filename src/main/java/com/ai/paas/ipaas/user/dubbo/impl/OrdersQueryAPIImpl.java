package com.ai.paas.ipaas.user.dubbo.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.user.dubbo.interfaces.IOrdersQueryAPI;
import com.ai.paas.ipaas.user.service.IOrdersQuerySv;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.vo.OrdersForm;
import com.ai.paas.ipaas.util.JSonUtil;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 订单信息查询
 * @author renfeng
 *
 */
@Service
public class OrdersQueryAPIImpl implements IOrdersQueryAPI{
	private static final Logger logger = LogManager.getLogger(OrdersQueryAPIImpl.class
            .getName());
	@Autowired
	private IOrdersQuerySv ordersQuerySvImpl;
	@Override
	public String ordersQuery(String params) {
		if(params==null || "".equals(params)){
			return "入参不能为空！";
		}
		logger.info("订单信息查询入参：---->"+params);
		OrdersForm fromJSon = JSonUtil.fromJSon(params, OrdersForm.class);
		try {
			fromJSon.setPageSize(fromJSon.getPageSize());
			String queryOrders = ordersQuerySvImpl.queryOrders(fromJSon);
			logger.info("订单信息查询出参：---->"+queryOrders);
			return queryOrders;
		} catch (SQLException e) {
			logger.error("订单信息查询系统异常：---->"+e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

}
