package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class DesBindRequest implements Serializable{

	 
	private static final long serialVersionUID = 1L;
	
	private String userId;
	
	private String userName;
	
	

	private String serviceId;
	
	private String dbsServiceId;
	
	private String mdsServiceId;
	
	private String mdsServicePassword;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getDbsServiceId() {
		return dbsServiceId;
	}

	public void setDbsServiceId(String dbsServiceId) {
		this.dbsServiceId = dbsServiceId;
	}

	public String getMdsServiceId() {
		return mdsServiceId;
	}

	public void setMdsServiceId(String mdsServiceId) {
		this.mdsServiceId = mdsServiceId;
	}

	public String getMdsServicePassword() {
		return mdsServicePassword;
	}

	public void setMdsServicePassword(String mdsServicePassword) {
		this.mdsServicePassword = mdsServicePassword;
	}
	

}
