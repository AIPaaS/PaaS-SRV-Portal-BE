package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/workflow/iaasapply")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IIaasApplyWfReverseSV {

    /**
     * Iaas资源申请流程启动通知接口
     * 
     * @param request
     * @return
     */
    @Path("/processInstance/notify")
    @POST
    public String processStartNotify(String params) throws Exception;

    /**
     * Iaas资源申请派单接口
     * 
     * @param request
     * @return
     */
    @Path("/process/deal")
    @POST
    public String taskDispatch(String params) throws Exception;

    /**
     * Iaas资源申请流程结束通知接口
     * 
     * @param request
     * @return
     */
    @Path("/processInstance/status")
    @POST
    public String troubleCompleteDispatch(String params) throws Exception;
}
