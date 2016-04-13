package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.util.CiperUtil;

public class AuthDescriptor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5830430155485771066L;
	private String userName   = null;
	private String password   = null;
	private String authAdress = null; // 用户认证地址，rest地址，我们通过这个地址去请求我们的web，然后调用dubbo服务做认证。
	private String serviceId  = null;

	public AuthDescriptor() {

	}

	public AuthDescriptor(String userName, String password) {
		this.userName = userName;
		this.password = CiperUtil.encrypt(Constants.SECURITY_KEY,password);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthAdress() {
		return authAdress;
	}

	public void setAuthAdress(String authAdress) {
		this.authAdress = authAdress;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}