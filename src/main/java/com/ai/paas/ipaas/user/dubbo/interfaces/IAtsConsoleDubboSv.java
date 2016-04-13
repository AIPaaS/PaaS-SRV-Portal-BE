package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
@Path("/ats/console")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IAtsConsoleDubboSv {
	/**
	 * 查询用户订购的产品列表
	 * @param request
	 * @return
	 */
	@Path("/selectUserProdInsts")
	@POST
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInsts(SelectWithNoPageRequest<UserProdInstVo> request);

	/**
	 *根据id查询实例
	 * @param request
	 * @return
	 */
	@Path("/selectDssById")
	@POST
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInstById(SelectWithNoPageRequest<UserProdInstVo> request);
	
	
	@Path("/searchUsages")
	@POST
	public String searchUsages(String params);
	
	@Path("/searchOneMessage")
	@POST
	public String searchOneMessage(String params);
	
	/**
	 * 跳过消息
	 * @param params
	 * @return
	 */
	@Path("/skipMessage")
	@POST
	public String skipMessage(String params);
	
	/**
	 * 重发消息
	 * @param params
	 * @return
	 */
	@Path("/resendMessage")
	@POST
	public String resendMessage(String params);

}
