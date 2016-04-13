package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;

public class UserMessage {
    private Integer userMsgId;

    private String userId;

    private String userMsgContent;

    private Timestamp userMsgSendTime;

    public Integer getUserMsgId() {
        return userMsgId;
    }

    public void setUserMsgId(Integer userMsgId) {
        this.userMsgId = userMsgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserMsgContent() {
        return userMsgContent;
    }

    public void setUserMsgContent(String userMsgContent) {
        this.userMsgContent = userMsgContent == null ? null : userMsgContent.trim();
    }

    public Timestamp getUserMsgSendTime() {
        return userMsgSendTime;
    }

    public void setUserMsgSendTime(Timestamp userMsgSendTime) {
        this.userMsgSendTime = userMsgSendTime;
    }
}