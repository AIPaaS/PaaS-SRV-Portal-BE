package com.ai.paas.ipaas.user.vo;

import com.ai.paas.ipaas.user.dto.OrderDetail;

/**
 * 订单Vo
 * @author renfeng
 *
 */
public class OrdersVo extends OrderDetail{
	
    private String costCenterCode; //成本中心编码
    private String costCenterName; //成本中心名称
    private Long userMaxNumbers;   //用户量
    private Long concurrentNumbers;//并发访问量
    private String applyType;      //资源申请方式
    private String useType;        //用途说明
    private String applyDesc;      //业务描述
    
    private Long orderWoId;        //工单号
    private String receiptUrl;     //处理页面url
    
    private String prodEnSimp;     //产品名称
    
    private String isProject;      //是否项目
    
    


	public String getIsProject() {
		return isProject;
	}

	public void setIsProject(String isProject) {
		this.isProject = isProject;
	}

	public String getProdEnSimp() {
		return prodEnSimp;
	}

	public void setProdEnSimp(String prodEnSimp) {
		this.prodEnSimp = prodEnSimp;
	}

	public String getCostCenterCode() {
		return costCenterCode;
	}

	public void setCostCenterCode(String costCenterCode) {
		this.costCenterCode = costCenterCode;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public Long getUserMaxNumbers() {
		return userMaxNumbers;
	}

	public void setUserMaxNumbers(Long userMaxNumbers) {
		this.userMaxNumbers = userMaxNumbers;
	}

	public Long getConcurrentNumbers() {
		return concurrentNumbers;
	}

	public void setConcurrentNumbers(Long concurrentNumbers) {
		this.concurrentNumbers = concurrentNumbers;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getApplyDesc() {
		return applyDesc;
	}

	public void setApplyDesc(String applyDesc) {
		this.applyDesc = applyDesc;
	}

	public Long getOrderWoId() {
		return orderWoId;
	}

	public void setOrderWoId(Long orderWoId) {
		this.orderWoId = orderWoId;
	}

	public String getReceiptUrl() {
		return receiptUrl;
	}

	public void setReceiptUrl(String receiptUrl) {
		this.receiptUrl = receiptUrl;
	}
    
	    
	
}
