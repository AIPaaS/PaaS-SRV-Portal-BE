package com.ai.paas.ipaas.user.dto;

public class SysConfig {
    private Integer id;

    private String typeCode;

    private String paramCode;

    private String serviceValue;

    private String serviceOption;

    private String descb;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode == null ? null : paramCode.trim();
    }

    public String getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(String serviceValue) {
        this.serviceValue = serviceValue == null ? null : serviceValue.trim();
    }

    public String getServiceOption() {
        return serviceOption;
    }

    public void setServiceOption(String serviceOption) {
        this.serviceOption = serviceOption == null ? null : serviceOption.trim();
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb == null ? null : descb.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}