package com.ai.paas.ipaas.user.vo;
/**
 * 订单formBean
 * @author renfeng
 *
 */
@SuppressWarnings("serial")
public class OrdersForm extends PageEntity{
	
	private String userId;			//用户编码
	private String applicant; 		//申请人
	private String applicantDept;	//申请人部门
	private String applicantTel;	//联系人电话
	private String orderStatus;		//订单状态
	private String applyDesc;		//订单描述
	private String appDateStart;	//申请时间起
	private String appDateEnd;		//申请时间止
	private String sortFlag;		//排序标志 1-申请时间降序 2-升序
	private String orderDetailId;     //订单编码
	private String belongCloud;     //归属平台
	
	private String operateId; 		//操作人ID
	
	
	public String getBelongCloud() {
		return belongCloud;
	}
	public void setBelongCloud(String belongCloud) {
		this.belongCloud = belongCloud;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getApplicantDept() {
		return applicantDept;
	}
	public void setApplicantDept(String applicantDept) {
		this.applicantDept = applicantDept;
	}
	public String getApplicantTel() {
		return applicantTel;
	}
	public void setApplicantTel(String applicantTel) {
		this.applicantTel = applicantTel;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getApplyDesc() {
		return applyDesc;
	}
	public void setApplyDesc(String applyDesc) {
		this.applyDesc = applyDesc;
	}
	public String getAppDateStart() {
		return appDateStart;
	}
	public void setAppDateStart(String appDateStart) {
		this.appDateStart = appDateStart;
	}
	public String getAppDateEnd() {
		return appDateEnd;
	}
	public void setAppDateEnd(String appDateEnd) {
		this.appDateEnd = appDateEnd;
	}
	public String getSortFlag() {
		return sortFlag;
	}
	public void setSortFlag(String sortFlag) {
		this.sortFlag = sortFlag;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getOperateId() {
		return operateId;
	}
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}
	
	
	
	
	
}
