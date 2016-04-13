package com.ai.paas.ipaas.user.dto;

/**
 * 请求restfull服务请求
 * @author mapl
 */
public class RestfullReq {
	private String userId;
	private String applyType;
	private String serviceId;
	private String key;
	private String size;
	private String limitFileSize;	
	private String newPwd;
	private String oldPwd;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getLimitFileSize() {
		return limitFileSize;
	}
	public void setLimitFileSize(String limitFileSize) {
		this.limitFileSize = limitFileSize;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}	
}
