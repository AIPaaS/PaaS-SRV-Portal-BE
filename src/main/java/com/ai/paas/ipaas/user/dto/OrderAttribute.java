package com.ai.paas.ipaas.user.dto;

public class OrderAttribute {
    private Long orderDetailId;

    private String costCenterCode;

    private String costCenterName;

    private Long userMaxNumbers;

    private Long concurrentNumbers;

    private String applyType;

    private String useType;

    private String applyDesc;

    private String isProject;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode == null ? null : costCenterCode.trim();
    }

    public String getCostCenterName() {
        return costCenterName;
    }

    public void setCostCenterName(String costCenterName) {
        this.costCenterName = costCenterName == null ? null : costCenterName.trim();
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
        this.applyType = applyType == null ? null : applyType.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    public String getApplyDesc() {
        return applyDesc;
    }

    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc == null ? null : applyDesc.trim();
    }

    public String getIsProject() {
        return isProject;
    }

    public void setIsProject(String isProject) {
        this.isProject = isProject == null ? null : isProject.trim();
    }
}