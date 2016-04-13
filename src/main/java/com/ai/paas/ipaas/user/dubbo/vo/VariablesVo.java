package com.ai.paas.ipaas.user.dubbo.vo;

/**
 * 
 * Description: 变量<br>
 * Date: 2015年7月23日 <br>
 * Copyright (c) 2015 AI <br>
 * 
 * @author caiyt
 */
public class VariablesVo {
    // 用户编码
    private String userId;

    // 工单处理所在节点
    private String woResult;

    // 申请单号
    private String applyId;

    // 工单处理描述
    private String woDesc;

    // 工单号
    private String orderWoId;

    // 申请人NT账号
    private String ntAccount;
    
    private String costCenterCode;//成本中心编码
    
    

    public String getCostCenterCode() {
		return costCenterCode;
	}

	public void setCostCenterCode(String costCenterCode) {
		this.costCenterCode = costCenterCode;
	}

	public String getOrderWoId() {
        return orderWoId;
    }

    public void setOrderWoId(String orderWoId) {
        this.orderWoId = orderWoId;
    }

    public String getNtAccount() {
        return ntAccount;
    }

    public void setNtAccount(String ntAccount) {
        this.ntAccount = ntAccount;
    }

    public String getWoDesc() {
        return woDesc;
    }

    public void setWoDesc(String woDesc) {
        this.woDesc = woDesc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWoResult() {
        return woResult;
    }

    public void setWoResult(String woResult) {
        this.woResult = woResult;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }
}