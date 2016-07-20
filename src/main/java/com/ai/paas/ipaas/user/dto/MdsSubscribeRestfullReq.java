package com.ai.paas.ipaas.user.dto;

/**
 * 请求restfull服务请求
 * @author mapl
 */
public class MdsSubscribeRestfullReq {

	private String subscribeName;

    private String userId;

    private String topicEnName;
    
    private String userServIpaasId;

	public String getSubscribeName() {
		return subscribeName;
	}

	public void setSubscribeName(String subscribeName) {
		this.subscribeName = subscribeName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTopicEnName() {
		return topicEnName;
	}

	public void setTopicEnName(String topicEnName) {
		this.topicEnName = topicEnName;
	}

	public String getUserServIpaasId() {
		return userServIpaasId;
	}

	public void setUserServIpaasId(String userServIpaasId) {
		this.userServIpaasId = userServIpaasId;
	}
	
    
}
