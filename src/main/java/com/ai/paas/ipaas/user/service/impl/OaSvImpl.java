package com.ai.paas.ipaas.user.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.constants.ExceptionConstants;
import com.ai.paas.ipaas.user.dto.OaOperaters;
import com.ai.paas.ipaas.user.dto.OaOperatersCriteria;
import com.ai.paas.ipaas.user.dto.OrderDetail;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.ProdQuota;
import com.ai.paas.ipaas.user.dto.ProdQuotaCriteria;
import com.ai.paas.ipaas.user.dto.UserCenter;
import com.ai.paas.ipaas.user.dto.UserMessage;
import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.exception.BusinessException;
import com.ai.paas.ipaas.user.service.IOaSv;
import com.ai.paas.ipaas.user.service.IOrderSv;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.IUserSv;
import com.ai.paas.ipaas.user.service.ProdQuotaSv;
import com.ai.paas.ipaas.user.service.dao.OaOperatersMapper;
import com.ai.paas.ipaas.user.service.dao.OrderDetailMapper;
import com.ai.paas.ipaas.user.service.dao.ProdProductMapper;
import com.ai.paas.ipaas.user.service.dao.ProdQuotaMapper;
import com.ai.paas.ipaas.user.service.dao.UserMessageMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.HttpRequestUtil;
import com.ai.paas.ipaas.user.utils.gson.GsonUtil;
import com.ai.paas.ipaas.user.utils.oamd5.OaMd5Util;
import com.ai.paas.ipaas.user.vo.ErpProjectVo;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
@Transactional
public class OaSvImpl implements IOaSv {

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private IOrderSv iOrderDetailSv;
	
	@Autowired
	private ProdQuotaSv prodQuotaSv;
	
	@Autowired
	private IUserSv iUserSv; 
	
	@Autowired
	private ISysParamSv iSysParamSv;
	
	@Override
	public String getOaOperators(Map paramMap) throws Exception {
		logger.info("input OaSvImpl getOaOperators function ");		
		String param = (String) paramMap.get("param");
		OaOperatersCriteria aaOperatersCriteria = new OaOperatersCriteria();
		OaOperatersCriteria.Criteria criteria = aaOperatersCriteria	.createCriteria();
		criteria.andBuiCodeEqualTo(param);
		OaOperatersMapper oaOperatersMapper = template.getMapper(OaOperatersMapper.class);
		List<OaOperaters> oaOperatersList = oaOperatersMapper.selectByExample(aaOperatersCriteria);

		if(null == oaOperatersList || 0 == oaOperatersList.size()){
			throw new BusinessException(ExceptionConstants.Response.NO_RESULT, "param没有资源管理员配置");
		}
		logger.info("output OaSvImpl getOaOperators function ");	
		return oaOperatersList.get(0).getNtAccount();
	}

	@Override
	public Object oaAuditResultNotify(Map<String, Object> paramMap) throws Exception {
		/** 屏蔽portal中的iaas模块功能，屏蔽此方法路逻辑。2016-06-12 **/
//		String orderDetailId = (String) paramMap.get("orderDetailId");
//		String operType = (String) paramMap.get("operType");
//		String orderWoId = (String) paramMap.get("orderWoId");
//		String woDesc = (String) paramMap.get("woDesc");
//		
//		OrderDetailMapper orderDetailMapper=  template.getMapper(OrderDetailMapper.class);	
//		OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(Long.parseLong(orderDetailId));
//		logger.info("==============oa审核通知orderdetail=========="+JsonUtils.toJsonStr(orderDetail));
//		OrderWoMapper orderWoMapper = template.getMapper(OrderWoMapper.class);		
//		OrderWo orderWo = orderWoMapper.selectByPrimaryKey(Long.parseLong(orderWoId));
//		orderWo.setWoDesc(woDesc);		
//		orderWo.setWoStatus(Constants.WoStatus.HAS_OPERATED);		
//		orderWo.setWoDate(DateUtil.getSysDate());
//				
//		if("AGREE".equals(operType)){			
//			orderDetail.setOrderStatus(Constants.Order.IaasOrderStatus.WAIT_INTEGRATED_SCHEME);
//			orderDetail.setOrderCheckStatus("2");//审核通过
//			orderDetail.setOrderCheckResult("1");//审核通过
//			orderWo.setWoResult(IaasApplyWoResult.OA_CHECK_PASS);
//		}else{
//			orderDetail.setOrderCheckResult("2");//审核驳回
//			orderDetail.setOrderStatus(Constants.Order.IaasOrderStatus.WAIT_USER_MODIFY_ORDER);
//			orderWo.setWoResult(IaasApplyWoResult.OA_CHECK_NOT_PASS);
//			//审核不通过时，已经核减的配额需要回滚
//			if(Constants.Order.SbutractFlag.REDUCED.equals(orderDetail.getSbutractFlag()) 
//					&& Constants.Order.BelongCloud.YANFA_YUN.equals(orderDetail.getBelongCloud()) ){	
//				orderDetail.setSbutractFlag(Constants.Order.SbutractFlag.NOT_REDUCED);
//				this.reducedRollback(orderDetail);
//			}
//		}
//		
//		//邮件通知beging。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
//		String title = null;
//		String button = null;
//		String message = null;
//		String toAddress = null;
//		String applyCant = null;
//
//		Properties properties = ReadPropertiesUtil
//				.getProperties("/context/email.properties");
//		String fromAddress = properties.getProperty("fromaddress");
//		String fromPwd = properties.getProperty("frompwd");
////		String url = CacheUtils.getOptionByKey("PAAS-MAINTAIN-WEB.SERVICE","IP-PORT-SERVICE")+CacheUtils.getOptionByKey("PAAS-MAINTAIN-WEB.LOGIN","URL");
////		String url2 = CacheUtils.getOptionByKey("IPAAS-WEB.SERVICE","IP_PORT_SERVICE")+CacheUtils.getOptionByKey("IPAAS-WEB.PURCHASERECORDS","URL");
//		
//		String url = SystemConfigHandler.configMap.get("PAAS-MAINTAIN-WEB.SERVICE.IP_PORT_SERVICE") +
//				SystemConfigHandler.configMap.get("PAAS-MAINTAIN-WEB.LOGIN.URL");
//		String url2 = SystemConfigHandler.configMap.get("IPAAS-WEB.SERVICE.IP_PORT_SERVICE") +
//				SystemConfigHandler.configMap.get("IPAAS-WEB.PURCHASERECORDS.URL");
//
//		Map<String, Object> model = new HashMap<String, Object>();
//
//		if ("AGREE".equals(operType)) {
//			// OA 通过 ，资源管理员制定方案发送邮件
//			title = "云虚拟机制定方案通知";
//			button = "制定方案";
//			message = "申请的亚信云虚拟机服务，需要您制定方案。";
//			applyCant = orderDetail.getApplicant();// 申请人
//			model.put("url", url);
//			model.put("urlHtml", url.replace( "&","&amp;" ));
//			model.put("applyCant", applyCant);// 申请人
//			
//			OrdStatusOperateRelCriteria ordStsOptRelCriteria = new OrdStatusOperateRelCriteria();
//			com.ai.paas.ipaas.user.dto.OrdStatusOperateRelCriteria.Criteria criteria = ordStsOptRelCriteria
//					.createCriteria();
//			criteria.andOrderStatusEqualTo(Constants.Order.IaasOrderStatus.WAIT_INTEGRATED_SCHEME);// 6
//																									// orderDetail.getOrderStatus()
//			criteria.andValidFlagEqualTo(Constants.ColumnStatus.EFFECTIVE);
//			OrdStatusOperateRelMapper ordStsOptRelMapper = template
//					.getMapper(OrdStatusOperateRelMapper.class);
//			List<OrdStatusOperateRel> ordStsOptRelsList = ordStsOptRelMapper
//					.selectByExample(ordStsOptRelCriteria);
//			if (ordStsOptRelsList != null && ordStsOptRelsList.size() == 1) {
//				if (ordStsOptRelsList.get(0).getNtAccount() != null) {
//					toAddress = ordStsOptRelsList.get(0).getMailGroup()
//							+ "@asiainfo.com";// 收件人  getNtAccount()
//				}
//
//			}
//
//		} else {
//
//			// ////消息中心
//			logger.info("=========申请修改通知=====消息中心" + orderDetail);
//			this.saveUserMessage(orderDetail);
//			// ////消息中心
//
//			// OA 不通过 ，给申请人发送邮件
//			title = "云虚拟机修改通知";
//			button = "修改";
//			message = "申请的亚信云虚拟机服务，需要您修改申请。";
//			toAddress = orderDetail.getApplicantEmail();
//			//applyCant = orderDetail.getApplicant();
//			model.put("url", url2);
//			model.put("urlHtml", url2.replace( "&","&amp;" ));
//			model.put("applyCant", "您");// 申请人
//		}
//
//		if (toAddress != null
//				&& !"".equals(toAddress.split("@asiainfo.com")[0])) {
//			// Map<String,Object> model = new HashMap<String,Object>();
//			model.put("toAddress", toAddress);// 收件人
//			//model.put("applyCant", applyCant);// 申请人
//			// model.put("url", url);
//			model.put("button", button);
//			model.put("message", message);
//			model.put("title", title);
//			String content = VelocityEngineUtils.mergeTemplateIntoString(
//					EmailTemplUtil.getVelocityEngineInstance(), "email/common.vm",
//					"UTF-8", model);
//			logger.info("======================邮件模板信息：" + content
//					+ "======================");
//			// 邮件发送
//			JSONObject json = new JSONObject();
//			json.put("fromAddress", fromAddress);
//			json.put("fromPwd", fromPwd);
//			json.put("toAddress", toAddress);
//			json.put("emailTitle", title);
//			json.put("emailContent", content);
////			String service = CacheUtils.getValueByKey("Email.SendEmail"); // "http://10.1.228.198:20184/sendemail"
//			String service = SystemConfigHandler.configMap.get("Email.SendEmail.service");
//			String result = null;
//			result = HttpClientUtil.sendPostRequest(service
//					+ "/sendEmail/sendEmail", json.toString());
//			logger.info("++++++++++++++++OA审批发送结果----->" + result);
//		}
//
//		//邮件通知end。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
//		
//		orderWoMapper.updateByPrimaryKey(orderWo);
//		
//		orderDetailMapper.updateByPrimaryKey(orderDetail);
//
//		WorkflowRequest workflowRequest = new WorkflowRequest();
//		workflowRequest.setProcessInstanceId(orderDetail.getWfInstId());
//		workflowRequest.setTaskId(orderWo.getWfTaskId());		
//		String ntAccount = orderDetail.getApplicantEmail().split("@")[0];
//		List<VariablesVo> variables  = new ArrayList<VariablesVo>();
//		VariablesVo  wariablesVo = new VariablesVo();
//		wariablesVo.setApplyId(String.valueOf(orderDetail.getOrderDetailId()));
//		wariablesVo.setUserId(orderDetail.getUserId());
//		wariablesVo.setNtAccount(ntAccount);
//		wariablesVo.setOrderWoId(orderWoId);
//		wariablesVo.setWoResult(orderWo.getWoResult());
//		workflowRequest.setVariables(variables);
//		variables.add(wariablesVo);
//		workflowRequest.setVariables(variables);
//		logger.info("oa审批通知任务完成参数=============="+JsonUtils.toJsonStr(workflowRequest));
//		WorkflowClientUtils.taskComplete(workflowRequest);
	
		return null;
	}
	
	
	public void  saveUserMessage(OrderDetail orderDetail) throws PaasException{
		ProdProductMapper prodProductMapper = template
				.getMapper(ProdProductMapper.class);
		ProdProduct prodProduct = prodProductMapper.selectByPrimaryKey(Short
				.parseShort(orderDetail.getProdId()));
		if (prodProduct == null) {
			throw new PaasException("根据id查询产品信息为空");
		}
		String content = "";

		if (orderDetail.getOrderCheckDesc() != null) {
			content = "您订购的" + prodProduct.getProdName() + "审核不通过，原因："
					+ orderDetail.getOrderCheckDesc();
		} else {
			content = "您订购的" + prodProduct.getProdName() + "审核不通过，原因：OA审核不通过！";
		}

		UserMessage userMessage = new UserMessage();
		userMessage.setUserId(orderDetail.getUserId());
		userMessage.setUserMsgContent(content);
		userMessage.setUserMsgSendTime(DateUtil.getSysDate());
		UserMessageMapper userMessageMapper = template
				.getMapper(UserMessageMapper.class);
		userMessageMapper.insert(userMessage);

		
	}
	
	@Override
	public String getBuiCodeByNt(String Nt) {
		JSONObject param=new JSONObject();
		param.put("ntAccount", Nt); //String json = "{\"ntAccount\":\""+Nt+"\"}";
//		String service = CacheUtils.getOptionByKey("CONTROLLER.CONTROLLER","url");//http://10.1.228.200:10990/ipaas
		String service = SystemConfigHandler.configMap.get("CONTROLLER.CONTROLLER.url");
		String url = "/user/iUserApi/getAiEmployeeInfo";
		
		try {
			String result = HttpClientUtil.sendPostRequest(service + url, param.toString());
			if(result!=null){
					Map resmap = GsonUtil.fromJSon(result, HashMap.class);
				    String object  = (String) resmap.get("object");
				    if("ERROR:未找到员工信息".equals(object) || "999999".equals(resmap.get("responseCode"))){
				    	return "999999";
				    }
	
				    Gson gson2 = new Gson();
				    List<Map<String,Object>> list= gson2.fromJson(object,new TypeToken<List<Map<String,Object>>>() {}.getType());		    
				    Map lais = list.get(0);
				    JSONObject ss=new JSONObject();
				    org.json.JSONObject jsonww = new org.json.JSONObject(lais);
				    logger.info("sbu2"+jsonww.get("sbu2").toString());
				    return jsonww.get("sbu2").toString();
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return "999999";
	}

	@Override
	public Object oaAuditPremise(Map<String, Object> paramMap) {
		logger.info("input OaSvImpl oaAuditPremise function ");		
		String orderDetailId = (String) paramMap.get("orderDetailId");
		OrderDetailMapper orderDetailMapper=  template.getMapper(OrderDetailMapper.class);	
		OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(Long.parseLong(orderDetailId));
		if(null == orderDetail ){
			throw new BusinessException(ExceptionConstants.Response.NO_RESULT, "没有对应申请单");
		}
		Map<String,String> resultMap = new HashMap<String,String>();
		String belongCloud = orderDetail.getBelongCloud();
		//研发云有配额，需要核减
		if(Constants.Order.BelongCloud.YANFA_YUN.equals(belongCloud)){
			String userId = orderDetail.getUserId();
			UserCenter userCenter = iUserSv.getUserInfo(userId);
			String ntAccount = userCenter.getUserEmail().split("@")[0];
			String buiCode = this.getBuiCodeByNt(ntAccount);
			ProdQuota prodQuota = new ProdQuota();	
			prodQuota.setProdId(Integer.parseInt(orderDetail.getProdId()));
			prodQuota.setUserOrgName(buiCode);		
			List<ProdQuota> prodQuotaList = prodQuotaSv.getProdQuotaInfo(prodQuota);		
			prodQuota  = prodQuotaList.get(0);
			String orderProdParam = orderDetail.getProdParam();
			Map<String,String> map = GsonUtil.fromJSon(orderProdParam,HashMap.class);
			String cpu = map.get("cpu").split("核")[0];
			String virtualRam = map.get("virtualRam").split("G")[0];
			String virtualHard = map.get("virtualHard");
			Integer limitCpu = prodQuota.getRemainCpuQuota()-Integer.parseInt(cpu)*orderDetail.getVmNumber();
			Integer limitVirtualRam = prodQuota.getRemainMemoryQuota()-Integer.parseInt(virtualRam)*orderDetail.getVmNumber();
			Integer limitDiskSpace = prodQuota.getRemainDiskSpaceQuota()-Integer.parseInt(virtualHard)*orderDetail.getVmNumber();
			
			
			if(limitCpu>=0 && limitVirtualRam>=0 && limitDiskSpace >=0){
				prodQuota.setRemainCpuQuota(limitCpu.intValue());
				prodQuota.setRemainMemoryQuota(limitVirtualRam.intValue());
				prodQuota.setRemainDiskSpaceQuota(limitDiskSpace.intValue());	
				ProdQuotaCriteria prodQuotaCriteria = new ProdQuotaCriteria();
				ProdQuotaCriteria.Criteria criteria = prodQuotaCriteria.createCriteria();
				criteria.andProdIdEqualTo(Integer.parseInt(orderDetail.getProdId()));
				criteria.andUserOrgNameEqualTo(buiCode);
				ProdQuotaMapper prodQuotaMapper = template.getMapper(ProdQuotaMapper.class);	
				prodQuotaMapper.updateByExampleSelective(prodQuota, prodQuotaCriteria);
				
				orderDetail.setSbutractFlag(Constants.Order.SbutractFlag.REDUCED);				
				orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
				
				resultMap.put("reslut", "0");
				resultMap.put("message", "验证通过");
			}else{
				resultMap.put("reslut", "1");
				resultMap.put("message", "配额不足!");
			}
		}else{ //租用云没有配额，直接返回验证通过
			resultMap.put("reslut", "0");
			resultMap.put("message", "验证通过");
		}			
		
		return resultMap;
	}
	
	public String reducedRollback(OrderDetail orderDetail){
		String userId = orderDetail.getUserId();
		UserCenter userCenter = iUserSv.getUserInfo(userId);		
		String ntAccount = userCenter.getUserEmail().split("@")[0];
		String buiCode = this.getBuiCodeByNt(ntAccount);
		ProdQuota prodQuota = new ProdQuota();	
		prodQuota.setProdId(Integer.parseInt(orderDetail.getProdId()));
		prodQuota.setUserOrgName(buiCode);		
		List<ProdQuota> prodQuotaList = prodQuotaSv.getProdQuotaInfo(prodQuota);		
		prodQuota  = prodQuotaList.get(0);
		
		String orderProdParam = orderDetail.getProdParam();
		Map<String,String> map = GsonUtil.fromJSon(orderProdParam,HashMap.class);
		String cpu = map.get("cpu").split("核")[0];
		String virtualRam = map.get("virtualRam").split("G")[0];
		String virtualHard = map.get("virtualHard");
		
		Integer limitCpu = prodQuota.getRemainCpuQuota()+Integer.parseInt(cpu)*orderDetail.getVmNumber();
		Integer limitVirtualRam = prodQuota.getRemainMemoryQuota()+Integer.parseInt(virtualRam)*orderDetail.getVmNumber();
		Integer limitDiskSpace = prodQuota.getRemainDiskSpaceQuota()+Integer.parseInt(virtualHard)*orderDetail.getVmNumber();
		
		prodQuota.setRemainCpuQuota(limitCpu.intValue());
		prodQuota.setRemainMemoryQuota(limitVirtualRam.intValue());
		prodQuota.setRemainDiskSpaceQuota(limitDiskSpace.intValue());	
		ProdQuotaCriteria prodQuotaCriteria = new ProdQuotaCriteria();
		ProdQuotaCriteria.Criteria criteria = prodQuotaCriteria.createCriteria();
		criteria.andProdIdEqualTo(Integer.parseInt(orderDetail.getProdId()));
		criteria.andUserOrgNameEqualTo(buiCode);
		ProdQuotaMapper prodQuotaMapper = template.getMapper(ProdQuotaMapper.class);	
		prodQuotaMapper.updateByExampleSelective(prodQuota, prodQuotaCriteria);	
		
		return null;
	}

	@Override
	public PageResult<ErpProjectVo> getErpProjects(Map<String, String> paramMap) {
		String erpProjectCode = paramMap.get("erpProjectCode");
		String pageIndex = paramMap.get("pageIndex");
		String pageSize = paramMap.get("pageSize");
		PageResult<ErpProjectVo> pageResult = new PageResult<ErpProjectVo>();
				
		try {
//			String address = CacheUtils.getOptionByKey("OA.OA","getAIServerTime");
			String address = SystemConfigHandler.configMap.get("OA.OA.getAIServerTime");
			String key;
			key = OaMd5Util.encryptToMD5(HttpRequestUtil.sendGet(address, "")
					+ "XXAI_PROJECT_ALL_V1djk*3k@-3_31");

			Map<String,String> reqMap = new HashMap<String,String>();
			reqMap.put("key", key);
			reqMap.put("projectCode", erpProjectCode);
			reqMap.put("pageIndex", pageIndex);
			reqMap.put("pageSize", pageSize);

//			String getProjectListAddress = CacheUtils.getOptionByKey("OA.OA","getProjectList");		
			String getProjectListAddress = SystemConfigHandler.configMap.get("OA.OA.getProjectList");
			String object = null;
			object = HttpClientUtil.sendGet(getProjectListAddress,reqMap);

			if (!object.startsWith("ERROR")) {
				List<ErpProjectVo> erpProjectVoList = new ArrayList<ErpProjectVo>();
				ErpProjectVo erpProjectVo = null;
				Gson gson = new Gson();
				Map<String, Object> resultMap = gson.fromJson(object,
						new TypeToken<Map<String, Object>>() {
						}.getType());
				List<Map> list2 = (List) resultMap.get("data");
				Map projectMap = new HashMap();
				for (int i = 0; i < list2.size(); i++) {
					projectMap = (Map) list2.get(i);
					erpProjectVo = new ErpProjectVo();
					erpProjectVo.setErpProjectCode((String)projectMap.get("segment1"));
					erpProjectVo.setErpProjectName((String)projectMap.get("project_name"));
					erpProjectVoList.add(erpProjectVo);

				}
				pageResult.setResultList(erpProjectVoList);
				Double temptotal = (double) resultMap.get("total");
				int total = temptotal.intValue();
				pageResult.setTotalCount(total);
			}else{
				throw new BusinessException(ExceptionConstants.Request.PARAM_IS_NOT_VALID, object);
			}

		} catch (Exception e) {
			throw new BusinessException(ExceptionConstants.Trade.TRADE_FAILURE, "项目信息列表查询接口异常");
		}
		
		return pageResult;
	}		
}
