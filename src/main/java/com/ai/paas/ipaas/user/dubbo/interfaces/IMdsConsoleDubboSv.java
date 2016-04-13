package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.user.dubbo.vo.MdsSearchMessageVo;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;

@Path("/mds/console")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IMdsConsoleDubboSv {

	/**
	 * 缓存控制台数据查询
	 * @param request
	 * @return
	 */
	@Path("/selectUserProdInsts")
	@POST
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInsts(SelectWithNoPageRequest<UserProdInstVo> request);

	
	@Path("/selectMdsById")
	@POST
	public SelectWithNoPageResponse<UserProdInstVo> selectMdsById(SelectWithNoPageRequest<UserProdInstVo> request);
	
	
	@Path("/cancleUserProdInst")
	@POST
	public ResponseHeader cancleUserProdInst(UserProdInstVo vo);
	
	
	@Path("/searchMessage")
	@POST
	public ResponseHeader searchMessage(MdsSearchMessageVo vo);
	
	@Path("/resendMessage")
	@POST
	public String resendMessage(String params);
	
	
	@Path("/skipMessage")
	@POST
	public String skipMessage(String params);
	
}
