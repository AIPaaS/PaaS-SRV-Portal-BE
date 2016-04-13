package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SelectWithNoPageResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private ResponseHeader responseHeader;
	
	private List<T> resultList = new ArrayList<T>(); // 结果集
		
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	
}
