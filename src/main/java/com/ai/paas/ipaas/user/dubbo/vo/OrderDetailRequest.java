package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderDetailRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String operateType;

	private String userId;

	private String prodType;

	private String prodId;

	private String prodByname;

	private String prodParam;

	private long orderDetailId;

	private Timestamp orderAppDate;

	private Timestamp preOpenDate;

	private String openStatus;

	private String openResult;

	private Timestamp openDate;

	private String orderCheckStatus;

	private String orderCheckResult;

	private Timestamp orderCheckDate;

	private String orderCheckDesc;

	private String orderStatus;

	private long userServId;

	private String userServIpaasId;
	
	private String userServIpaasPwd;
	
	private String tenantId;

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdByname() {
		return prodByname;
	}

	public void setProdByname(String prodByname) {
		this.prodByname = prodByname;
	}

	public String getProdParam() {
		return prodParam;
	}

	public void setProdParam(String prodParam) {
		this.prodParam = prodParam;
	}

	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Timestamp getOrderAppDate() {
		return orderAppDate;
	}

	public void setOrderAppDate(Timestamp orderAppDate) {
		this.orderAppDate = orderAppDate;
	}

	public Timestamp getPreOpenDate() {
		return preOpenDate;
	}

	public void setPreOpenDate(Timestamp preOpenDate) {
		this.preOpenDate = preOpenDate;
	}

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public String getOpenResult() {
		return openResult;
	}

	public void setOpenResult(String openResult) {
		this.openResult = openResult;
	}

	public Timestamp getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Timestamp openDate) {
		this.openDate = openDate;
	}

	public String getOrderCheckStatus() {
		return orderCheckStatus;
	}

	public void setOrderCheckStatus(String orderCheckStatus) {
		this.orderCheckStatus = orderCheckStatus;
	}

	public String getOrderCheckResult() {
		return orderCheckResult;
	}

	public void setOrderCheckResult(String orderCheckResult) {
		this.orderCheckResult = orderCheckResult;
	}

	public Timestamp getOrderCheckDate() {
		return orderCheckDate;
	}

	public void setOrderCheckDate(Timestamp orderCheckDate) {
		this.orderCheckDate = orderCheckDate;
	}

	public String getOrderCheckDesc() {
		return orderCheckDesc;
	}

	public void setOrderCheckDesc(String orderCheckDesc) {
		this.orderCheckDesc = orderCheckDesc;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getUserServId() {
		return userServId;
	}

	public void setUserServId(long userServId) {
		this.userServId = userServId;
	}

	public String getUserServIpaasId() {
		return userServIpaasId;
	}

	public void setUserServIpaasId(String userServIpaasId) {
		this.userServIpaasId = userServIpaasId;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getUserServIpaasPwd() {
		return userServIpaasPwd;
	}

	public void setUserServIpaasPwd(String userServIpaasPwd) {
		this.userServIpaasPwd = userServIpaasPwd;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	

}
