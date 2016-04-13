package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;

public class OrderWo {
    private Long orderWoId;

    private Long orderDetailId;

    private String wfTaskId;

    private String roleId;

    private String operateId;

    private Timestamp woCreateDate;

    private String woStatus;

    private String woDesc;

    private Timestamp woDate;

    private String displayFlag;

    private String woResult;

    private String receiptUrl;

    public Long getOrderWoId() {
        return orderWoId;
    }

    public void setOrderWoId(Long orderWoId) {
        this.orderWoId = orderWoId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getWfTaskId() {
        return wfTaskId;
    }

    public void setWfTaskId(String wfTaskId) {
        this.wfTaskId = wfTaskId == null ? null : wfTaskId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getOperateId() {
        return operateId;
    }

    public void setOperateId(String operateId) {
        this.operateId = operateId == null ? null : operateId.trim();
    }

    public Timestamp getWoCreateDate() {
        return woCreateDate;
    }

    public void setWoCreateDate(Timestamp woCreateDate) {
        this.woCreateDate = woCreateDate;
    }

    public String getWoStatus() {
        return woStatus;
    }

    public void setWoStatus(String woStatus) {
        this.woStatus = woStatus == null ? null : woStatus.trim();
    }

    public String getWoDesc() {
        return woDesc;
    }

    public void setWoDesc(String woDesc) {
        this.woDesc = woDesc == null ? null : woDesc.trim();
    }

    public Timestamp getWoDate() {
        return woDate;
    }

    public void setWoDate(Timestamp woDate) {
        this.woDate = woDate;
    }

    public String getDisplayFlag() {
        return displayFlag;
    }

    public void setDisplayFlag(String displayFlag) {
        this.displayFlag = displayFlag == null ? null : displayFlag.trim();
    }

    public String getWoResult() {
        return woResult;
    }

    public void setWoResult(String woResult) {
        this.woResult = woResult == null ? null : woResult.trim();
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public void setReceiptUrl(String receiptUrl) {
        this.receiptUrl = receiptUrl == null ? null : receiptUrl.trim();
    }
}