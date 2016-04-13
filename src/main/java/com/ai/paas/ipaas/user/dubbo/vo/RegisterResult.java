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

}
