package com.ai.paas.ipaas.user.utils;

import javax.mail.Authenticator;

/**
 * 邮件服务器登录验证
 * @author jonrey
 *
 */
public class MailAuthenticator extends Authenticator{

	//登录邮箱有户名、密码
	private String userName;
	private String passWord;
	public MailAuthenticator(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
