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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.OrderDetail;
import com.ai.paas.ipaas.user.dto.OrderDetailCriteria;
import com.ai.paas.ipaas.user.dto.OrderWo;
import com.ai.paas.ipaas.user.dto.OrderWoCriteria;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.UserMessage;
import com.ai.paas.ipaas.user.dubbo.vo.VariablesVo;
import com.ai.paas.ipaas.user.dubbo.vo.WorkflowRequest;
import com.ai.paas.ipaas.user.dubbo.vo.WorkflowResponse;
import com.ai.paas.ipaas.user.service.ISoftwareInstallSv;
import com.ai.paas.ipaas.user.service.dao.OrderDetailMapper;
import com.ai.paas.ipaas.user.service.dao.OrderWoMapper;
import com.ai.paas.ipaas.user.service.dao.ProdProductMapper;
import com.ai.paas.ipaas.user.service.dao.UserMessageMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.EmailTemplUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.user.utils.ReadPropertiesUtil;
import com.ai.paas.ipaas.user.utils.WorkflowClientUtils;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;
/**
 * 软件安装提交后场服务
 * @author renfeng
 *
 */
@Transactional
@Service
public class SoftwareInstallSvImpl implements ISoftwareInstallSv {

	private static final Logger logger = LogManager.getLogger(SoftwareInstallSvImpl.class
            .getName());
	@Autowired
	private SqlSessionTemplate template;
	private String responeStr;
	@Override
	public String softwareInstallSubmit(String params) throws Exception {
		logger.info("方案确认提交后台参数-------->"+params);
		JSONObject jsonObject = JsonUtils.parse(params);
		String orderDetailId = jsonObject.getString("orderDetailId");//订单编码
		String orderWoId = jsonObject.getString("orderWoId");//工单号
		String softsConfig = jsonObject.getString("softsConfig");//工单号
		

		OrderWo orderWo = new OrderWo();
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setSoftsConfig(softsConfig);
		
		OrderDetailCriteria orderDetailCriteria= new OrderDetailCriteria();
		OrderWoCriteria orderWoCriteria = new OrderWoCriteria();
		
		orderDetailCriteria.createCriteria().andOrderDetailIdEqualTo(Long.parseLong(orderDetailId));
		
		orderWoCriteria.createCriteria().andOrderDetailIdEqualTo(Long.parseLong(orderDetailId))
		.andWoStatusEqualTo("0").andOrderWoIdEqualTo(Long.parseLong(orderWoId));//待处理
		
		OrderDetailMapper orderDetailMapper = template.getMapper(OrderDetailMapper.class);
		OrderWoMapper orderWoMapper = template.getMapper(OrderWoMapper.class);
		
		orderWo.setWoStatus("1");//已处理
		orderWo.setWoDate(new Timestamp(new Date().getTime()));
		orderWo.setWoResult("7");//已录入软件安装信息
		orderDetail.setOrderStatus("4");//关闭
		int updateOrderWo = orderWoMapper.updateByExampleSelective(orderWo, orderWoCriteria);
		int updateOrderDetail = orderDetailMapper.updateByExampleSelective(orderDetail, orderDetailCriteria);
		if(updateOrderWo>0&&updateOrderDetail>0){
			OrderWoCriteria orderWoCriteria2 = new OrderWoCriteria();
			orderWoCriteria2.createCriteria().andOrderDetailIdEqualTo(Long.parseLong(orderDetailId))
			.andWoStatusEqualTo("1").andWoResultEqualTo("7");
			List<OrderDetail> orderDetailList = orderDetailMapper.selectByExampleWithBLOBs(orderDetailCriteria);
			List<OrderWo> orderWoList = orderWoMapper.selectByExample(orderWoCriteria2);
			if(orderDetailList!=null && orderDetailList.size()>0 && orderWoList.size()>0 && orderWoList!=null){
				WorkflowRequest workflowRequest= new WorkflowRequest();
				VariablesVo variablesVo =new VariablesVo();
				List<VariablesVo> variablesVoList =new ArrayList<VariablesVo>();
				
				variablesVo.setApplyId(String.valueOf(orderWoList.get(0).getOrderDetailId()));
				variablesVo.setNtAccount(orderDetailList.get(0).getApplicantEmail().split("@")[0]);
				variablesVo.setWoDesc(orderWoList.get(0).getWoDesc());
				variablesVo.setWoResult(orderWoList.get(0).getWoResult());
				variablesVoList.add(variablesVo);
				
				workflowRequest.setProcessInstanceId(orderDetailList.get(0).getWfInstId());
				workflowRequest.setTaskId(orderWoList.get(0).getWfTaskId());
				workflowRequest.setVariables(variablesVoList);
				WorkflowResponse workflowResponse = WorkflowClientUtils.taskComplete(workflowRequest);
				logger.info("软件安装完成工作流任务完成接口返回状态参数-------->"+workflowResponse.getResponCode());
				if(workflowResponse!=null && workflowResponse.getResponCode().equals("200")){
					//消息中心.............................
					logger.info("消息中心调用前this.saveUserMessage(orderDetailId):"+orderDetailId);
					this.saveUserMessage(orderDetailId); 
					logger.info("消息中心调用后：：：：：:");
					//消息中心....................................
					
					//邮件通知beging....................................................
					String title="云虚拟机安装成功通知";
					String button="使用查看";
					String message="申请的亚信云虚拟机服务，软件安装成功。";
					String toAddress =orderDetailList.get(0).getApplicantEmail();
					
			        Properties properties = ReadPropertiesUtil.getProperties("/context/email.properties");
        			String fromAddress = properties.getProperty("fromaddress");
        			String fromPwd = properties.getProperty("frompwd");
        			String url = SystemConfigHandler.configMap.get("IPAAS-WEB.SERVICE.IP_PORT_SERVICE") +
    		        		SystemConfigHandler.configMap.get("IPAAS-WEB.IAASCONSOLE.URL");
//        			String url= CacheUtils.getOptionByKey("IPAAS-WEB.SERVICE","IP_PORT_SERVICE")+CacheUtils.getOptionByKey("IPAAS-WEB.IAASCONSOLE","URL");
                    Map<String,Object> model = new HashMap<String,Object>(); 
                    model.put("toAddress", toAddress);//收件人
                    //model.put("applyCant", orderDetailList.get(0).getApplicant());//申请人
                    model.put("title", title);
                    model.put("applyCant", "您");//申请人
                    model.put("url", url);
                    model.put("urlHtml", url.replace( "&","&amp;" ));
                    model.put("button", button);
			        model.put("message", message);
                	String content = VelocityEngineUtils.mergeTemplateIntoString(EmailTemplUtil.getVelocityEngineInstance(), "email/common.vm", "UTF-8", model); 
                	logger.info("======================邮件模板信息："+content+"======================");
                	
					//邮件发送
					JSONObject json = new JSONObject();
					json.put("fromAddress", fromAddress);
					json.put("fromPwd", fromPwd);
					json.put("toAddress", toAddress);
					json.put("emailTitle", title);
					json.put("emailContent", content);
//					String service =CacheUtils.getValueByKey("Email.SendEmail");  //"http://10.1.228.198:20184/sendemail"
					String service = SystemConfigHandler.configMap.get("Email.SendEmail.service");
					String result = null;
					result = HttpClientUtil.sendPostRequest(service+"/sendEmail/sendEmail",json.toString());
					System.out.println(result);
					logger.info("++++++++++++++++软件安装成功邮件发送结果----->"+result);
					responeStr="000000";
					//邮件通知end...................................................
				}else{
					logger.error("软件安装完成调工作流任务完成接口失败！");
					throw new Exception("软件安装完成调工作流任务完成接口失败！");
				}
			}else{
				logger.info("软件安装完成获取工作流参数失败！");
				throw new Exception("软件安装完成获取工作流参数失败！");
			}
		}else{
			logger.info("软件安装完成更新工单状态失败！");
			throw new Exception("软件安装完成更新工单状态失败！");
		}
		
		return responeStr;
	}

	
	public void  saveUserMessage(String orderDetailId) throws PaasException{
		OrderDetailMapper orderDetailMapper = template.getMapper(OrderDetailMapper.class);
		OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(Long.parseLong(orderDetailId));				
		ProdProductMapper prodProductMapper =  template.getMapper(ProdProductMapper.class);
		ProdProduct prodProduct = prodProductMapper.selectByPrimaryKey(Short.parseShort(orderDetail.getProdId()));
		if(prodProduct == null){
			throw new PaasException("根据id查询产品信息为空");
		}
		String content =  "您订购的"+prodProduct.getProdName()+" 软件安装成功。";

		UserMessage userMessage  = new UserMessage();
		userMessage.setUserId(orderDetail.getUserId());
		userMessage.setUserMsgContent(content);
		userMessage.setUserMsgSendTime(DateUtil.getSysDate());
		UserMessageMapper userMessageMapper=template.getMapper(UserMessageMapper.class);
		userMessageMapper.insert(userMessage);

		
	}
}
