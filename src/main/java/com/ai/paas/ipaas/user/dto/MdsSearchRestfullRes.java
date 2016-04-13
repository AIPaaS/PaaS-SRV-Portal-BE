package com.ai.paas.ipaas.user.dto;

/**
 * 请求restfull服务请求
 * @author mapl
 */
public class MdsSearchRestfullRes {
	
	private String userId;
	private String applyType;
	private String serviceId;
	private String resultCode;
	private String resultMsg;
	private String topicMessage;
	
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
	public String getTopicMessage() {
		return topicMessage;
	}
	public void setTopicMessage(String topicMessage) {
		this.topicMessage = topicMessage;
	}

	
}
