package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;

public class UserCenter {
    private String userId;

    private String userOrgName;

    private String userEmail;

    private String userPhoneNum;

    private String userState;

    private Timestamp userRegisterTime;

    private Timestamp userActiveTime;

    private Timestamp userCancelTime;

    private String userInsideTag;

    private String partnerType;

    private String partnerAccount;

    private String pid;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserOrgName() {
        return userOrgName;
    }

    public void setUserOrgName(String userOrgName) {
        this.userOrgName = userOrgName == null ? null : userOrgName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum == null ? null : userPhoneNum.trim();
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    public Timestamp getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Timestamp userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public Timestamp getUserActiveTime() {
        return userActiveTime;
    }

    public void setUserActiveTime(Timestamp userActiveTime) {
        this.userActiveTime = userActiveTime;
    }

    public Timestamp getUserCancelTime() {
        return userCancelTime;
    }

    public void setUserCancelTime(Timestamp userCancelTime) {
        this.userCancelTime = userCancelTime;
    }

    public String getUserInsideTag() {
        return userInsideTag;
    }

    public void setUserInsideTag(String userInsideTag) {
        this.userInsideTag = userInsideTag == null ? null : userInsideTag.trim();
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType == null ? null : partnerType.trim();
    }

    public String getPartnerAccount() {
        return partnerAccount;
    }

    public void setPartnerAccount(String partnerAccount) {
        this.partnerAccount = partnerAccount == null ? null : partnerAccount.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }
}