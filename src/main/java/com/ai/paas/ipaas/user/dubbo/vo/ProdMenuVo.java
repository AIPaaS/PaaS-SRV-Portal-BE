package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class ProdMenuVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String prodId; //产品id
	
	private String prodName; //产品名称
	
	private String prodType; //产品类型：1=pass;2=iaas
	
	private String consoleUrl; //控制台url
	
	private String userId;

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getConsoleUrl() {
		return consoleUrl;
	}

	public void setConsoleUrl(String consoleUrl) {
		this.consoleUrl = consoleUrl;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
}