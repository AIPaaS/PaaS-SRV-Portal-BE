package com.ai.paas.ipaas.user.dto;

/**
 * 请求restfull服务请求
 * @author mapl
 */
public class MdsGetSubscribeRestfullRes {
	
	private String resultCode;
	private String resultMsg;
	private String isExis;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getIsExis() {
		return isExis;
	}
	public void setIsExis(String isExis) {
		this.isExis = isExis;
	}
	
}
