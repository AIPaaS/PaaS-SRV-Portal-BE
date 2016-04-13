package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class SysParmRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 private int serviceId;
	 private String typeCode;
	 private String paramCode;
	 private String serviceValue;
	 

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
		this.serviceValue = serviceValue;
	}

}
