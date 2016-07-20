package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class ResponseSubPathList implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7383492886812877618L;

	private String resultCode;
	
	private String resultMsg;
	
	private List<String> listSubPath;

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

	public List<String> getListSubPath() {
		return listSubPath;
	}

	public void setListSubPath(List<String> listSubPath) {
		this.listSubPath = listSubPath;
	}

 
 
	
 
}
