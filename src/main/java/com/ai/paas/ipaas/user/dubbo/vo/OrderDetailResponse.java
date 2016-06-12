package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.util.List;

public class OrderDetailResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ResponseHeader responseHeader;

	/** added in 2016-06-12 **/
	private boolean isNeedSend = false;
	private List<EmailDetail> email = null;
	
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public boolean isNeedSend() {
		return isNeedSend;
	}

	public void setNeedSend(boolean isNeedSend) {
		this.isNeedSend = isNeedSend;
	}

	public List<EmailDetail> getEmail() {
		return email;
	}

	public void setEmail(List<EmailDetail> email) {
		this.email = email;
	}
	
}