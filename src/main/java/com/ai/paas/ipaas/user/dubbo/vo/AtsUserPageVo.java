package com.ai.paas.ipaas.user.dubbo.vo;

import java.util.List;

public class AtsUserPageVo {
	private String userId;
	private String applyType;
	private String serviceId;
	private String resultCode;
	private String resultMsg;
	private List<AtsPartitionVo> topicUsage;
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
	public List<AtsPartitionVo> getTopicUsage() {
		return topicUsage;
	}
	public void setTopicUsage(List<AtsPartitionVo> topicUsage) {
		this.topicUsage = topicUsage;
	}
}
