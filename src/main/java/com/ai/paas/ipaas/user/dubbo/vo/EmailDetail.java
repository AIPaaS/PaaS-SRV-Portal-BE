package com.ai.paas.ipaas.user.dubbo.vo;

import java.sql.Timestamp;

public class EmailDetail {
    private Long emailId;

    private String fromAddress;

    private String fromPwd;

    private String toAddress;

    private String emailTitle;

    private String emailContent;

    private String emailCc;

    private String isSucc;

    private String failReason;

    private Timestamp sendTime;

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress == null ? null : fromAddress.trim();
    }

    public String getFromPwd() {
        return fromPwd;
    }

    public void setFromPwd(String fromPwd) {
        this.fromPwd = fromPwd == null ? null : fromPwd.trim();
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress == null ? null : toAddress.trim();
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle == null ? null : emailTitle.trim();
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent == null ? null : emailContent.trim();
    }

    public String getEmailCc() {
        return emailCc;
    }

    public void setEmailCc(String emailCc) {
        this.emailCc = emailCc == null ? null : emailCc.trim();
    }

    public String getIsSucc() {
        return isSucc;
    }

    public void setIsSucc(String isSucc) {
        this.isSucc = isSucc == null ? null : isSucc.trim();
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }
}