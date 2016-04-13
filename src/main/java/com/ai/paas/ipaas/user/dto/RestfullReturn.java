package com.ai.paas.ipaas.user.dto;

/**
 * 请求restfull服务返回结果
 * @author mapl
 */
public class RestfullReturn {
	private String userId;
	private String applyType;
	private String serviceId;
	private String resultCode;
	private String resultMsg;
	private String resultMessage;;
	private String size;
	private String usedSize;
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
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getUsedSize() {
		return usedSize;
	}
	public void setUsedSize(String usedSize) {
		this.usedSize = usedSize;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
		
}
