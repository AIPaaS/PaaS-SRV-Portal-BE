package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class AuthResult implements Serializable {

	private static final long serialVersionUID = -8679813724194117084L;

	public AuthResult() {
	}

	private String userId = null;
	private boolean authSuccess = false;
	private String authMsg = null;
	private String serviceId = null;
	/**
	 * 配置地址，ZK模式，IP:PORT;IP:PORT
	 */
	private String configAddr = null;
	private String configUser = null;
	private String configPasswd = null;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getConfigAddr() {
		return configAddr;
	}

	public void setConfigAddr(String configAddr) {
		this.configAddr = configAddr;
	}

	public String getConfigUser() {
		return configUser;
	}

	public void setConfigUser(String configUser) {
		this.configUser = configUser;
	}

	public String getConfigPasswd() {
		return configPasswd;
	}

	public void setConfigPasswd(String configPasswd) {
		this.configPasswd = configPasswd;
	}

	public boolean isAuthSuccess() {
		return authSuccess;
	}

	public void setAuthSuccess(boolean authSuccess) {
		this.authSuccess = authSuccess;
	}

	public String getAuthMsg() {
		return authMsg;
	}

	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}
