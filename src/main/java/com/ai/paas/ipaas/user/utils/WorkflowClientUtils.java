package com.ai.paas.ipaas.user.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.sf.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ai.paas.ipaas.cache.CacheUtils;
import com.ai.paas.ipaas.cache.RedisClient;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dubbo.vo.VariablesVo;
import com.ai.paas.ipaas.user.dubbo.vo.WorkflowRequest;
import com.ai.paas.ipaas.user.dubbo.vo.WorkflowResponse;
import com.ai.paas.ipaas.util.JSonUtil;

/**
 * 
 * Description:访问工作流公共方法 <br>
 * Date: 2015年7月29日 <br>
 * Copyright (c) 2015 AILK <br>
 * 
 * @author caiyt
 */
public class WorkflowClientUtils {
    private static final Logger logger = LogManager.getLogger(WorkflowClientUtils.class);

    /**
     * 
     * @description 流程启动
     * @throws Exception
     * @author caiyt
     */
    public static WorkflowResponse processStart(WorkflowRequest req) throws Exception {
        if (req == null) {
            throw new Exception("请求对象不能为空！");
        }
        if (req.getProcessDefinitionId() == null) {
            throw new Exception("流程模板编码不能为空！");
        }
        if (req.getBusinessKey() == null) {
            throw new Exception("业务唯一标识不能为空");
        }
        String params = "";
        params += "processDefinitionId=" + req.getProcessDefinitionId();
        params += "&businessKey=" + req.getBusinessKey();
        JSONObject obj = new JSONObject();
        obj.put("variables", JSonUtil.toJSon(req.getVariables()));
        return reqWorkflow(params, obj.toString(), Constants.WorkflowReqUrlSuffix.PROCESS_START);
    }

    /**
     * 
     * @description 流程终止
     * @throws Exception
     * @author caiyt
     */
    public static WorkflowResponse processOver(WorkflowRequest req) throws Exception {
        String params = "";
        params += "processInstanceId=" + req.getProcessInstanceId();
        JSONObject obj = new JSONObject();
        obj.put("variables", JSonUtil.toJSon(req.getVariables()));
        return reqWorkflow(params, obj.toString(), Constants.WorkflowReqUrlSuffix.PROCESS_OVER);
    }

    /**
     * 
     * @description 任务领用
     * @throws Exception
     * @author caiyt
     */
    public static WorkflowResponse taskClaim(WorkflowRequest req) throws Exception {
        String params = "";
        params += "processInstanceId=" + req.getProcessInstanceId();
        params += "&taskId=" + req.getTaskId();
        params += "&taskAssignee=" + req.getTaskAssignee();
        JSONObject obj = new JSONObject();
        obj.put("variables", JSonUtil.toJSon(req.getVariables()));
        return reqWorkflow(params, obj.toString(), Constants.WorkflowReqUrlSuffix.TASK_CLAIM);
    }

    /**
     * 
     * @description 任务完成
     * @throws Exception
     * @author caiyt
     */
    public static WorkflowResponse taskComplete(WorkflowRequest req) throws Exception {
    	logger.info("oa审批通知任务完成参数=============="+JsonUtils.toJsonStr(req));
    	logger.info("========任务完成开始！==========");
        if (req == null) {
            throw new Exception("请求对象不能为空！");
        }
        logger.info("========req.getProcessInstanceId()======="+req.getProcessInstanceId());
        if (req.getProcessInstanceId() == null) {
            throw new Exception("流程实例编码不能为空！");
        }
        logger.info("========req.getTaskId()======="+req.getTaskId());
        if (req.getTaskId() == null) {
            throw new Exception("任务编码不能为空！");
        }
        logger.info("========req.getVariables()======="+req.getVariables());
        boolean isWoResultNull = true;
        for (VariablesVo vo : req.getVariables()) {
            if (vo.getWoResult() != null) {
                isWoResultNull = false;
                break;
            }
        }
        if (isWoResultNull) {
            throw new Exception("工单处理结果不能为空！");
        }
        String params = "";
        params += "processInstanceId=" + req.getProcessInstanceId();
        params += "&taskId=" + req.getTaskId();
        logger.info("===========任务完成params========"+params);
        JSONObject obj = new JSONObject();
        obj.put("variables", JSonUtil.toJSon(req.getVariables()));
        logger.info("===========任务完成obj.toString========"+obj.toString());
        
        return reqWorkflow(params, obj.toString(), Constants.WorkflowReqUrlSuffix.TASK_COMPLETE);
    }

    /**
     * 
     * @description 任务转发
     * @throws Exception
     * @author caiyt
     */
    public static WorkflowResponse taskDelegate(WorkflowRequest req) throws Exception {
        String params = "";
        params += "processInstanceId=" + req.getProcessInstanceId();
        params += "&taskId=" + req.getTaskId();
        params += "&taskAssignee=" + req.getTaskAssignee();
        JSONObject obj = new JSONObject();
        obj.put("variables", JSonUtil.toJSon(req.getVariables()));
        return reqWorkflow(params, obj.toString(), Constants.WorkflowReqUrlSuffix.TASK_DELEGATE);
    }

    /**
     * 
     * @description 统一访问工作流接口方法
     * @return
     * @author caiyt
     */
    public static WorkflowResponse reqWorkflow(String params, String variables, String url)
            throws Exception {
    	logger.info("===========统一访问工作流接口方法开始==========");
        url = CacheUtils.getValueByKey(Constants.CacheKeys.WORKFLOW_URL_PREFIX) + url + "?"
                + params;
        logger.info("任务完成url：====================》"+url);
        return reqWorkflowLimit(url, variables, 1, 0);
    }

    private static WorkflowResponse reqWorkflowLimit(String url, String variables, int tryTimes,
            int index) throws Exception {
    	WorkflowResponse res =null;
        // 允许失败次数范围内向工作流发送请求
        if (tryTimes > index) {
            String ticket = (String) RedisClient.get4Serial(Constants.CacheKeys.WORKFLOW_TICKET);
            if (ticket == null || ticket.trim().equals("")) {
                /* 1.1 如果缓存中不存在访问令牌或者所存令牌为空内容，重新向工作流申请令牌 */
                ticket = getTicketsFromWorkflow();
                /* 1.2 将获取到的令牌写入缓存中 */
                RedisClient.set4Serial(Constants.CacheKeys.WORKFLOW_TICKET, ticket);
            }
            /* 2.将令牌放入业务请求内容中 */
            url += "&ticket=" + ticket;
            logger.info("任务完成url+ticket：====================》"+url);
            
            try {
                /* 3.向工作流发送业务请求 */
                String resFromWorkflow = HttpClientUtil.sendPostRequest(url, variables);
                logger.info("任务完成调用结果：====================》"+resFromWorkflow);
                /* 4.将工作流返回内容转化为本地对象进行结果分析 */
                res = JSonUtil.fromJSon(resFromWorkflow, WorkflowResponse.class);
                if (res != null && res.getResponCode() != null) {
                    if (res.getResponCode().equals(Constants.WorkflowResponseCode.SUCCESS)) {
                        /* 4.1 如果响应结果为成功，则直接返回 */
                        return res;
                    } else if (res.getResponCode().equals(
                            Constants.WorkflowResponseCode.AUTHENTICATE_FAILURE) || 
                            res.getResponCode().equals(
                                    Constants.WorkflowResponseCode.REQ_PARAMS_WRONG)) {
                        /* 4.2 如果密钥校验失败，重新申请密钥 */
                        ticket = getTicketsFromWorkflow();
                        /* 4.2.1 将获取到的令牌写入缓存中 */
                        RedisClient.set4Serial(Constants.CacheKeys.WORKFLOW_TICKET, ticket);
                        /* 4.2.2 重新向工作流发送请求 */
                        return reqWorkflowLimit(url, variables, tryTimes, ++index);
                    } else {
                        /* 4.3 如果响应为空，重新向工作流发送请求 */
                        logger.error("向工作流发送请求失败：" + getWorkflowErrorInfo(res.getResponCode()));
                        return reqWorkflowLimit(url, variables, tryTimes, ++index);
                    }
                } else {
                    logger.error("向工作流发送请求失败，工作流返回内容为空！");
                    throw new Exception("向工作流发送请求失败，工作流返回内容为空！");
                }
            } catch (Exception e) {
                /* 5.如果响应异常，重新向工作流发送请求 */
                logger.error("向工作流发送请求异常：" + e.getMessage());
                return reqWorkflowLimit(url, variables, tryTimes, ++index);
            }
        } else {
            // 超过失败次数，抛出异常
            logger.error("尝试向工作流发送" + tryTimes + "次请求仍响应失败！");
            return res;
//            throw new Exception("尝试向工作流发送" + tryTimes + "次请求仍响应失败！");
        }
    }

    /**
     * 
     * @description 向工作流发送请求获取访问令牌
     * @throws Exception
     * @author caiyt
     */
    private static String getTicketsFromWorkflow() throws Exception {
        Properties properties = new Properties();
        InputStream in = WorkflowClientUtils.class
                .getResourceAsStream("/context/workflow_params.properties");
        properties.load(in);
        String url = CacheUtils.getValueByKey(Constants.CacheKeys.WORKFLOW_URL_PREFIX)
                + "/service/authorization/login?";
        url += "userName=" + properties.getProperty("userName");
        // url += "&password="
        // + CiperUtil.encrypt("7331c9b6b1a1d521363f7bca8acb095f",
        // properties.getProperty("password"));
        url += "&password=" + properties.getProperty("password");
        url += "&serviceId=" + properties.getProperty("serviceId");
        String jsonRes = HttpClientUtil.sendPostRequest(url, "");
        WorkflowResponse res = JSonUtil.fromJSon(jsonRes, WorkflowResponse.class);
        if (res != null && res.getResponCode() != null
                && res.getResponCode().equals(Constants.WorkflowResponseCode.SUCCESS)) {
            return res.getTicket();
        } else {
            String errorInfo = getWorkflowErrorInfo(res.getResponCode());
            throw new Exception("获取工作流访问令牌失败：" + errorInfo);
        }
    }

    /**
     * 
     * @description 根据响应编码获取对应消息内容
     * @return
     * @author caiyt
     */
    public static String getWorkflowErrorInfo(String resCode) {
        String errorInfo = "";
        if (resCode != null) {
            switch (resCode) {
            case Constants.WorkflowResponseCode.REQ_PARAMS_WRONG:
                errorInfo = "请求参数错误。参数包含未经转换的特殊字符，或者缺少必传参数";
                break;
            case Constants.WorkflowResponseCode.AUTHENTICATE_FAILURE:
                errorInfo = "认证失败。请求没有通过权限认证";
                break;
            case Constants.WorkflowResponseCode.SERVICE_NOT_FOUND:
                errorInfo = "找不到服务。表示根据URL地址，无法找到服务";
                break;
            case Constants.WorkflowResponseCode.CAN_NOT_OPERATE:
                errorInfo = "表示因为冲突导致无法执行操作";
                break;
            case Constants.WorkflowResponseCode.SERVICE_UNKNOWN_EXCEPTION:
                errorInfo = "服务器发生未知异常。执行操作时出现了预期外的异常";
                break;
            }
        }
        return errorInfo;
    }

    private static WorkflowResponse taskComplete() throws Exception {
        WorkflowRequest req = new WorkflowRequest();
        req.setProcessInstanceId("90100");
        req.setTaskId("90110");
        List<VariablesVo> variables = new ArrayList<VariablesVo>();
        VariablesVo vo = new VariablesVo();
        vo.setUserId("0C7D67D44EB84214A47EB3209CB7AE5E");
        variables.add(vo);
        req.setVariables(variables);
        WorkflowResponse res = taskComplete(req);
        return res;
    }

    private static WorkflowResponse processStart() throws Exception {
        WorkflowRequest req = new WorkflowRequest();
        // req.setProcessDefinitionId("twoTasksProcess:1:228950");
        VariablesVo vo = new VariablesVo();
        req.setProcessDefinitionId("process:7:367504");
        req.setBusinessKey("troubleNo20150813163022");
        List<VariablesVo> variables = new ArrayList<VariablesVo>();
        vo.setUserId("0985C790689443E6A6D54142968086B6");
        vo.setApplyId("troubleNo20150813163022");
        variables.add(vo);
        req.setVariables(variables);
        WorkflowResponse res = processStart(req);
        return res;
    }
}