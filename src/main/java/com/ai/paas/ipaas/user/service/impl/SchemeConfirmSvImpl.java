package com.ai.paas.ipaas.user.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.cache.CacheUtils;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dto.OrdStatusOperateRel;
import com.ai.paas.ipaas.user.dto.OrdStatusOperateRelCriteria;
import com.ai.paas.ipaas.user.dto.OrderDetail;
import com.ai.paas.ipaas.user.dto.OrderDetailCriteria;
import com.ai.paas.ipaas.user.dto.OrderSchemeCriteria;
import com.ai.paas.ipaas.user.dto.OrderSchemeWithBLOBs;
import com.ai.paas.ipaas.user.dto.OrderWo;
import com.ai.paas.ipaas.user.dto.OrderWoCriteria;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.ProdQuota;
import com.ai.paas.ipaas.user.dto.ProdQuotaCriteria;
import com.ai.paas.ipaas.user.dto.UserMessage;
import com.ai.paas.ipaas.user.dubbo.vo.VariablesVo;
import com.ai.paas.ipaas.user.dubbo.vo.WorkflowRequest;
import com.ai.paas.ipaas.user.dubbo.vo.WorkflowResponse;
import com.ai.paas.ipaas.user.service.ISchemeConfirmSv;
import com.ai.paas.ipaas.user.service.IUserSv;
import com.ai.paas.ipaas.user.service.ProdQuotaSv;
import com.ai.paas.ipaas.user.service.dao.OrdStatusOperateRelMapper;
import com.ai.paas.ipaas.user.service.dao.OrderDetailMapper;
import com.ai.paas.ipaas.user.service.dao.OrderSchemeMapper;
import com.ai.paas.ipaas.user.service.dao.OrderWoMapper;
import com.ai.paas.ipaas.user.service.dao.ProdProductMapper;
import com.ai.paas.ipaas.user.service.dao.ProdQuotaMapper;
import com.ai.paas.ipaas.user.service.dao.UserMessageMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.EmailTemplUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.user.utils.ReadPropertiesUtil;
import com.ai.paas.ipaas.user.utils.WorkflowClientUtils;
@Service
public class SchemeConfirmSvImpl implements ISchemeConfirmSv {
	private static final Logger logger = LogManager.getLogger(SchemeConfirmSvImpl.class
            .getName());
	@Autowired
	private SqlSessionTemplate template;
	private String responeStr;
	
	@Autowired
	private IUserSv iUserSv; 
	@Autowired
	private ProdQuotaSv prodQuotaSv;
	
	@Override
	public String schemeSubmit(String params) throws Exception {
		logger.info("方案确认提交后台参数-------->"+params);
		JSONObject jsonObject = JsonUtils.parse(params);
		String isAgree = jsonObject.getString("isAgree");//是否同意标志 '0'-不同意 '1'-同意
		String orderDetailId = jsonObject.getString("orderDetailId");//订单编码
		
		String result2 = null;
		String service2 =CacheUtils.getOptionByKey("CONTROLLER.CONTROLLER","url");
//		String service2 = "http://127.0.0.1:20881/ipaas";
		String url2 = "/user/prodQuotaApi/prodQuotaByOrderId";
		result2 = HttpClientUtil.sendPostRequest(service2 + url2, orderDetailId);
		ProdQuota fromJSon = null;
		if(result2!=null && !"".equals(result2)){
			fromJSon = JsonUtils.fromJSon(result2, ProdQuota.class);
		}else{
			 logger.error("获取核减参数失败！");
			 throw new Exception("获取核减参数失败！");
		}
		
		OrderDetail orderdetail = new OrderDetail();
		OrderWo orderWo = new OrderWo();
		OrderSchemeWithBLOBs orderScheme = new OrderSchemeWithBLOBs();
		ProdQuota prodQuota = new ProdQuota();
		
		OrderDetailCriteria orderDetailCriteria= new OrderDetailCriteria();
		OrderWoCriteria orderWoCriteria = new OrderWoCriteria();
		OrderSchemeCriteria orderSchemeCriteria = new OrderSchemeCriteria();
		ProdQuotaCriteria prodQuotaCriteria = new ProdQuotaCriteria();
		
		orderDetailCriteria.createCriteria().andOrderDetailIdEqualTo(Long.parseLong(orderDetailId));
		orderWoCriteria.createCriteria().andOrderDetailIdEqualTo(Long.parseLong(orderDetailId))
		.andWoStatusEqualTo("0");//待处理
		orderSchemeCriteria.createCriteria().andOrderDetailIdEqualTo(Long.parseLong(orderDetailId))
		.andValidFlagEqualTo("0");//有效
		prodQuotaCriteria.createCriteria().andUserOrgNameEqualTo(fromJSon.getUserOrgName());
		
		
		OrderDetailMapper orderDetailMapper = template.getMapper(OrderDetailMapper.class);
		OrderWoMapper orderWoMapper = template.getMapper(OrderWoMapper.class);
		OrderSchemeMapper orderSchemeMapper = template.getMapper(OrderSchemeMapper.class);
		ProdQuotaMapper prodQuotaMapper = template.getMapper(ProdQuotaMapper.class);
		
		List<OrderSchemeWithBLOBs> orderSchemeList = orderSchemeMapper.selectByExampleWithBLOBs(orderSchemeCriteria);
		List<OrderWo> orderWoList = orderWoMapper.selectByExample(orderWoCriteria);
		List<OrderDetail> orderDetailList = orderDetailMapper.selectByExampleWithBLOBs(orderDetailCriteria);
		if(!"".equals(isAgree)&&"1".equals(isAgree)){
			JSONObject schemeProdParamZh = JsonUtils.parse(orderSchemeList.get(0).getProdParam());
			JSONObject orderProdParamZh = JsonUtils.parse(orderDetailList.get(0).getProdParam());
			
			Short schemeVmNumber = Short.parseShort(schemeProdParamZh.getString("vmNumber"));
			Short orderVmNumber= orderDetailList.get(0).getVmNumber();
			
			//cpu
			if(Integer.parseInt(schemeProdParamZh.getString("cpu").substring(0, schemeProdParamZh.getString("cpu").lastIndexOf("核")))*schemeVmNumber
				>Integer.parseInt(orderProdParamZh.getString("cpu").substring(0, orderProdParamZh.getString("cpu").lastIndexOf("核")))*orderVmNumber
			){
				int cupNumber= (fromJSon.getRemainCpuQuota()-(Integer.parseInt(schemeProdParamZh.getString("cpu").substring(0, schemeProdParamZh.getString("cpu").lastIndexOf("核")))*schemeVmNumber
				-Integer.parseInt(orderProdParamZh.getString("cpu").substring(0, orderProdParamZh.getString("cpu").lastIndexOf("核")))*orderVmNumber
				));
				prodQuota.setRemainCpuQuota(cupNumber);
			}else if(Integer.parseInt(schemeProdParamZh.getString("cpu").substring(0, schemeProdParamZh.getString("cpu").lastIndexOf("核")))*schemeVmNumber
					<Integer.parseInt(orderProdParamZh.getString("cpu").substring(0, orderProdParamZh.getString("cpu").lastIndexOf("核")))*orderVmNumber
			){
				int cupNumber= (fromJSon.getRemainCpuQuota()+Math.abs((Integer.parseInt(schemeProdParamZh.getString("cpu").substring(0, schemeProdParamZh.getString("cpu").lastIndexOf("核")))*schemeVmNumber
						-Integer.parseInt(orderProdParamZh.getString("cpu").substring(0, orderProdParamZh.getString("cpu").lastIndexOf("核")))*orderVmNumber
						)));
				prodQuota.setRemainCpuQuota(cupNumber);
			}else{
				prodQuota.setRemainCpuQuota(fromJSon.getRemainCpuQuota());
			}
			//virtualRam
			if(Integer.parseInt(schemeProdParamZh.getString("virtualRam").substring(0, schemeProdParamZh.getString("virtualRam").lastIndexOf("G")))*schemeVmNumber
				>Integer.parseInt(orderProdParamZh.getString("virtualRam").substring(0, orderProdParamZh.getString("virtualRam").lastIndexOf("G")))*orderVmNumber
			){
				int virtualRamNumber= (fromJSon.getRemainMemoryQuota()-(Integer.parseInt(schemeProdParamZh.getString("virtualRam").substring(0, schemeProdParamZh.getString("virtualRam").lastIndexOf("G")))*schemeVmNumber
						-Integer.parseInt(orderProdParamZh.getString("virtualRam").substring(0, orderProdParamZh.getString("virtualRam").lastIndexOf("G")))*orderVmNumber
						));
						prodQuota.setRemainMemoryQuota(virtualRamNumber);
			}else if(Integer.parseInt(schemeProdParamZh.getString("virtualRam").substring(0, schemeProdParamZh.getString("virtualRam").lastIndexOf("G")))*schemeVmNumber
					<Integer.parseInt(orderProdParamZh.getString("virtualRam").substring(0, orderProdParamZh.getString("virtualRam").lastIndexOf("G")))*orderVmNumber
			){
				int virtualRamNumber= (fromJSon.getRemainMemoryQuota()+Math.abs((Integer.parseInt(schemeProdParamZh.getString("virtualRam").substring(0, schemeProdParamZh.getString("virtualRam").lastIndexOf("G")))*schemeVmNumber
						-Integer.parseInt(orderProdParamZh.getString("virtualRam").substring(0, orderProdParamZh.getString("virtualRam").lastIndexOf("G")))*orderVmNumber))
						);
						prodQuota.setRemainMemoryQuota(virtualRamNumber);
			}else{
				prodQuota.setRemainCpuQuota(fromJSon.getRemainCpuQuota());
			}
			//virtualHard
			if(Integer.parseInt(schemeProdParamZh.getString("virtualHard"))*schemeVmNumber
				>Integer.parseInt(orderProdParamZh.getString("virtualHard"))*orderVmNumber
			){
				int virtualHardNumber= (fromJSon.getRemainDiskSpaceQuota()-(Integer.parseInt(schemeProdParamZh.getString("virtualHard"))*schemeVmNumber
						-Integer.parseInt(orderProdParamZh.getString("virtualHard"))*orderVmNumber));
						prodQuota.setRemainDiskSpaceQuota(virtualHardNumber);
			}else if(Integer.parseInt(schemeProdParamZh.getString("virtualHard"))*schemeVmNumber
					<Integer.parseInt(orderProdParamZh.getString("virtualHard"))*orderVmNumber
			){
				int virtualHardNumber= (fromJSon.getRemainDiskSpaceQuota()+Math.abs((Integer.parseInt(schemeProdParamZh.getString("virtualHard"))*schemeVmNumber
						-Integer.parseInt(orderProdParamZh.getString("virtualHard"))*orderVmNumber)));
						prodQuota.setRemainDiskSpaceQuota(virtualHardNumber);
			}else{
				prodQuota.setRemainCpuQuota(fromJSon.getRemainCpuQuota());
			}
		}
		
		
		orderWo.setWoStatus("1");//已处理
		orderWo.setWoDate(new Timestamp(new Date().getTime()));
		
		int updateOrderScheme = 0;
		String woResultTmp=null;
		String orderStatusTmp=null;
		//方案确认-同意
		if(!"".equals(isAgree)&&"1".equals(isAgree)){
			orderdetail.setOrderStatus("8");//待开通录入
			orderWo.setWoResult("4");//用户已同意集成方案
			woResultTmp="4";
			orderStatusTmp="8";
		}else{//方案确认-不同意
			orderdetail.setOrderStatus("6");//待制定方案
			orderWo.setWoResult("5");//用户不同意集成方案
			orderScheme.setValidFlag("1");//无效
			woResultTmp="5";
			orderStatusTmp="6";
			updateOrderScheme = orderSchemeMapper.updateByExampleSelective(orderScheme, orderSchemeCriteria);
		}
		OrderDetail orderDetailtemp =  orderDetailMapper.selectByPrimaryKey(Long.parseLong(orderDetailId));
		if(prodQuota!=null&&!"".equals(isAgree)&&"1".equals(isAgree) 
				&& Constants.Order.BelongCloud.YANFA_YUN.equals(orderDetailtemp.getBelongCloud())){
			prodQuotaMapper.updateByExampleSelective(prodQuota, prodQuotaCriteria);
		}
		int updateOrderDetail = orderDetailMapper.updateByExampleSelective(orderdetail, orderDetailCriteria);
		int updateOrderWo = orderWoMapper.updateByExampleSelective(orderWo, orderWoCriteria);
		
		
		//任务完成调工作流派单
		logger.info("=============方案确认数据修改结果======"+updateOrderDetail+"---"+updateOrderWo+"---"+updateOrderScheme);
		if(updateOrderDetail>0 && updateOrderWo>0){
			
			if(orderDetailList!=null && orderDetailList.size()>0 && orderWoList.size()>0 && orderWoList!=null){
				WorkflowRequest workflowRequest= new WorkflowRequest();
				VariablesVo variablesVo =new VariablesVo();
				List<VariablesVo> variablesVoList =new ArrayList<VariablesVo>();
				
				variablesVo.setApplyId(String.valueOf(orderWoList.get(0).getOrderDetailId()));
				variablesVo.setNtAccount(orderDetailList.get(0).getApplicantEmail().split("@")[0]);
				variablesVo.setWoDesc(orderWoList.get(0).getWoDesc());
				variablesVo.setWoResult(woResultTmp);
				variablesVoList.add(variablesVo);
				
				workflowRequest.setProcessInstanceId(orderDetailList.get(0).getWfInstId());
				workflowRequest.setTaskId(orderWoList.get(0).getWfTaskId());
				workflowRequest.setVariables(variablesVoList);
				WorkflowResponse workflowResponse = WorkflowClientUtils.taskComplete(workflowRequest);
				logger.info("方案确认工作流任务完成接口返回状态参数-------->"+workflowResponse.getResponCode());
				if(workflowResponse!=null && workflowResponse.getResponCode().equals("200")){
					String title=null;
					String button=null;
					String message =null;
					if("4".equals(woResultTmp)){
						title="云虚拟机开通录入通知";
						button="开通录入";
						message="申请的亚信云虚拟机服务，需要您录入开通。";
					}
					if("5".equals(woResultTmp)){
						title="云虚拟机制定方案通知";
						button="制定方案";
						message="申请的亚信云虚拟机服务，需要您制定方案。";
					}
					String toAddress =null;
			        OrdStatusOperateRelCriteria ordStsOptRelCriteria = new OrdStatusOperateRelCriteria();
			        com.ai.paas.ipaas.user.dto.OrdStatusOperateRelCriteria.Criteria criteria = ordStsOptRelCriteria
			                .createCriteria();
			        criteria.andOrderStatusEqualTo(orderStatusTmp);
			        criteria.andValidFlagEqualTo(Constants.ColumnStatus.EFFECTIVE);
			        OrdStatusOperateRelMapper ordStsOptRelMapper = template
			                .getMapper(OrdStatusOperateRelMapper.class);
			        List<OrdStatusOperateRel> ordStsOptRelsList = ordStsOptRelMapper
			                .selectByExample(ordStsOptRelCriteria);
			        if (ordStsOptRelsList != null && ordStsOptRelsList.size() == 1) {
			        	toAddress=ordStsOptRelsList.get(0).getMailGroup();  // 修改前getNtAccount()
			        }
			        Properties properties = ReadPropertiesUtil.getProperties("/context/email.properties");
        			String fromAddress = properties.getProperty("fromaddress");
        			String fromPwd = properties.getProperty("frompwd");
        			String url=CacheUtils.getOptionByKey("PAAS-MAINTAIN-WEB.SERVICE","IP-PORT-SERVICE")+CacheUtils.getOptionByKey("PAAS-MAINTAIN-WEB.LOGIN","URL");
                    Map<String,Object> model = new HashMap<String,Object>(); 
                    model.put("toAddress", toAddress);//收件人
                    model.put("applyCant", orderDetailList.get(0).getApplicant());//申请人
                    model.put("url", url);
                    model.put("urlHtml", url.replace( "&","&amp;" ));
                    model.put("button", button);
                    model.put("message", message);
                    model.put("title", title);
                    
                	String content = VelocityEngineUtils.mergeTemplateIntoString(EmailTemplUtil.getVelocityEngineInstance(), "email/common.vm", "UTF-8", model); 
                	
					//邮件发送
					JSONObject json = new JSONObject();
					json.put("fromAddress", fromAddress);
					json.put("fromPwd", fromPwd);
					json.put("toAddress", toAddress+"@asiainfo.com");
					json.put("emailTitle", title);
					json.put("emailContent", content);
					String service =CacheUtils.getValueByKey("Email.SendEmail");  //"http://10.1.228.198:20184/sendemail"
					//String service = "http://10.1.228.198:20184/sendemail";
					String result = null;
					result = HttpClientUtil.sendPostRequest(
							service+"/sendEmail/sendEmail",
							json.toString());
					System.out.println(result);
					logger.info("方案确认邮件发送结果----->"+result);
					
					//消息中心.....................................
					OrderDetail orderDetail111 = orderDetailMapper.selectByPrimaryKey(Long.parseLong(orderDetailId));
					this.saveUserMessage(orderDetail111);
					//消息中心.....................................
					
					responeStr="000000";
				}else{
					logger.error("调工作流任务完成接口失败！");
					throw new Exception("调工作流任务完成接口失败！");
				}
			}else{
				 logger.error("获取工作流任务完成参数失败！");
				 throw new Exception("获取工作流任务完成参数失败！");
			}
		}else{
			logger.error("方案确认数据插入失败！");
			throw new Exception("方案确认数据插入失败！");
		}
		return responeStr;
	}
	
	
	
	public void  saveUserMessage(OrderDetail orderDetail) throws PaasException{
		//OrderDetail orderDetail = this.selectByPrimaryKey(orderDetailTmp.getOrderDetailId());				
		ProdProductMapper prodProductMapper =  template.getMapper(ProdProductMapper.class);
		ProdProduct prodProduct = prodProductMapper.selectByPrimaryKey(Short.parseShort(orderDetail.getProdId()));
		if(prodProduct == null){
			throw new PaasException("根据id查询产品信息为空");
		}
		String content = "";
		if(Constants.Order.OrderCheckResult.CHECK_PASS.equals(orderDetail.getOrderCheckResult())){
			content = "您订购的"+prodProduct.getProdName()+"审核通过";
		}else{
			
			if(orderDetail.getOrderCheckDesc()!=null){
				content =  "您订购的"+prodProduct.getProdName()+"审核不通过通过，原因："+orderDetail.getOrderCheckDesc();
			  }else{
				content =  "您订购的"+prodProduct.getProdName()+"审核不通过通过，原因：OA审核不通过！";
		 }

		}
		UserMessage userMessage  = new UserMessage();
		userMessage.setUserId(orderDetail.getUserId());
		userMessage.setUserMsgContent(content);
		userMessage.setUserMsgSendTime(DateUtil.getSysDate());
		UserMessageMapper userMessageMapper=template.getMapper(UserMessageMapper.class);
		userMessageMapper.insert(userMessage);

		
	}
	
	
	
	
	
	

}
