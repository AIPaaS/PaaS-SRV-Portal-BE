package com.ai.paas.ipaas.user.dto;


public class ResponseMessage<T> {
	
	
	public ResponseMessage() {
		
	}
	
	public ResponseMessage(String resResult,String resMsg,T t){
		this.resResult = resResult;
		this.resMsg = resMsg;
		this.resData = t;		
	}
	
	private  String resResult;
	
	private String resMsg;
	
	private T resData;

	public String getResResult() {
		return resResult;
	}

	public void setResResult(String resResult) {
		this.resResult = resResult;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public T getResData() {
		return resData;
	}

	public void setResData(T resData) {
		this.resData = resData;
	}

	
	
	

}
