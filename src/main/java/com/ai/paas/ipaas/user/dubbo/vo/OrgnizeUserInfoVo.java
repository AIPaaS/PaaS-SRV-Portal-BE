package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class OrgnizeUserInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer orgId;

    private String userId;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}