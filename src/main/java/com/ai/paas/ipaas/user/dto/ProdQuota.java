package com.ai.paas.ipaas.user.dto;

public class ProdQuota {
    private Integer prodId;

    private String userOrgName;

    private Integer cpuQuota;

    private Integer memoryQuota;

    private Integer diskSpaceQuota;

    private Integer remainCpuQuota;

    private Integer remainMemoryQuota;

    private Integer remainDiskSpaceQuota;

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getUserOrgName() {
        return userOrgName;
    }

    public void setUserOrgName(String userOrgName) {
        this.userOrgName = userOrgName == null ? null : userOrgName.trim();
    }

    public Integer getCpuQuota() {
        return cpuQuota;
    }

    public void setCpuQuota(Integer cpuQuota) {
        this.cpuQuota = cpuQuota;
    }

    public Integer getMemoryQuota() {
        return memoryQuota;
    }

    public void setMemoryQuota(Integer memoryQuota) {
        this.memoryQuota = memoryQuota;
    }

    public Integer getDiskSpaceQuota() {
        return diskSpaceQuota;
    }

    public void setDiskSpaceQuota(Integer diskSpaceQuota) {
        this.diskSpaceQuota = diskSpaceQuota;
    }

    public Integer getRemainCpuQuota() {
        return remainCpuQuota;
    }

    public void setRemainCpuQuota(Integer remainCpuQuota) {
        this.remainCpuQuota = remainCpuQuota;
    }

    public Integer getRemainMemoryQuota() {
        return remainMemoryQuota;
    }

    public void setRemainMemoryQuota(Integer remainMemoryQuota) {
        this.remainMemoryQuota = remainMemoryQuota;
    }

    public Integer getRemainDiskSpaceQuota() {
        return remainDiskSpaceQuota;
    }

    public void setRemainDiskSpaceQuota(Integer remainDiskSpaceQuota) {
        this.remainDiskSpaceQuota = remainDiskSpaceQuota;
    }
}