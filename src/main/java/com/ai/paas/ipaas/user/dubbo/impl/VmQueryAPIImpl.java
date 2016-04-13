package com.ai.paas.ipaas.user.dubbo.impl;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.user.dubbo.interfaces.IVmQueryAPI;
import com.ai.paas.ipaas.user.service.IVmQuerySv;
import com.ai.paas.ipaas.user.vo.OrdersForm;
import com.ai.paas.ipaas.util.JSonUtil;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Transactional
public class VmQueryAPIImpl implements IVmQueryAPI {
	private static final Logger logger = LogManager.getLogger(VmQueryAPIImpl.class
            .getName());
	@Autowired
	private IVmQuerySv vmQuerySvImpl;
	@Override
	public String queryOrderDetail(String params) {
		
		logger.info("==========工单跟踪订单列表查询入参======="+params);
		OrdersForm fromJSon = JSonUtil.fromJSon(params, OrdersForm.class);
		try {
			fromJSon.setPageSize(fromJSon.getPageSize());
			String queryOrders = vmQuerySvImpl.queryOrderDetail(fromJSon);
			logger.info("==========工单跟踪订单列表查询出参======="+queryOrders);
			return queryOrders;
		} catch (Exception e) {
			logger.error("==========工单跟踪订单列表查询异常：=="+e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
	@Override
	public String queryOrderWo(String orderDetailId) {
		
		logger.info("==========工单跟踪查询工单入参======="+orderDetailId);
		try {
			String queryOrders = vmQuerySvImpl.queryOrderWo(orderDetailId);
			logger.info("=======工单跟踪查询工单出参======="+queryOrders);
			return queryOrders;
		} catch (Exception e) {
			logger.error("=======工单跟踪查询工单出参======="+e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

}
