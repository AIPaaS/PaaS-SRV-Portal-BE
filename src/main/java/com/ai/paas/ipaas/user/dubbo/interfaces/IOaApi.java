package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 与OA数据交互接口
 * @author archer
 *
 */
@Path("/user/iOaApi")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IOaApi {
	/**
	 * 获取OA资源管理员配置表数据
	 * @param param
	 * @return
	 */
	@Path("/getOaOperators")
	@POST
	public String getOaOperators(String param);
	
	/**
	 * OA审核结果通知
	 * @param param
	 * @return
	 */
	@Path("/oaAuditResultNotify")
	@POST
	public String oaAuditResultNotify(String param);
	
	
	/**
	 * OA资源管理员审核节点确认服务
	 * @param param
	 * @return
	 */
	@Path("/oaAuditPremise")
	@POST
	public String oaAuditPremise(String param);
	
	/**
	 * 从erp查询项目信息服务
	 * @param param
	 * @return
	 */
	@Path("/getErpProjects")
	@POST
	public String getErpProjects(String param);
	
	
	
}
