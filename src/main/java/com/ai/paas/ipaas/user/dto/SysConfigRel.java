package com.ai.paas.ipaas.user.dto;

public class SysConfigRel {
    private Short sysConfigRelId;

    private Short parentParamId;

    private Short childParamId;

    public Short getSysConfigRelId() {
        return sysConfigRelId;
    }

    public void setSysConfigRelId(Short sysConfigRelId) {
        this.sysConfigRelId = sysConfigRelId;
    }

    public Short getParentParamId() {
        return parentParamId;
    }

    public void setParentParamId(Short parentParamId) {
        this.parentParamId = parentParamId;
    }

    public Short getChildParamId() {
        return childParamId;
    }

    public void setChildParamId(Short childParamId) {
        this.childParamId = childParamId;
    }
}