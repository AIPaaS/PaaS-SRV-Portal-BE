package com.ai.paas.ipaas.user.dto;

public class WfTickets {
    private Long wfTicketsId;

    private String wfId;

    private String wfName;

    private String ticketType;

    private String vaildFlag;

    public Long getWfTicketsId() {
        return wfTicketsId;
    }

    public void setWfTicketsId(Long wfTicketsId) {
        this.wfTicketsId = wfTicketsId;
    }

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId == null ? null : wfId.trim();
    }

    public String getWfName() {
        return wfName;
    }

    public void setWfName(String wfName) {
        this.wfName = wfName == null ? null : wfName.trim();
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType == null ? null : ticketType.trim();
    }

    public String getVaildFlag() {
        return vaildFlag;
    }

    public void setVaildFlag(String vaildFlag) {
        this.vaildFlag = vaildFlag == null ? null : vaildFlag.trim();
    }
}