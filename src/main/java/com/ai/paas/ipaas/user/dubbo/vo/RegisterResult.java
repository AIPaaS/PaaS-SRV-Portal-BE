package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class RegisterResult implements Serializable {

	/**
	 * 用户注册结果返回
	 */
	private static final long serialVersionUID = 8409161371747465211L;

	public RegisterResult() {
	}

	private String userId = null;
	private boolean registerSuccess = false;
	private String userState = null;

	/** added in 2016-06-12 **/
	private boolean isNeedSend = false;
	private EmailDetail email = null;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isRegisterSuccess() {
		return registerSuccess;
	}

	public void setRegisterSuccess(boolean registerSuccess) {
		this.registerSuccess = registerSuccess;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public boolean isNeedSend() {
		return isNeedSend;
	}

	public void setNeedSend(boolean isNeedSend) {
		this.isNeedSend = isNeedSend;
	}

	public EmailDetail getEmail() {
		return email;
	}

	public void setEmail(EmailDetail email) {
		this.email = email;
	}

}
