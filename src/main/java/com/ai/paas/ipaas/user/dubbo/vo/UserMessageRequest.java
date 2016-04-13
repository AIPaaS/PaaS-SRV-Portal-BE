package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class UserMessageRequest implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	private PageEntity pageEntity;

	public PageEntity getPageEntity() {
		return pageEntity;
	}

	public void setPageEntity(PageEntity pageEntity) {
		this.pageEntity = pageEntity;
	}	
	
	

}
