package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;

public class UserProdInst {
    private Long userServId;

    private String userId;

    private String userServType;

    private String userServiceId;

    private String userServIpaasId;

    private String userServParam;

    private String userServParamZh;

    private String userProdByname;

    private String userServState;

    private Timestamp userServOpenTime;

    private String userServBackParam;

    private Timestamp userServCloseTime;

    private String userServRunState;

    private Timestamp userServStartTime;

    private Timestamp userServStopTime;

    public Long getUserServId() {
        return userServId;
    }

    public void setUserServId(Long userServId) {
        this.userServId = userServId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserServType() {
        return userServType;
    }

    public void setUserServType(String userServType) {
        this.userServType = userServType == null ? null : userServType.trim();
    }

    public String getUserServiceId() {
        return userServiceId;
    }

    public void setUserServiceId(String userServiceId) {
        this.userServiceId = userServiceId == null ? null : userServiceId.trim();
    }

    public String getUserServIpaasId() {
        return userServIpaasId;
    }

    public void setUserServIpaasId(String userServIpaasId) {
        this.userServIpaasId = userServIpaasId == null ? null : userServIpaasId.trim();
    }

    public String getUserServParam() {
        return userServParam;
    }

    public void setUserServParam(String userServParam) {
        this.userServParam = userServParam == null ? null : userServParam.trim();
    }

    public String getUserServParamZh() {
        return userServParamZh;
    }

    public void setUserServParamZh(String userServParamZh) {
        this.userServParamZh = userServParamZh == null ? null : userServParamZh.trim();
    }

    public String getUserProdByname() {
        return userProdByname;
    }

    public void setUserProdByname(String userProdByname) {
        this.userProdByname = userProdByname == null ? null : userProdByname.trim();
    }

    public String getUserServState() {
        return userServState;
    }

    public void setUserServState(String userServState) {
        this.userServState = userServState == null ? null : userServState.trim();
    }

    public Timestamp getUserServOpenTime() {
        return userServOpenTime;
    }

    public void setUserServOpenTime(Timestamp userServOpenTime) {
        this.userServOpenTime = userServOpenTime;
    }

    public String getUserServBackParam() {
        return userServBackParam;
    }

    public void setUserServBackParam(String userServBackParam) {
        this.userServBackParam = userServBackParam == null ? null : userServBackParam.trim();
    }

    public Timestamp getUserServCloseTime() {
        return userServCloseTime;
    }

    public void setUserServCloseTime(Timestamp userServCloseTime) {
        this.userServCloseTime = userServCloseTime;
    }

    public String getUserServRunState() {
        return userServRunState;
    }

    public void setUserServRunState(String userServRunState) {
        this.userServRunState = userServRunState == null ? null : userServRunState.trim();
    }

    public Timestamp getUserServStartTime() {
        return userServStartTime;
    }

    public void setUserServStartTime(Timestamp userServStartTime) {
        this.userServStartTime = userServStartTime;
    }

    public Timestamp getUserServStopTime() {
        return userServStopTime;
    }

    public void setUserServStopTime(Timestamp userServStopTime) {
        this.userServStopTime = userServStopTime;
    }
}