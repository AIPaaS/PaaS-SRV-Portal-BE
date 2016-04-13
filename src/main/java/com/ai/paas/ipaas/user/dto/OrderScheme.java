package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;

public class OrderScheme {
    private Long schemeId;

    private Long orderDetailId;

    private String validFlag;

    private Timestamp schemeMakeTime;

    private String schemeMaker;

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    public Timestamp getSchemeMakeTime() {
        return schemeMakeTime;
    }

    public void setSchemeMakeTime(Timestamp schemeMakeTime) {
        this.schemeMakeTime = schemeMakeTime;
    }

    public String getSchemeMaker() {
        return schemeMaker;
    }

    public void setSchemeMaker(String schemeMaker) {
        this.schemeMaker = schemeMaker == null ? null : schemeMaker.trim();
    }
}