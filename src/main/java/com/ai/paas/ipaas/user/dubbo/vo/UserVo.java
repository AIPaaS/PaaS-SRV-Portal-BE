package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserVo implements Serializable {

	private static final long serialVersionUID = -2111706726566522902L;

	private String userId;
	
	private String userOrgName;

	private String userEmail;

	private String userPwd;

	private String userPhoneNum;

	private String userState;

	private Timestamp userRegisterTime;

	private Timestamp userActiveTime;

	private Timestamp userCancelTime;

	private String userInsideTag;

	private String userName;

	private String partnerType;

	private String partnerAccount;
	
	private String pid;
	
	private String newPwd;//新密码，用于修改密码
	private String oldEmail;//新邮箱，用于修改密码

    private String tenantId;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

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
		this.userInsideTag = userInsideTag;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	public String getPartnerAccount() {
		return partnerAccount;
	}

	public void setPartnerAccount(String partnerAccount) {
		this.partnerAccount = partnerAccount;
	}
    //用于修改密码，邮箱
	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	public String getOldEmail() {
		return oldEmail;
	}

	public void setOldEmail(String oldEmail) {
		this.oldEmail = oldEmail;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
