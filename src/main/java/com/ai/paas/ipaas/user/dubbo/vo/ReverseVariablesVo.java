package com.ai.paas.ipaas.user.dubbo.vo;

import java.util.Date;
import java.util.List;

import com.ai.paas.ipaas.util.JSonUtil;

/**
 * 
 * Description: 反向接口Bean类<br>
 * 
 * @author caiyt
 */
public class ReverseVariablesVo {
    // 启动流程模板对象的唯一标示
    private String businessKey;

    // 任务编码
    private String taskId;

    // 任务类型（自动，人工）
    private String taskType;

    // 执行流程实例编码
    private String processInstanceId;

    // 父级任务编码
    private String parentTaskId;

    // 任务所有人
    private String owner;

    // 任务处理人
    private String assignee;

    // 任务处理角色
    private String delegation;

    // 任务展示和处理地址
    private String URL;

    // 创建时间，格式：yyyy-mm-dd hh:MM:ss
    private Date createTime;

    // 变量数组
    private List<VariablesVo> variables;

    // 流程运行状态。完成-complete
    private String status;

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<VariablesVo> getVariables() {
        return variables;
    }

    public void setVariables(List<VariablesVo> variables) {
        this.variables = variables;
    }
    
    public static void main(String[] args) {
        String s = "{\"taskId\":\"taskid\",\"variables\":[{\"userId\":\"value1\"},{\"troubleNo\":\"value2\"}]}";
        System.out.println(s);
        ReverseVariablesVo vo = JSonUtil.fromJSon(s, ReverseVariablesVo.class);
        System.out.println(vo);
    }
}