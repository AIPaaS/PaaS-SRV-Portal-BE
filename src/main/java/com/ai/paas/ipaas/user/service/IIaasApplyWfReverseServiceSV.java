package com.ai.paas.ipaas.user.service;

import com.ai.paas.ipaas.user.dubbo.vo.ReverseVariablesVo;

public interface IIaasApplyWfReverseServiceSV {

    /**
     * Iaas资源申请流程启动通知接口
     * 
     * @param request
     * @return
     */
    public String processStartNotify(ReverseVariablesVo reverseVo) throws Exception;

    /**
     * Iaas资源申请派单接口
     * 
     * @param request
     * @return
     */
    public String taskDispatch(ReverseVariablesVo reverseVo) throws Exception;

    /**
     * Iaas资源申请流程结束通知接口
     * 
     * @param request
     * @return
     */
    public String troubleCompleteDispatch(ReverseVariablesVo reverseVo) throws Exception;
}