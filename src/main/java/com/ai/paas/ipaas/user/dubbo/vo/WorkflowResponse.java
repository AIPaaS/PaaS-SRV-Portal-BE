package com.ai.paas.ipaas.user.dubbo.vo;

public class WorkflowResponse {
    // 服务响应编码
    private String responCode;

    // 服务响应消息。响应码不为200时，必填。
    private String responMessage;

    // 服务端校验通过返回的令牌。响应码为200,必填
    private String ticket;

    public String getResponCode() {
        return responCode;
    }

    public void setResponCode(String responCode) {
        this.responCode = responCode;
    }

    public String getResponMessage() {
        return responMessage;
    }

    public void setResponMessage(String responMessage) {
        this.responMessage = responMessage;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}