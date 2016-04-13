package com.ai.paas.ipaas.user.dubbo.vo;

import java.sql.Timestamp;

public class UserMessageVo {
    private int userMsgId;

    private String userId;

    private String userMsgContent;

    private Timestamp userMsgSendTime;

    public int getUserMsgId() {
        return userMsgId;
    }

    public void setUserMsgId(int userMsgId) {
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