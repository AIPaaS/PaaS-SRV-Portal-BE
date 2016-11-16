package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;

public class OrderDetail {
    private Long orderDetailId;

    private String operateType;

    private String userId;
    
    private Integer orgId;

    private String prodType;

    private String prodId;

    private String prodByname;

    private String prodParamZh;

    private Short vmNumber;

    private Timestamp orderAppDate;

    private Timestamp preOpenDate;

    private String openStatus;

    private String openParam;

    private String openResult;

    private Timestamp openDate;

    private String orderCheckStatus;

    private String orderCheckResult;

    private Timestamp orderCheckDate;

    private String orderCheckDesc;

    private String orderStatus;

    private String userServId;

    private String userServIpaasId;

    private String userServIpaasPwd;

    private String applicant;

    private String applicantDept;

    private String applicantTel;

    private String applicantEmail;

    private String applicantReason;

    private String applicantDesc;

    private Timestamp expirationDate;

    private String belongCloud;

    private String wfInstId;

    private String softsConfig;

    private String sbutractFlag;

    private String prodParam;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType == null ? null : prodType.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public String getProdByname() {
        return prodByname;
    }

    public void setProdByname(String prodByname) {
        this.prodByname = prodByname == null ? null : prodByname.trim();
    }

    public String getProdParamZh() {
        return prodParamZh;
    }

    public void setProdParamZh(String prodParamZh) {
        this.prodParamZh = prodParamZh == null ? null : prodParamZh.trim();
    }

    public Short getVmNumber() {
        return vmNumber;
    }

    public void setVmNumber(Short vmNumber) {
        this.vmNumber = vmNumber;
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
        this.openStatus = openStatus == null ? null : openStatus.trim();
    }

    public String getOpenParam() {
        return openParam;
    }

    public void setOpenParam(String openParam) {
        this.openParam = openParam == null ? null : openParam.trim();
    }

    public String getOpenResult() {
        return openResult;
    }

    public void setOpenResult(String openResult) {
        this.openResult = openResult == null ? null : openResult.trim();
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
        this.orderCheckStatus = orderCheckStatus == null ? null : orderCheckStatus.trim();
    }

    public String getOrderCheckResult() {
        return orderCheckResult;
    }

    public void setOrderCheckResult(String orderCheckResult) {
        this.orderCheckResult = orderCheckResult == null ? null : orderCheckResult.trim();
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
        this.orderCheckDesc = orderCheckDesc == null ? null : orderCheckDesc.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getUserServId() {
        return userServId;
    }

    public void setUserServId(String userServId) {
        this.userServId = userServId == null ? null : userServId.trim();
    }

    public String getUserServIpaasId() {
        return userServIpaasId;
    }

    public void setUserServIpaasId(String userServIpaasId) {
        this.userServIpaasId = userServIpaasId == null ? null : userServIpaasId.trim();
    }

    public String getUserServIpaasPwd() {
        return userServIpaasPwd;
    }

    public void setUserServIpaasPwd(String userServIpaasPwd) {
        this.userServIpaasPwd = userServIpaasPwd == null ? null : userServIpaasPwd.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public String getApplicantDept() {
        return applicantDept;
    }

    public void setApplicantDept(String applicantDept) {
        this.applicantDept = applicantDept == null ? null : applicantDept.trim();
    }

    public String getApplicantTel() {
        return applicantTel;
    }

    public void setApplicantTel(String applicantTel) {
        this.applicantTel = applicantTel == null ? null : applicantTel.trim();
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail == null ? null : applicantEmail.trim();
    }

    public String getApplicantReason() {
        return applicantReason;
    }

    public void setApplicantReason(String applicantReason) {
        this.applicantReason = applicantReason == null ? null : applicantReason.trim();
    }

    public String getApplicantDesc() {
        return applicantDesc;
    }

    public void setApplicantDesc(String applicantDesc) {
        this.applicantDesc = applicantDesc == null ? null : applicantDesc.trim();
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBelongCloud() {
        return belongCloud;
    }

    public void setBelongCloud(String belongCloud) {
        this.belongCloud = belongCloud == null ? null : belongCloud.trim();
    }

    public String getWfInstId() {
        return wfInstId;
    }

    public void setWfInstId(String wfInstId) {
        this.wfInstId = wfInstId == null ? null : wfInstId.trim();
    }

    public String getSoftsConfig() {
        return softsConfig;
    }

    public void setSoftsConfig(String softsConfig) {
        this.softsConfig = softsConfig == null ? null : softsConfig.trim();
    }

    public String getSbutractFlag() {
        return sbutractFlag;
    }

    public void setSbutractFlag(String sbutractFlag) {
        this.sbutractFlag = sbutractFlag == null ? null : sbutractFlag.trim();
    }

    public String getProdParam() {
        return prodParam;
    }

    public void setProdParam(String prodParam) {
        this.prodParam = prodParam == null ? null : prodParam.trim();
    }

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
}