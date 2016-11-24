package com.ai.paas.ipaas.user.dubbo.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dubbo.interfaces.IOrder;
import com.ai.paas.ipaas.user.dubbo.vo.CheckOrdersRequest;
import com.ai.paas.ipaas.user.dubbo.vo.CheckOrdersResponse;
import com.ai.paas.ipaas.user.dubbo.vo.OrderDetailRequest;
import com.ai.paas.ipaas.user.dubbo.vo.OrderDetailResponse;
import com.ai.paas.ipaas.user.dubbo.vo.OrderDetailVo;
import com.ai.paas.ipaas.user.dubbo.vo.PageEntity;
import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.dubbo.vo.PlanConfirmVo;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.service.IOrderSv;
import com.ai.paas.ipaas.user.dubbo.vo.SelectOrderRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectOrderResponse;
import com.ai.paas.ipaas.user.service.IPlanConfirmSv;
import com.ai.paas.ipaas.util.JSonUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Transactional
public class OrderImpl implements IOrder{
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private IOrderSv orderSv;
	
	@Autowired
	private IPlanConfirmSv planConfirmSv;

	@Override
	public OrderDetailResponse saveOrderDetail(OrderDetailRequest request)  {	
		OrderDetailResponse response = new OrderDetailResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try{
			response = orderSv.saveOrderDetail(request);
			responseHeader.setResultCode(Constants.OPERATE_CODE_SUCCESS);
			responseHeader.setResultMessage("操作成功");
		}catch(Exception e){
			logger.error(e.getMessage());
			responseHeader.setResultCode(Constants.OPERATE_CODE_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}
		response.setResponseHeader(responseHeader);
		return response;
	}

	@Override
	public SelectOrderResponse selectOrderDetails(SelectOrderRequest request) throws PaasException{
		ResponseHeader responseHeader = new ResponseHeader();	
		PageResult<OrderDetailVo>   pageResult  = new PageResult<OrderDetailVo>();
		try{
			pageResult = orderSv.selectOrderDetails(request);
			responseHeader.setResultCode(Constants.OPERATE_CODE_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(Constants.OPERATE_CODE_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		SelectOrderResponse response = new SelectOrderResponse();
		response.setPageResult(pageResult);
		response.setResponseHeader(responseHeader);		
		return response;
	}

	@Override
	public SelectOrderResponse selectOrderList(SelectOrderRequest request) throws PaasException{
		ResponseHeader responseHeader = new ResponseHeader();	
		PageResult<OrderDetailVo>   pageResult  = new PageResult<OrderDetailVo>();
		try{
			pageResult = orderSv.selectOrderList(request);
			responseHeader.setResultCode(Constants.OPERATE_CODE_SUCCESS);
		}catch(Exception e){
			responseHeader.setResultCode(Constants.OPERATE_CODE_FAIL);
			e.printStackTrace();
			logger.error(e.getMessage());
		}		
		SelectOrderResponse response = new SelectOrderResponse();
		response.setPageResult(pageResult);
		response.setResponseHeader(responseHeader);		
		return response;
	}

	@Override
	public OrderDetailResponse checkOrders(CheckOrdersRequest request) {
		OrderDetailResponse response = new OrderDetailResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		logger.info("checkOrders start");	
		try{
			response = orderSv.checkOrders(request);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
			logger.info("checkOrders success");	
		}catch(PaasException e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);		
			responseHeader.setResultMessage(e.getMessage());
		}		
		response.setResponseHeader(responseHeader);		
		return response;
	}

	@Override
	public CheckOrdersResponse checkIaasOrders(CheckOrdersRequest request) {
		ResponseHeader responseHeader = new ResponseHeader();
		logger.info("checkIaasOrders start");	
		try{
			orderSv.checkIaasOrders(request);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
			logger.info("checkIaasOrders success");	
		}catch(PaasException e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);		
			responseHeader.setResultMessage(e.getMessage());
		}		
		CheckOrdersResponse response = new CheckOrdersResponse();
		response.setResponseHeader(responseHeader);		
		return response;
	}

	@Override
	public String verifyOrders(String params) {
		CheckOrdersRequest request = JSonUtil.fromJSon(params, CheckOrdersRequest.class);
		OrderDetailResponse response = checkOrders(request);
		return JSonUtil.toJSon(response);
	}

	@Override
	public String applyOrders(String params) {
		OrderDetailRequest request=JSonUtil.fromJSon(params, OrderDetailRequest.class);
		OrderDetailResponse response=saveOrderDetail(request);
		return JSonUtil.toJSon(response);
	}

	@Override
	public String selectConfirmList(String params) {
		Map<String, Object> confirmResult=new HashMap<String, Object>();
		logger.info("params:"+params);
		PageEntity pageEntity=JSonUtil.fromJSon(params, PageEntity.class);
		PageResult<PlanConfirmVo> result=new PageResult<PlanConfirmVo>();
		try {
			result=planConfirmSv.selectPlanConfirm(pageEntity);
			confirmResult.put("pageResult", result);
			confirmResult.put("resultCode", Constants.OPERATE_CODE_SUCCESS);
		} catch (SQLException e) {
			confirmResult.put("resultCode", Constants.OPERATE_CODE_FAIL);
			confirmResult.put("resultMsg", e.getMessage());
			e.printStackTrace();
		}
		return JSonUtil.toJSon(confirmResult);
	}
}
