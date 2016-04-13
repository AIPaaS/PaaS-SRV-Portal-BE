package com.ai.paas.ipaas.user.vo;

/**
 * 服务返回参数实体类
 * @author archer
 *
 */
public class ServResponse {
	
	private String responseCode;  //服务运行结果编码
	
	private String responseMsg;   //服务运行结果提示
	
	private Object object;        //服务运行结果业务数据

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	

}
