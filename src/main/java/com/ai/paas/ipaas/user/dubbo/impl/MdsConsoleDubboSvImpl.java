package com.ai.paas.ipaas.user.dubbo.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.MdsGetSubscribeRestfullRes;
import com.ai.paas.ipaas.user.dto.MdsSearchRestfullRes;
import com.ai.paas.ipaas.user.dto.MdsSubscribeRestfullRes;
import com.ai.paas.ipaas.user.dubbo.interfaces.IMdsConsoleDubboSv;
import com.ai.paas.ipaas.user.dubbo.vo.MdsSearchMessageVo;
import com.ai.paas.ipaas.user.dubbo.vo.MdsUserSubscribeVo;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseSubPathList;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IMdsConsoleSv;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class MdsConsoleDubboSvImpl implements IMdsConsoleDubboSv{

	private final Log logger = LogFactory.getLog(MdsConsoleDubboSvImpl.class);
	
	@Autowired
	private IMdsConsoleSv iMdsConsoleSv;
	
	private void validate(UserProdInstVo vo) throws  PaasException{
		if(null == vo){
			throw new PaasException("入参对象为空！");
		}
		if(StringUtil.isBlank(vo.getUserId())){
			throw new PaasException("用户编码为空！");
		}
	}
	
	@Override
	public SelectWithNoPageResponse<UserProdInstVo> selectUserProdInsts(
			SelectWithNoPageRequest<UserProdInstVo> request) {
		// TODO Auto-generated method stub
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		try{
			this.validate(request.getSelectRequestVo());
			resultList = iMdsConsoleSv.selectUserProdInsts(request.getSelectRequestVo());
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		SelectWithNoPageResponse<UserProdInstVo> response = new SelectWithNoPageResponse<UserProdInstVo>();
		response.setResultList(resultList);
		response.setResponseHeader(responseHeader);		
		return response;
	}
	
	
	@Override
	public SelectWithNoPageResponse<UserProdInstVo> selectMdsById(
			SelectWithNoPageRequest<UserProdInstVo> request) {
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		try{
			this.validate(request.getSelectRequestVo());
			resultList = iMdsConsoleSv.selectMdsById(request.getSelectRequestVo());
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		SelectWithNoPageResponse<UserProdInstVo> response = new SelectWithNoPageResponse<UserProdInstVo>();
		response.setResultList(resultList);
		response.setResponseHeader(responseHeader);		
		return response;
	}
	
	@Override
	public ResponseSubPathList getListSubPath(SelectWithNoPageRequest<UserProdInstVo> request) {
		ResponseSubPathList response = new ResponseSubPathList();
		List<String> listSubPath  = new ArrayList<String>();
		try{
			this.validate(request.getSelectRequestVo());
			listSubPath = iMdsConsoleSv.getListSubPath(request.getSelectRequestVo());
			response.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
			response.setResultMsg("查询消息队列下子节点成功");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			response.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			response.setResultMsg("查询消息队列下子节点失败");
		}		
		response.setListSubPath(listSubPath);
		return response;
	}
	
	
	
	@Override
	public ResponseHeader cancleUserProdInst(UserProdInstVo vo) {
		ResponseHeader responseHeader = new ResponseHeader();	
		try{
			this.validate(vo);
			String resultCode = iMdsConsoleSv.cancleUserProdInst(vo);
			responseHeader.setResultCode(resultCode);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		return responseHeader;
	}

	@Override
	public ResponseHeader searchMessage(MdsSearchMessageVo vo) {
		// TODO Auto-generated method stub
		ResponseHeader responseHeader = new ResponseHeader();	
		try{
			MdsSearchRestfullRes result = iMdsConsoleSv.searchMessage(vo);
			responseHeader.setResultCode(result.getResultCode());
			responseHeader.setResultMessage(result.getTopicMessage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		return responseHeader;
	}
	
	@Override
	public ResponseHeader createSubscribe(MdsUserSubscribeVo vo){
		
		ResponseHeader responseHeader = new ResponseHeader();	
		try{
			MdsSubscribeRestfullRes result = iMdsConsoleSv.createSubscribe(vo);
			responseHeader.setResultCode(result.getResultCode());
			responseHeader.setResultMessage(result.getResultMsg());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		return responseHeader;
	}
	
	@Override
	public ResponseHeader getSubscribe(MdsUserSubscribeVo vo){
		ResponseHeader responseHeader = new ResponseHeader();	
		try{
			MdsGetSubscribeRestfullRes result = iMdsConsoleSv.getSubscribe(vo);
			String isExis = result.getIsExis();
			if("yes".equals(isExis)){
				responseHeader.setResultCode("111111");//已经存在
			}else if("no".equals(isExis)){
				responseHeader.setResultCode("222222");//不存在
			}else{
				responseHeader.setResultCode(result.getResultCode());//其他报错信息
			}
			responseHeader.setResultMessage(result.getResultMsg());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		return responseHeader;
	}
	

	@Override
	public String resendMessage(String params) {
		String result="";
		try {
			result=iMdsConsoleSv.resendMessage(params);
		} catch (NumberFormatException | PaasException | IOException
				| URISyntaxException e) {
			Map<String,String> resultinfo=new HashMap<String, String>();
			resultinfo.put("resultCode", PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			resultinfo.put("resultMsg", e.getMessage());
			e.printStackTrace();
			return JSonUtil.toJSon(resultinfo);
		}
		return result;
	}

	@Override
	public String skipMessage(String params) {
		String result="";
		try {
			result=iMdsConsoleSv.skipMessage(params);
		} catch (NumberFormatException | PaasException | IOException
				| URISyntaxException e) {
			Map<String,String> resultinfo=new HashMap<String, String>();
			resultinfo.put("resultCode", PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			resultinfo.put("resultMsg", e.getMessage());
			e.printStackTrace();
			return JSonUtil.toJSon(resultinfo);
		}
		return result;
	}
	

}
