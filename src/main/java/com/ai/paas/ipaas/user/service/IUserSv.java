package com.ai.paas.ipaas.user.service;

import java.util.Map;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.UserCenter;
import com.ai.paas.ipaas.user.dubbo.vo.RegisterResult;
import com.ai.paas.ipaas.user.dubbo.vo.UserVo;
import com.ai.paas.ipaas.user.exception.BusinessException;


public interface IUserSv {
	public UserCenter  getUserInfo(String userId) ;//获取用户信息
	public UserCenter  getUserInfoByEmail(String email) throws PaasException;//获取用户信息
	public RegisterResult registerUser(UserVo user) throws PaasException;//用户注册
	public int activeUser(String userId) throws PaasException;;//用户激活
	public boolean uniqueEmail(String email) throws PaasException;;// email是否存在
	public boolean uniquePhone(String phone) throws PaasException;;// phone是否存在
	public Object getAiEmployeeInfo(Map<String,String> paramMap) throws BusinessException;
	public int updateUserEmailbyKey(UserVo record) throws PaasException;//根据userId修改邮箱
	public String updateUserPsById(UserVo record) throws PaasException;//根据userId修改密码


}
