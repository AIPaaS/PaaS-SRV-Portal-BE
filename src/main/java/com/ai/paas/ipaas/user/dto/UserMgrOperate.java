package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;

public class UserMgrOperate {
    private Long userOperateId;

    private String userId;

    private String userProdType;

    private String userProdId;

    private String userServId;

    private String userServIpaasId;

    private String userProdParam;

    private String userProdByname;

    private String userOperateAction;

    private Timestamp userOperateDate;

    private String userUpdateBefore;

    private String userUpdateAfter;

    private String userOperateResult;

    public Long getUserOperateId() {
        return userOperateId;
    }

    public void setUserOperateId(Long userOperateId) {
        this.userOperateId = userOperateId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserProdType() {
        return userProdType;
    }

    public void setUserProdType(String userProdType) {
        this.userProdType = userProdType == null ? null : userProdType.trim();
    }

    public String getUserProdId() {
        return userProdId;
    }

    public void setUserProdId(String userProdId) {
        this.userProdId = userProdId == null ? null : userProdId.trim();
    }

    public String getUserServId() {
        return userServId;
    }

    public void setUserServId(String userServId) {
        this.userServId = userServId == null ? null : userServId.trim();
    }

    public String getUserServIpaasId() {
        return userServIpaasId;
    }

    public void setUserServIpaasId(String userServIpaasId) {
        this.userServIpaasId = userServIpaasId == null ? null : userServIpaasId.trim();
    }

    public String getUserProdParam() {
        return userProdParam;
    }

    public void setUserProdParam(String userProdParam) {
        this.userProdParam = userProdParam == null ? null : userProdParam.trim();
    }

    public String getUserProdByname() {
        return userProdByname;
    }

    public void setUserProdByname(String userProdByname) {
        this.userProdByname = userProdByname == null ? null : userProdByname.trim();
    }

    public String getUserOperateAction() {
        return userOperateAction;
    }

    public void setUserOperateAction(String userOperateAction) {
        this.userOperateAction = userOperateAction == null ? null : userOperateAction.trim();
    }

    public Timestamp getUserOperateDate() {
        return userOperateDate;
    }

    public void setUserOperateDate(Timestamp userOperateDate) {
        this.userOperateDate = userOperateDate;
    }

    public String getUserUpdateBefore() {
        return userUpdateBefore;
    }

    public void setUserUpdateBefore(String userUpdateBefore) {
        this.userUpdateBefore = userUpdateBefore == null ? null : userUpdateBefore.trim();
    }

    public String getUserUpdateAfter() {
        return userUpdateAfter;
    }

    public void setUserUpdateAfter(String userUpdateAfter) {
        this.userUpdateAfter = userUpdateAfter == null ? null : userUpdateAfter.trim();
    }

    public String getUserOperateResult() {
        return userOperateResult;
    }

    public void setUserOperateResult(String userOperateResult) {
        this.userOperateResult = userOperateResult == null ? null : userOperateResult.trim();
    }
}