package com.ai.paas.ipaas.user.dubbo.vo;

import java.util.List;

public class WorkflowRequest {
    // 流程模板编码
    private String processDefinitionId;

    // 流程实例编码
    private String processInstanceId;

    // 任务编码
    private String taskId;

    // 接受转派任务的人,接受任务人的唯一标示
    private String taskAssignee;

    // 启动流程对象唯一标示
    private String businessKey;

    // 访问令牌，认证服务返回
    private String ticket;

    // 任务变量
    private List<VariablesVo> variables;

    // 登陆名
    private String userName;

    // 服务实例编码
    private String serviceId;

    // 服务密码
    private String password;

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public List<VariablesVo> getVariables() {
        return variables;
    }

    public void setVariables(List<VariablesVo> variables) {
        this.variables = variables;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
