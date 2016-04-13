package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class UserMessageResponse implements Serializable {
private static final long serialVersionUID = 1L;
	
	private ResponseHeader responseHeader ;
	
	private PageResult<UserMessageVo>  pageResult;	


	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public PageResult<UserMessageVo> getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult<UserMessageVo> pageResult) {
		this.pageResult = pageResult;
	}
	
}


