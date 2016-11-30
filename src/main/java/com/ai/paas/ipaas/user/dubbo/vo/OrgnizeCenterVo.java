package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class OrgnizeCenterVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer orgId;

    private String orgCode;

    private String orgName;

    private Integer orgStatus;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(Integer orgStatus) {
        this.orgStatus = orgStatus;
    }
}