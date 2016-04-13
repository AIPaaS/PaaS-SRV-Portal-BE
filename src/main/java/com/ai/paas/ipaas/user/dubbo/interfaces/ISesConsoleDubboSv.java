package com.ai.paas.ipaas.user.dubbo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
@Path("/ses/console")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface ISesConsoleDubboSv {
		/**
		 * 启动服务
		 * @param vo
		 * @return
		 */
		@Path("/startService")
		@POST
		public ResponseHeader startService(UserProdInstVo vo);
		/**
		 * 停止服务
		 * @param vo
		 * @return
		 */
		@Path("/stopService")
		@POST
		public ResponseHeader stopService(UserProdInstVo vo);
		/**
		 * 注销服务
		 * @param vo
		 * @return
		 */
		@Path("/cancleService")
		@POST
		public ResponseHeader cancleService(UserProdInstVo vo);
		
		
}
