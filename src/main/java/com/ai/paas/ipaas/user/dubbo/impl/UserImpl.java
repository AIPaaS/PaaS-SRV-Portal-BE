package com.ai.paas.ipaas.user.dubbo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.ResponseMessage;
import com.ai.paas.ipaas.user.dto.UserCenter;
import com.ai.paas.ipaas.user.dubbo.interfaces.IUser;
import com.ai.paas.ipaas.user.dubbo.vo.RegisterResult;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.dubbo.vo.UserVo;
import com.ai.paas.ipaas.user.service.IUserProdInstSv;
import com.ai.paas.ipaas.user.service.IUserSv;
import com.ai.paas.ipaas.util.JSonUtil;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class UserImpl implements IUser {
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private IUserSv userSv ;
	@Autowired
	private IUserProdInstSv iUserProdInstSv;
	@Override
	public UserVo getUserInfo(String userId) throws PaasException {
		UserVo vo = new UserVo();
		UserCenter bo = null;
		try {
			bo=userSv.getUserInfo(userId);
			if (bo !=null) {
				BeanUtils.copyProperties(bo, vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw  new PaasException(e.getMessage());
		}
		return vo;
	}
	@Override
	public RegisterResult registerUser(UserVo user) throws PaasException {
			
		RegisterResult result = null;
		try {
			result=userSv.registerUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return result;
	}
	@Override
	public boolean uniqueEmail(String email) throws PaasException {
		// TODO Auto-generated method stub
		logger.info("校验email是否存在开始==========");
		boolean result = false;
		try {
			result=userSv.uniqueEmail(email);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("校验email是否存在结束==========");
		return result;
	}
	@Override
	public boolean uniquePhone(String phone) throws PaasException {
		logger.info("校验phone是否存在开始==========");
		boolean result = false;
		try {
			result=userSv.uniquePhone(phone);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("校验phone是否存在结束==========");
		return result;
	}
	@Override
	public int verfiy_email(String email) throws PaasException {
		// TODO Auto-generated method stub
		return userSv.activeUser(email);
	}
	@Override
	public UserVo getUserInfoByEmail(String email) throws PaasException {
		UserVo vo = new UserVo();
		UserCenter bo = null;
		try {
			bo=userSv.getUserInfoByEmail(email);
			if (bo !=null) {
				BeanUtils.copyProperties(bo, vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw  new PaasException(e.getMessage());
		}
		return vo;
	}
	@Override
	public String getUserInfoByUserName(String param) {
		UserVo vo = new UserVo();
		UserCenter bo = null;
		try {			
			Map paramMap = JSonUtil.fromJSon(param, Map.class);
			String userNmae = (String) paramMap.get("userName");
			bo=userSv.getUserInfoByEmail(userNmae);
			if (bo !=null) {
				BeanUtils.copyProperties(bo, vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return JSonUtil.toJSon(vo);
	}
	@Override
	public String getUserProdInstsWithType(String param) {
		ResponseHeader responseHeader = new ResponseHeader();	
		List<UserProdInstVo>   resultList  = new ArrayList<UserProdInstVo>();
		ResponseMessage<List<UserProdInstVo>> responseMessage = new ResponseMessage<List<UserProdInstVo>>();
		try{
			Map paramMap = JSonUtil.fromJSon(param, Map.class);
			resultList = iUserProdInstSv.selectUserProdInsts(paramMap);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		responseMessage.setResData(resultList);	
		return JSonUtil.toJSon(responseMessage);
	}
	@Override
	public int updatebyKey(UserVo uv) throws PaasException {
		//UserVo userCenter = JSonUtil.fromJSon(param, UserVo.class);
		int result = 0;
		try {
			result=userSv.updateUserEmailbyKey(uv);
			logger.info("UserImpl:result"+result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return result;
	}
	@Override
	public String updateUserPs(UserVo uv) throws PaasException {
		//UserVo userCenter = JSonUtil.fromJSon(param, UserVo.class);
		String result = null;
		try {
			result=userSv.updateUserPsById(uv);
			logger.info("UserImpl:result"+result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return result;
	}

}
