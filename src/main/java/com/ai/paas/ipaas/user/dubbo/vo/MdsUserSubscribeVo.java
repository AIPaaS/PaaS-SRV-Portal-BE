package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class MdsUserSubscribeVo implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 8118707793574214012L;

	private String subscribeName;

    private String userId;

    private String topicEnName;
    
    private String userServIpaasId;
 
    public String getSubscribeName() {
        return subscribeName;
    }

    public void setSubscribeName(String subscribeName) {
        this.subscribeName = subscribeName == null ? null : subscribeName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTopicEnName() {
        return topicEnName;
    }

    public void setTopicEnName(String topicEnName) {
        this.topicEnName = topicEnName == null ? null : topicEnName.trim();
    }

	public String getUserServIpaasId() {
		return userServIpaasId;
	}

	public void setUserServIpaasId(String userServIpaasId) {
		this.userServIpaasId = userServIpaasId;
	}

    
}