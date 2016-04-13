package com.ai.paas.ipaas.user.dto;

public class OrdStatusOperateRel {
    private Short operateRelId;

    private String orderStatus;

    private String ntAccount;

    private String mailGroup;

    private String validFlag;

    public Short getOperateRelId() {
        return operateRelId;
    }

    public void setOperateRelId(Short operateRelId) {
        this.operateRelId = operateRelId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getNtAccount() {
        return ntAccount;
    }

    public void setNtAccount(String ntAccount) {
        this.ntAccount = ntAccount == null ? null : ntAccount.trim();
    }

    public String getMailGroup() {
        return mailGroup;
    }

    public void setMailGroup(String mailGroup) {
        this.mailGroup = mailGroup == null ? null : mailGroup.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }
}