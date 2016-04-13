package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class CheckOrdersResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ResponseHeader responseHeader;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

}
