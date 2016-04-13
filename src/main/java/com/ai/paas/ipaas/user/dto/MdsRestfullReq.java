package com.ai.paas.ipaas.user.dto;

/**
 * 请求restfull服务请求
 * @author mapl
 */
public class MdsRestfullReq {
	private String userId;
	private String applyType;
	private String serviceId;
	private String topicEnName;
	
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
	public String getTopicEnName() {
		return topicEnName;
	}
	public void setTopicEnName(String topicEnName) {
		this.topicEnName = topicEnName;
	}
}
