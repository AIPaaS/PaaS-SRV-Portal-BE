package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class DocumentVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private RecordJson recordJson;
	private String userId;
	private String applyType;
	private String serviceId;
	private String resultCode;
	private String resultMsg;
	
	public RecordJson getRecordJson() {
		return recordJson;
	}
	public void setRecordJson(RecordJson recordJson) {
		this.recordJson = recordJson;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
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

}

class RecordJson implements Serializable {

	private static final long serialVersionUID = 1L;

	private String remark;

	private String filename;
	
	private String uploadDate;
	
	private  String contentType;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
