package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.user.dubbo.vo.DocumentVo;
import com.ai.paas.ipaas.user.dubbo.vo.ProdMenuVo;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
@Path("/dss/console")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IDssConsoleDubboSv {
	/**
	 * 查询用户订购的DSS产品列表
	 * @param request
	 * @return
	 */
	@Path("/selectUserProdInsts")
	@POST
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInsts(SelectWithNoPageRequest<UserProdInstVo> request);
	
	/**
	 * 注销用户订购的DSS产品
	 * @param vo
	 * @return
	 */
	@Path("/cancleUserProdInst")
	@POST
	public ResponseHeader cancleUserProdInst(UserProdInstVo vo);
	
	/**
	 * 修改服务密码
	 * @param vo
	 * @return
	 */
	@Path("/mdyServPwd")
	@POST
	public ResponseHeader mdyServPwd(UserProdInstVo vo);
	
	/**
	 * 全部清理（格式化）
	 * @param vo
	 * @return
	 */
	@Path("/cleanAll")
	@POST
	public ResponseHeader fullClear(UserProdInstVo vo);
	
	/**
	 * 根据key查询DSS服务下的指定文档
	 * @param request
	 * @return
	 */
	@Path("/selectDocumentByKey")
	@POST
	public SelectWithNoPageResponse<DocumentVo> selectDocumentByKey(SelectWithNoPageRequest<UserProdInstVo> request);
	
	/**
	 * 根据key查询DSS服务下的指定文档
	 * @param request
	 * @return
	 */
	@Path("/clearDocumentByKey")
	@POST
	public ResponseHeader clearDocumentByKey(UserProdInstVo vo);
	
	/**
	 *根据id查询DSS实例
	 * @param request
	 * @return
	 */
	@Path("/selectDssById")
	@POST
	public SelectWithNoPageResponse<UserProdInstVo> selectDssById(SelectWithNoPageRequest<UserProdInstVo> request);
	
	/**
	 * 查询用户订购的DSS产品列表
	 * @param request
	 * @return
	 */
	@Path("/queryLeftMenuList")
	@POST
	public SelectWithNoPageResponse<ProdMenuVo> queryLeftMenuList(SelectWithNoPageRequest<ProdMenuVo> request);
	
	/**
	 * DSS扩容
	 * @param params
	 * @return
	 */
	@Path("/modifyConfiguration")
	@POST
	public String modifyConfiguration(String params);
}
