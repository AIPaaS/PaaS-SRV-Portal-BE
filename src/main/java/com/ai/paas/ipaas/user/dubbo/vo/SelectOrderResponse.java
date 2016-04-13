package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class SelectOrderResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ResponseHeader responseHeader ;
	
	private PageResult<OrderDetailVo>  pageResult;	


	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public PageResult<OrderDetailVo> getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult<OrderDetailVo> pageResult) {
		this.pageResult = pageResult;
	}
	
	

}
