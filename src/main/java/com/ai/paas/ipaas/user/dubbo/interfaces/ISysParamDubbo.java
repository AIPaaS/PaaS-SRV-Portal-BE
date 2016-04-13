package com.ai.paas.ipaas.user.dubbo.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.SysParamVo;
import com.ai.paas.ipaas.user.dubbo.vo.SysParmRequest;

@Path("/system")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface ISysParamDubbo {
	@Path("/getSysParam")
	@POST
	public List<SysParamVo> getSysParams(SysParmRequest request);
	
	@Path("/getSysParamsVo")
	@POST
	public SysParamVo getSysParamsVo(SysParmRequest request) throws PaasException ;

}
