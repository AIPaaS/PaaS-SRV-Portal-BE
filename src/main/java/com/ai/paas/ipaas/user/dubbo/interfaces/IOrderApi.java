package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user/iOrderApi")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IOrderApi {
	
	/**
	 * 保存IAAS虚拟机申请订单
	 * @param param
	 * @return
	 * 
	 * 
	 */
	@Path("/saveIaasOrder")
	@POST
	public String saveIaasOrder(String param);
	
	/**
	 * 保存IAAS虚拟机集成方案
	 * @param param
	 * @return
	 */
	@Path("/saveIaasIntegratedScheme")
	@POST
	public String saveIaasIntegratedScheme(String param);
	
	/**
	 * 保存IAAS虚拟机开通信息
	 * @param param
	 * @return
	 */
	@Path("/saveIaasOpenParam")
	@POST
	public String saveIaasOpenParam(String param);
	
	/**
	 * haoyh.10.16
	 * 保存IAAS虚拟机申请订单中英文参数修改
	 * @param param
	 * @return
	 */
	@Path("/updateIaasOrder")
	@POST
	public String updateIaasOrder(String param);
	
	
}
