package com.ai.paas.ipaas.user.dao.mapper.bo;

public class OrgnizeUserInfoKey {
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
        this.userId = userId == null ? null : userId.trim();
    }
}