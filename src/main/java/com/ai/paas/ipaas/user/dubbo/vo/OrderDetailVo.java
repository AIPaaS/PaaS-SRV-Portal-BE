package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderDetailVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long orderDetailId;

    private String operateType;

    private String userId;

    private String prodType;

    private String prodId;

    private String prodByname;

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

    private String userServId;

    private String userServIpaasId;

    private String prodParam;
    
    private String prodParamZh;
    
    private String userOrgName;

    private String userEmail;

    private String userPhoneNum;

    private String userState;

    private Timestamp userRegisterTime;

    private Timestamp userActiveTime;

    private Timestamp userCancelTime;

    private String userInsideTag;
    
    private String userServIpaasPwd;
    
    private Short vmNumber;


	public Short getVmNumber() {
		return vmNumber;
	}

	public void setVmNumber(Short vmNumber) {
		this.vmNumber = vmNumber;
	}

	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdByname() {
		return prodByname;
	}

	public void setProdByname(String prodByname) {
		this.prodByname = prodByname;
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

	public String getUserServId() {
		return userServId;
	}

	public void setUserServId(String userServId) {
		this.userServId = userServId;
	}

	public String getUserServIpaasId() {
		return userServIpaasId;
	}

	public void setUserServIpaasId(String userServIpaasId) {
		this.userServIpaasId = userServIpaasId;
	}

	public String getProdParam() {
		return prodParam;
	}

	public void setProdParam(String prodParam) {
		this.prodParam = prodParam;
	}
	
	public String getProdParamZh() {
		return prodParamZh;
	}

	public void setProdParamZh(String prodParamZh) {
		this.prodParamZh = prodParamZh;
	}

	public String getUserOrgName() {
		return userOrgName;
	}

	public void setUserOrgName(String userOrgName) {
		this.userOrgName = userOrgName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoneNum() {
		return userPhoneNum;
	}

	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public Timestamp getUserRegisterTime() {
		return userRegisterTime;
	}

	public void setUserRegisterTime(Timestamp userRegisterTime) {
		this.userRegisterTime = userRegisterTime;
	}

	public Timestamp getUserActiveTime() {
		return userActiveTime;
	}

	public void setUserActiveTime(Timestamp userActiveTime) {
		this.userActiveTime = userActiveTime;
	}

	public Timestamp getUserCancelTime() {
		return userCancelTime;
	}

	public void setUserCancelTime(Timestamp userCancelTime) {
		this.userCancelTime = userCancelTime;
	}

	public String getUserInsideTag() {
		return userInsideTag;
	}

	public void setUserInsideTag(String userInsideTag) {
		this.userInsideTag = userInsideTag;
	}

	public String getUserServIpaasPwd() {
		return userServIpaasPwd;
	}

	public void setUserServIpaasPwd(String userServIpaasPwd) {
		this.userServIpaasPwd = userServIpaasPwd;
	}
    
    

}
