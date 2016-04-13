package com.ai.paas.ipaas.user.dto;

public class OaOperaters {
    private Short oaId;

    private String buiCode;

    private String ntAccount;

    private String validFlag;

    public Short getOaId() {
        return oaId;
    }

    public void setOaId(Short oaId) {
        this.oaId = oaId;
    }

    public String getBuiCode() {
        return buiCode;
    }

    public void setBuiCode(String buiCode) {
        this.buiCode = buiCode == null ? null : buiCode.trim();
    }

    public String getNtAccount() {
        return ntAccount;
    }

    public void setNtAccount(String ntAccount) {
        this.ntAccount = ntAccount == null ? null : ntAccount.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }
}