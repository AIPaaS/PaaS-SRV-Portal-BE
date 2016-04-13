package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class MdsPartitionVo implements Serializable {

	private static final long serialVersionUID = -2111706726566522902L;

	private String topicEnName;

	private String partitionId;

	private String totalOffset;

	private String avalOffset;

	private String consumedOffset;

	public String getTopicEnName() {
		return topicEnName;
	}

	public void setTopicEnName(String topicEnName) {
		this.topicEnName = topicEnName;
	}

	public String getPartitionId() {
		return partitionId;
	}

	public void setPartitionId(String partitionId) {
		this.partitionId = partitionId;
	}

	public String getTotalOffset() {
		return totalOffset;
	}

	public void setTotalOffset(String totalOffset) {
		this.totalOffset = totalOffset;
	}

	public String getAvalOffset() {
		return avalOffset;
	}

	public void setAvalOffset(String avalOffset) {
		this.avalOffset = avalOffset;
	}

	public String getConsumedOffset() {
		return consumedOffset;
	}

	public void setConsumedOffset(String consumedOffset) {
		this.consumedOffset = consumedOffset;
	}



}
