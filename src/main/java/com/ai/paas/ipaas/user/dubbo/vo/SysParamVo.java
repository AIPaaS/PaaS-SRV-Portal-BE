package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class SysParamVo implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;

    private int serviceId;
    
    private String typeCode;
    
    private String paramCode;
    
    private String serviceValue;

    private String serviceOption;
    
    private String isValidate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
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