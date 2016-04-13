package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class MdsSearchMessageVo implements Serializable {

	private static final long serialVersionUID = -2111706726566522902L;

	private String topicEnName;

	private String partition;

	private String offset;

	private String applyType;

	private String userId;
	
	private Long userServId;

	public String getTopicEnName() {
		return topicEnName;
	}

	public void setTopicEnName(String topicEnName) {
		this.topicEnName = topicEnName;
	}

	public String getPartition() {
		return partition;
	}

	public void setPartition(String partition) {
		this.partition = partition;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getUserServId() {
		return userServId;
	}

	public void setUserServId(Long userServId) {
		this.userServId = userServId;
	}

	


}
