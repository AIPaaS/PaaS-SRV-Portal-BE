package com.ai.paas.ipaas.user.dubbo.vo;

import java.sql.Timestamp;

import com.ai.paas.ipaas.user.dto.OrderDetail;

 

public class PlanConfirmVo extends OrderDetail {
	private String prodName;
	//订单属性
    private String costCenterCode;
    private String costCenterName;
    private Long userMaxNumbers;
    private Long concurrentNumbers;
    private String applyType;
    private String useType;
    private String applyDesc;
    //订单集成方案
    private String validFlag;

    private Timestamp schemeMakeTime;

    private String schemeMaker;

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
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

	public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public Timestamp getSchemeMakeTime() {
		return schemeMakeTime;
	}

	public void setSchemeMakeTime(Timestamp schemeMakeTime) {
		this.schemeMakeTime = schemeMakeTime;
	}

	public String getSchemeMaker() {
		return schemeMaker;
	}

	public void setSchemeMaker(String schemeMaker) {
		this.schemeMaker = schemeMaker;
	}
	
   
}
