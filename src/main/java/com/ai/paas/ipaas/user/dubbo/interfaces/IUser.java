package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.RegisterResult;
import com.ai.paas.ipaas.user.dubbo.vo.UserVo;

@Path("/user")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IUser {
	@Path("/getUserInfo")
	@POST
	public UserVo getUserInfo(String userId) throws PaasException;//根据用户名获取用户Id等信息
	@Path("/getUserInfoByEmail")
	@POST
	public UserVo getUserInfoByEmail(String email) throws PaasException;//根据用户名获取用户Id等信息
	@Path("/registerUser")
	@POST
	public RegisterResult registerUser(UserVo user) throws PaasException;//注册
	@Path("/uniqueEmail")
	@POST
	public boolean uniqueEmail(String email) throws PaasException;// email是否存在
	@Path("/uniquePhone")
	@POST
	public boolean uniquePhone(String phone) throws PaasException;// phone是否存在
	@Path("/verfiy_email")
	@POST
	public int verfiy_email(String email) throws PaasException;// 激活用户
	
	@Path("/updatebyKey")
	@POST
	public int updatebyKey(UserVo uv) throws PaasException;// 根据userId账户置换
	
	@Path("/updateUserPs")
	@POST
	public String updateUserPs(UserVo uv) throws PaasException;// 激活用户
	/**
	 * 根据用户名获取用户Id等信息
	 * @param json串
	 * @return 用户信息json串 
	 */
	@Path("/getUserInfoByUserName")
	@POST
	public String getUserInfoByUserName(String param);
	
	/**
	 * 根据用户Id，资源类型获取用户订购的资源等信息
	 * @param json串
	 * @return 用户信息json串 
	 */
	@Path("/getUserProdInstsWithType")
	@POST
	public String getUserProdInstsWithType(String param);
}
