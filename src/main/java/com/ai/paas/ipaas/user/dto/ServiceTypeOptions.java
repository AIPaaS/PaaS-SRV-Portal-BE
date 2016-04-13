package com.ai.paas.ipaas.user.dto;

public class ServiceTypeOptions {
    private Integer id;

    private Integer serviceId;

    private String serviceValue;

    private String serviceOption;

    private String isValidate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
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

    public String getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(String isValidate) {
        this.isValidate = isValidate == null ? null : isValidate.trim();
    }
}