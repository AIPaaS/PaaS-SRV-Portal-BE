package com.ai.paas.ipaas.user.dto;

import java.io.Serializable;
import java.util.Date;

public class UserServiceInfo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -320513556254195462L;
	/**
	 * 
	 */
	private String userId;
	private String userName;
	private Date updateTime;
	private String serviceId;
	private int serviceType;
	private int serviceNumber;
	private String serviceParam;
	private int status;
	private Date validateTime;
	private Date invalidateTime;
	private String url;
	private String serviceName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public int getServiceType() {
		return serviceType;
	}
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	public int getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(int serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public String getServiceParam() {
		return serviceParam;
	}
	public void setServiceParam(String serviceParam) {
		this.serviceParam = serviceParam;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getValidateTime() {
		return validateTime;
	}
	public void setValidateTime(Date validateTime) {
		this.validateTime = validateTime;
	}
	public Date getInvalidateTime() {
		return invalidateTime;
	}
	public void setInvalidateTime(Date invalidateTime) {
		this.invalidateTime = invalidateTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
	
}
