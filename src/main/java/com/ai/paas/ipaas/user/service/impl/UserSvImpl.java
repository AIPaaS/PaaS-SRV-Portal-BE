package com.ai.paas.ipaas.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.Assert;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dto.UserCenter;
import com.ai.paas.ipaas.user.dto.UserCenterCriteria;
import com.ai.paas.ipaas.user.dto.UserMgrOperate;
import com.ai.paas.ipaas.user.dubbo.vo.EmailDetail;
import com.ai.paas.ipaas.user.dubbo.vo.RegisterResult;
import com.ai.paas.ipaas.user.dubbo.vo.UserVo;
import com.ai.paas.ipaas.user.exception.BusinessException;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.IUserSv;
import com.ai.paas.ipaas.user.service.dao.UserCenterMapper;
import com.ai.paas.ipaas.user.service.dao.UserMgrOperateMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.EmailTemplUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.HttpRequestUtil;
import com.ai.paas.ipaas.user.utils.oamd5.OaMd5Util;
import com.ai.paas.ipaas.util.CiperUtil;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserSvImpl implements IUserSv {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
    private SqlSessionTemplate template;
	
	@Autowired
	private ISysParamSv iSysParamSv;
	
	@Override
	public UserCenter getUserInfo(String userId) {
		UserCenterMapper userCenterMapper = template.getMapper(UserCenterMapper.class);
		return userCenterMapper.selectByPrimaryKey(userId);
	}	
	
	@Override
	public RegisterResult registerUser(UserVo uservo) throws  PaasException{
		long beginTime = System.currentTimeMillis();
		Assert.notNull(uservo, "user is null");
		
		RegisterResult registerResult = new RegisterResult();
		String userId = uservo.getUserId();
		String pId = uservo.getPid();
		String userEmail = uservo.getUserEmail();
		logger.info("##### begin to register user ##### ");
		try {
			//幂等性操作
			UserCenter userCenter = getUserInfoByEmail(userEmail);
			if(userCenter != null){
				registerResult.setUserId(userId);
				registerResult.setRegisterSuccess(true);
				return registerResult;
			}
			String adress = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +
					SystemConfigHandler.configMap.get("CCS_CUST.INIT.URL");
			
			logger.info("##### begin to createConfigInfo ##### userId:"+userId);
			String createConfigResult = HttpClientUtil.sendPostRequest(adress,  "{\"userId\":"+userId+"}");
			logger.info("##### finish to to createConfigInfo   spend time："+(System.currentTimeMillis()-beginTime));
			
			Gson gson = new Gson();
			JsonObject json = gson.fromJson(createConfigResult, JsonObject.class);
			String code = json.get(Constants.Restful.OpenServKey.CODE).getAsString();
			
			if(Constants.Restful.OpenServResult.SUCCESS.equals(code)){
				logger.info("##### begin to white to user_center#######");
				UserCenter uc = new UserCenter();
				BeanUtils.copyProperties(uservo, uc);
				
				UserCenterMapper userCenterMapper = template.getMapper(UserCenterMapper.class);
				int ucInsertResult = userCenterMapper.insert(uc);
				logger.info("##### finish to white to user_center#######result:"+ucInsertResult);
				
				if(ucInsertResult > 0){
					logger.info("##### begin to white to auth_center#######");/////auth_center
					adress = SystemConfigHandler.configMap.get("IPAAS-UAC.SERVICE.IP_PORT_SERVICE") +
							SystemConfigHandler.configMap.get("IPAAS-UAC.SVWEB.URL");
					String svWebResult = HttpRequestUtil.sendPost(adress,  "authUserId="+userId+"&authUserName="+userEmail+"|"+uservo.getUserPhoneNum()+"&authPassword="+uservo.getUserPwd()+"&authPid="+pId);	//  pId				
					JsonObject svWebJson = gson.fromJson(svWebResult, JsonObject.class);
					String svWebCode = svWebJson.get(Constants.Restful.OpenServKey.CODE).getAsString();
					if(!Constants.Restful.OpenServResult.SUCCESS.equals(svWebCode)){
						throw new RuntimeException("fail to svWeb!stupid!");
					}
					
					logger.info("##### setting email info and returned to portal #######");
					String subject = "亚信云  激活验证链接";
					registerResult.setNeedSend(true);
					EmailDetail email = getRegisterEmail(subject, userEmail);
					registerResult.setEmail(email);
					logger.info("#####finish to send email spend time："+(System.currentTimeMillis()-beginTime));
				}else{
					throw new RuntimeException("fail to white to auth_center!stupid!");
				}
			} else {
				throw new RuntimeException("fail to init ccs when register!stupid!");
			}
			
			logger.info("##### finish to register user ##### ");
			registerResult.setUserId(userId);
			registerResult.setRegisterSuccess(true);
		} catch (Exception e) {
			logger.info(e.getMessage(),e);
			throw new RuntimeException("fail to register!stupid!");
		}
		
		return registerResult;
	}

	/**
	 * 校验email
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public boolean uniqueEmail(String email) {
		logger.info("校验email开始===="+email);
		boolean flag = false;
		try {
			UserCenterMapper userCenterMapper = template.getMapper(UserCenterMapper.class);
			UserCenterCriteria userCenterCriteria= new UserCenterCriteria();
			userCenterCriteria.createCriteria().andUserEmailEqualTo(email);
			List<UserCenter> userResults = userCenterMapper.selectByExample(userCenterCriteria);
			if(userResults.size() > 0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new RuntimeException("Check email error");
		}
		return !flag;
	}

	/**
	 * 校验phone
	 * 
	 * @param phone
	 * @return
	 */
	@Override
	public boolean uniquePhone(String phone) {
		logger.info("校验phone开始===="+phone);
		boolean flag = false;
		try {
			UserCenterMapper userCenterMapper = template.getMapper(UserCenterMapper.class);
			UserCenterCriteria userCenterCriteria= new UserCenterCriteria();
			userCenterCriteria.createCriteria().andUserPhoneNumEqualTo(phone);
			List<UserCenter> userResults = userCenterMapper.selectByExample(userCenterCriteria);
			if(userResults.size() > 0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new RuntimeException("Check phone error");
		}
		return !flag;
	}

	@Override
	public int activeUser(String email) {
		// TODO Auto-generated method stub
		logger.info("begin to activeUser by email ====:"+email);
		try {
			UserCenter userCenter = new UserCenter();
			userCenter.setUserEmail(email);
			userCenter.setUserState("2");
			UserCenterMapper mapper = template.getMapper(UserCenterMapper.class);
			UserCenterCriteria authCenterCriteria = new UserCenterCriteria();
			authCenterCriteria.createCriteria().andUserEmailEqualTo(email);
			return mapper.updateByExampleSelective(userCenter, authCenterCriteria);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException("activeUser error");
		}
	}
	
	@Override
	public int updateUserEmailbyKey(UserVo uv) throws PaasException {
		logger.info("begin to updateUserbyKey by UserId ====:"+uv.getUserId());
		int rsv=0;
		try {
			UserCenter userCenter = new UserCenter();
			BeanUtils.copyProperties(uv, userCenter);
			String modAdress = SystemConfigHandler.configMap.get("IPAAS-UAC.SERVICE.IP_PORT_SERVICE") +
					SystemConfigHandler.configMap.get("IPAAS-UAC.MODIFYACCOUNT.URL");
			String svWebResult = HttpRequestUtil.sendPost(modAdress, "mail="+uv.getUserEmail()+"&userId="+uv.getUserId());
			logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>svWebResult:"+svWebResult);
			
			Gson gson = new Gson();
			JsonObject json = gson.fromJson(svWebResult, JsonObject.class);
			String code = json.get(Constants.Restful.OpenServKey.CODE).getAsString();
			if("000000".endsWith(code)){ //resultCode
				UserCenterMapper mapper = template.getMapper(UserCenterMapper.class);
				rsv=mapper.updateByPrimaryKeySelective(userCenter);
				logger.info("userSvImpl rsv:"+rsv);
				
				//if("1".equals(rsv)){
				logger.info("##### begin to insert UserMgrOperate ");
				int count = -1;
				UserMgrOperate userMgrOperate = makeUserMgrOperateVo(uv,"0001","11","000000"); //uservo ,ProdId 0001/0002 ,actionCode 11/12,resultCode 000000
				UserMgrOperateMapper userMgrOperateMapper =  template.getMapper(UserMgrOperateMapper.class);
				userMgrOperate.setUserUpdateBefore(uv.getOldEmail());//更改前内容
				userMgrOperate.setUserUpdateAfter(uv.getUserEmail());//更改后内容
				count = userMgrOperateMapper.insert(userMgrOperate);
				logger.info("##### finish to insert UserMgrOperate ,result is :"+count);
				//}
			}
			
			return rsv;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException("updateUserbyKey error");
		}
	}
	
	@Override
	public String updateUserPsById(UserVo uv) throws PaasException {
		logger.info("begin to updateUserbyKey by UserId ====:"+uv.getUserId());
		try {
			String modAdress = SystemConfigHandler.configMap.get("IPAAS-UAC.SERVICE.IP_PORT_SERVICE") +
					SystemConfigHandler.configMap.get("IPAAS-UAC.MODIFYSERVPWD.URL");
			String svWebResult = HttpRequestUtil.sendPost(modAdress, "newPwd="+uv.getNewPwd()+"&oldPwd="+uv.getUserPwd()+"&serviceId="+uv.getUserEmail()+"&userId="+uv.getUserId());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>svWebResult:"+svWebResult);
			
			Gson gson = new Gson();
			JsonObject json = gson.fromJson(svWebResult, JsonObject.class);
			String code = json.get(Constants.Restful.OpenServKey.CODE).getAsString();
			if("000000".endsWith(code)){ //resultCode
				logger.info("##### begin to insert UserMgrOperate ");
				int count = -1;
				UserMgrOperate userMgrOperate = makeUserMgrOperateVo(uv,"0002","12","000000"); //uservo ,ProdId 0001/0002 ,actionCode 11/12,resultCode 000000
				UserMgrOperateMapper userMgrOperateMapper =  template.getMapper(UserMgrOperateMapper.class);
				userMgrOperate.setUserUpdateBefore(uv.getUserPwd());//更改前内容
				userMgrOperate.setUserUpdateAfter(uv.getNewPwd());//更改后内容
				count = userMgrOperateMapper.insert(userMgrOperate);
				logger.info("##### finish to insert UserMgrOperate ,result is :"+count);
			}

			return svWebResult;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException("updateUserPsById error");
		}
	}

	@Override
	public UserCenter getUserInfoByEmail(String email) throws PaasException {
		logger.info("getUserInfoByEmail===="+email);
		try {
			UserCenterMapper userCenterMapper = template.getMapper(UserCenterMapper.class);
			UserCenterCriteria userCenterCriteria= new UserCenterCriteria();
			userCenterCriteria.createCriteria().andUserEmailEqualTo(email);
			List<UserCenter> userResults = userCenterMapper.selectByExample(userCenterCriteria);
			if(userResults.size() >= 1){
				return userResults.get(0);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new RuntimeException("getUserInfoByEmail  error");
		}
	}

	@Override
	public Object getAiEmployeeInfo(Map<String, String> paramMap)
			throws BusinessException {
		Object object = null;
		String key;
		try {	
			String addressTime = SystemConfigHandler.configMap.get("OA.OA.getAIServerTime");
			key = OaMd5Util.encryptToMD5(HttpRequestUtil.sendGet(addressTime, "")
					+ "AIHRA_EMPLOYEE_INFO_FOR_HR_Vdjk*3k@-3_31");

			String ntAccount = "'"+paramMap.get("ntAccount")+"'";
			Map reqMap = new HashMap();
			reqMap.put("key", key);
			reqMap.put("sw=nt_account", ntAccount);			
			String addressEmp = SystemConfigHandler.configMap.get("OA.OA.getAIHRA_EMPLOYEE");
			object = HttpClientUtil.sendGet(addressEmp,reqMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("OA接口异常");
		}
		return object;
	}

	//用于修改密码，账户时建立UserMgrOperate实体类
	public UserMgrOperate makeUserMgrOperateVo(UserVo uservo ,String ProdId ,String actionCode, String resultCode){
			UserMgrOperate  userMgrOperate = new  UserMgrOperate();
			userMgrOperate.setUserId(uservo.getUserId());//用户编码  
			userMgrOperate.setUserProdType("1");// 产品类型 1：存储  2：计算
			userMgrOperate.setUserProdId(ProdId);//  产品编码      0001 用户名更改   0002 用户密码修改
			userMgrOperate.setUserServId(uservo.getUserEmail());//用户服务标识
			userMgrOperate.setUserServIpaasId("IpassWeb000");//IPAAS平台产品
			//产品参数setUserProdParam
			userMgrOperate.setUserProdByname("IpassWeb");//产品别名
			userMgrOperate.setUserOperateDate(DateUtil.getSysDate());//操作时间
			if("11".equals(actionCode)){
				userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.UserEmail);  //操作动作 UserEmail 11 ,UserPs12
			}
			if("12".equals(actionCode)){
				userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.UserPs);  //操作动作 UserEmail 11 ,UserPs12
			}
			//userMgrOperate.setUserUpdateBefore("old");//更改前内容
			//userMgrOperate.setUserUpdateAfter("new");//更改后内容
			if(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)){
				userMgrOperate.setUserOperateResult(Constants.UserMgrOperate.UserOperateResult.SUCCESS);
			}else{
				userMgrOperate.setUserOperateResult(Constants.UserMgrOperate.UserOperateResult.FAIL);
			}
	       return userMgrOperate;
		}

	/**
	 * 用户注册成功的邮件信息
	 * @param subject
	 * @param toSenders
	 * @return
	 * @throws Exception
	 */
	private EmailDetail getRegisterEmail(String subject, String toSenders) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("email", toSenders);
		// 获取邮件激活链接地址
		String address = SystemConfigHandler.configMap.get("IPAAS-WEB.SERVICE.IP_PORT_SERVICE")
				+ SystemConfigHandler.configMap.get("AUTH.VERIFY.url");
		String token = CiperUtil.encrypt(Constants.SECURITY_KEY, toSenders);
		model.put("activeLink", address + "?token=" + token);
		String content = VelocityEngineUtils.mergeTemplateIntoString(EmailTemplUtil.getVelocityEngineInstance(),
				"email/registermail.vm", "UTF-8", model);
		
		EmailDetail email = new EmailDetail();
		email.setToAddress(toSenders);
		email.setEmailTitle(subject);
		email.setEmailContent(content);
		return email;
	}

}
