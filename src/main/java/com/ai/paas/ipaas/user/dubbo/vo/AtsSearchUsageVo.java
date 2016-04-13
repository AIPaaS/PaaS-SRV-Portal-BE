package com.ai.paas.ipaas.user.dubbo.vo;

public class AtsSearchUsageVo {
	private String 	userId;
	private String applyType;
	private String serviceId;
	private String topicEnName;
	private String parition;
	private String offset;
	private Long userServId;
	public Long getUserServId() {
		return userServId;
	}
	public void setUserServId(Long userServId) {
		this.userServId = userServId;
	}
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
	public String getParition() {
		return parition;
	}
	public void setParition(String parition) {
		this.parition = parition;
	}
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
}
