package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.util.List;

public class CheckOrdersRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String checkResult;  //审核结果 1 通过，2不通过
	
	private String  suggestion; //意见
	
	private String userName;
	
	private String userId;
	
	private String userServBackParam ;// Iaas 资源申请回写参数
	
	private List<Long> idlist; //订单明细单号

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public List<Long> getIdlist() {
		return idlist;
	}

	public void setIdlist(List<Long> idlist) {
		this.idlist = idlist;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserServBackParam() {
		return userServBackParam;
	}

	public void setUserServBackParam(String userServBackParam) {
		this.userServBackParam = userServBackParam;
	}

}
