package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
@Path("/rds/console")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IRdsConsoleDubboSv {
	/**
	 * 查询用户订购的RDS产品列表
	 * @param request
	 * @return
	 */
	@Path("/selectUserProdInsts")
	@POST
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInsts(SelectWithNoPageRequest<UserProdInstVo> request);
	
	/**
	 * 查询用户订购的RDS的产品列表，根据id
	 * @param request
	 * @return
	 */
	@Path("/selectUserProdInstById")
	@POST
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInstById(SelectWithNoPageRequest<UserProdInstVo> request);
	
	/**
	 * 停用RDS
	 * @param request
	 * @return
	 */
	@Path("/stopRdsContainer")
	@POST
	public ResponseHeader stopRdsContainer(String paraprodBackPara);
	
	/**
	 * 启用RDS
	 * @param request
	 * @return
	 */
	@Path("/startRdsContainer")
	@POST
	public ResponseHeader startRdsContainer(String paraprodBackPara);
	
	/**
	 * 销毁RDS
	 * @param request
	 * @return
	 */
	@Path("/destroyContainer")
	@POST
	public ResponseHeader destroyContainer(String paraprodBackPara);
	 
}
