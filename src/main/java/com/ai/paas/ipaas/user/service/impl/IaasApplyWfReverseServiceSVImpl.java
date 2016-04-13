package com.ai.paas.ipaas.user.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseVo;
import com.ai.paas.ipaas.user.dubbo.vo.ReverseVariablesVo;
import com.ai.paas.ipaas.user.dubbo.vo.VariablesVo;
import com.ai.paas.ipaas.user.service.IIaasApplyWfReverseServiceSV;
import com.ai.paas.ipaas.user.service.IOaSv;
import com.ai.paas.ipaas.user.service.dao.OrdStatusOperateRelMapper;
import com.ai.paas.ipaas.user.service.dao.OrderDetailMapper;
import com.ai.paas.ipaas.user.service.dao.OrderSchemeMapper;
import com.ai.paas.ipaas.user.service.dao.OrderWoMapper;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.EmailTemplUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.OaApplySynchronizeClent;
import com.ai.paas.ipaas.user.utils.ReadPropertiesUtil;
import com.ai.paas.ipaas.user.utils.gson.GsonUtil;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;

@Service
@Transactional
public class IaasApplyWfReverseServiceSVImpl implements IIaasApplyWfReverseServiceSV {
    private static final Logger logger = LogManager.getLogger(IaasApplyWfReverseServiceSVImpl.class
            .getName());

    @Autowired
    private SqlSessionTemplate template;
    @Autowired
    private IOaSv oaSv;

    public String processStartNotify(ReverseVariablesVo reverseVo) throws Exception {
        VariablesVo variablesVo = this.getVariableFromReverseVo(reverseVo);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailId(Long.parseLong(variablesVo.getApplyId()));
        orderDetail.setUserId(variablesVo.getUserId());
        orderDetail.setWfInstId(reverseVo.getProcessInstanceId());
        logger.info("iaas apply process start notify -> begin to modify the processInstancesId of the troubleTickets");
        OrderDetailMapper mapper = template.getMapper(OrderDetailMapper.class);
        OrderDetailCriteria example = new OrderDetailCriteria();
        example.createCriteria().andOrderDetailIdEqualTo(orderDetail.getOrderDetailId())
                .andUserIdEqualTo(variablesVo.getUserId());
        int uptCnt = mapper.updateByExampleSelective(orderDetail, example);
        ResponseVo resVo = new ResponseVo();
        if (uptCnt == 1) {
            logger.info("iaas apply process start notify -> modify the processInstancesId of the troubleTickets successfully and return success");
            resVo.setResponseCode(Constants.OPERATE_CODE_SUCCESS);
        } else {
            logger.info("iaas apply process start notify -> modify the processInstancesId of the troubleTickets unsuccessfully and return failure");
            resVo.setResponseCode(Constants.OPERATE_CODE_FAIL);
        }
        return JSonUtil.toJSon(resVo).toString();
    }

    @SuppressWarnings("static-access")
	public String taskDispatch(ReverseVariablesVo reverseVo) throws Exception {
        VariablesVo variablesVo = this.getVariableFromReverseVo(reverseVo);
        OrderWo orderWo = new OrderWo();
        if (variablesVo.getApplyId() != null)
            orderWo.setOrderDetailId(Long.parseLong(variablesVo.getApplyId()));
        else
            logger.warn("订单编号为空");
        orderWo.setWfTaskId(reverseVo.getTaskId());
        if(variablesVo.getWoResult()!=null && ("3".equals(variablesVo.getWoResult()) || "2".equals(variablesVo.getWoResult()))){
        	orderWo.setOperateId(variablesVo.getNtAccount());
        }else{
        	 String orderStatus = this.getOrdStsByWoRst(variablesVo.getWoResult());
             OrdStatusOperateRel ordStsOptRel = new OrdStatusOperateRel();
             OrdStatusOperateRelCriteria ordStsOptRelCriteria = new OrdStatusOperateRelCriteria();
             com.ai.paas.ipaas.user.dto.OrdStatusOperateRelCriteria.Criteria criteria = ordStsOptRelCriteria
                     .createCriteria();
             criteria.andOrderStatusEqualTo(orderStatus);
             criteria.andValidFlagEqualTo(Constants.ColumnStatus.EFFECTIVE);
             OrdStatusOperateRelMapper ordStsOptRelMapper = template
                     .getMapper(OrdStatusOperateRelMapper.class);
             List<OrdStatusOperateRel> ordStsOptRels = ordStsOptRelMapper
                     .selectByExample(ordStsOptRelCriteria);
             if (ordStsOptRels != null && ordStsOptRels.size() == 1) {
                 ordStsOptRel = ordStsOptRels.get(0);
                 orderWo.setOperateId(ordStsOptRel.getNtAccount());
             }
        }
       
        orderWo.setWoCreateDate(new Timestamp(System.currentTimeMillis()));
        orderWo.setWoStatus(Constants.WoStatus.WAIT_OPERATED);
        orderWo.setWoDesc(variablesVo.getWoDesc());
        if (variablesVo.getWoResult() == null
                || variablesVo.getWoResult().equals(Constants.IaasApplyWoResult.USER_UPT_COMMIT))
            orderWo.setDisplayFlag(Constants.DisplayFlag.NOT_DISPLAY);
        else
            orderWo.setDisplayFlag(Constants.DisplayFlag.DISPLAY);
        orderWo.setReceiptUrl(reverseVo.getURL());
        OrderWoMapper orderWoMapper = template.getMapper(OrderWoMapper.class);
        int saveCnt = orderWoMapper.insert(orderWo);
        ResponseVo resVo = new ResponseVo();
        if (saveCnt == 1) {
            resVo.setResponseCode(Constants.OPERATE_CODE_SUCCESS);
            if (variablesVo.getWoResult() == null || "8".equals(variablesVo.getWoResult())) {
            	logger.info("===============调oa审批开始==================");
             	OaApplySynchronizeClent oaApplySynchronizeClent= new OaApplySynchronizeClent();
             	oaApplySynchronizeClent.oaApplySynchronize(variablesVo, orderWo);
             	logger.info("===============调oa审批结束==================");
            }
        } else {
            logger.info("iaas apply process taskdispatch -> insert a order_wo record unsuccessfully and return failure");
            resVo.setResponseCode(Constants.OPERATE_CODE_FAIL);
        }
        return JSonUtil.toJSon(resVo).toString();
    }
   
    public String troubleCompleteDispatch(ReverseVariablesVo reverseVo) throws Exception {
        VariablesVo variablesVo = this.getVariableFromReverseVo(reverseVo);
        OrderDetail orderDetail = new OrderDetail();
        OrderDetailMapper orderDetailMapper = template.getMapper(OrderDetailMapper.class);
        orderDetail = orderDetailMapper.selectByPrimaryKey(Long.parseLong(variablesVo.getApplyId()));
        ResponseVo resVo = new ResponseVo();
        OrderSchemeWithBLOBs orderScheme = null;
        if (orderDetail != null) {
            orderDetail.setOrderStatus(Constants.Order.IaasOrderStatus.ORDER_STATUS_CLOSE);
            OrderDetailCriteria orderDetailCriteria = new OrderDetailCriteria();
            orderDetailCriteria.createCriteria().andOrderDetailIdEqualTo(
                    Long.parseLong(variablesVo.getApplyId()));
            int uptCnt = orderDetailMapper.updateByExampleSelective(orderDetail,orderDetailCriteria);
            String openParam = orderDetail.getOpenParam();        
            Map map = GsonUtil.fromJSon(openParam, Map.class);
            
            Map openParamMap = new HashMap();		
    		openParamMap.put("username", map.get("username"));
    		openParamMap.put("password", map.get("password"));        		
    		
    		OrderSchemeMapper orderSchemeMapper = template.getMapper(OrderSchemeMapper.class);
    		OrderSchemeCriteria orderSchemeCriteria = new OrderSchemeCriteria();   		
    		
    		OrderSchemeCriteria.Criteria criteria = orderSchemeCriteria.createCriteria();
    		criteria.andOrderDetailIdEqualTo(orderDetail.getOrderDetailId());
    		criteria.andValidFlagEqualTo(Constants.OrderScheme.VaildFlag.YES);
    		List<OrderSchemeWithBLOBs>  orderSchemeList= orderSchemeMapper.selectByExampleWithBLOBs(orderSchemeCriteria);
    		orderScheme = orderSchemeList.get(0);
            
    		List ips = (List) map.get("ip");        
            for(int i=0;i<ips.size();i++){
            	String ipStr = (String) ips.get(i);
            	String[] ipArrs = ipStr.split("_");
            	openParamMap.put("in_ip", ipArrs[0]);  
            	if(ipArrs.length == 2){
            		openParamMap.put("public_ip", ipArrs[1]);
            	}else{
            		openParamMap.put("public_ip", "");
            	}
            	openParamMap.put("softsConfig", orderDetail.getSoftsConfig());
            	String userServIpaasId   = createUserServIpaasId(orderDetail);	
         	    orderDetail.setUserServIpaasId(userServIpaasId);
         		UserProdInst userProdInst = new UserProdInst() ;	
         		userProdInst.setUserServIpaasId(userServIpaasId);
         		userProdInst.setUserServBackParam(GsonUtil.toJSon(openParamMap));		
         		userProdInst.setUserServIpaasId(orderDetail.getUserServIpaasId());
         		userProdInst.setUserServParam(orderScheme.getProdParam());
         		userProdInst.setUserServParamZh(orderScheme.getProdParamZh());
         		long userServId = this.saveUserProdInst(orderDetail, userProdInst);
         		orderDetail.setUserServId(String.valueOf(userServId));
            } 
            
            resVo.setResponseCode(Constants.OPERATE_CODE_SUCCESS);
        } else {
            throw new Exception("无效的applyID");
        } 

        String prodParam = orderScheme.getProdParam();
        Map map = GsonUtil.fromJSon(prodParam, HashMap.class);
        String title = null;
		String message = null;
		String toAddress = null;
		String applyCant = null;

		Properties properties = ReadPropertiesUtil.getProperties("/context/email.properties");
		String fromAddress = properties.getProperty("fromaddress");
		String fromPwd = properties.getProperty("frompwd");
		Map<String, Object> model = new HashMap<String, Object>();

		title = "虚拟机申请流程结束通知";
		message = "申请的亚信云虚拟机申请流程已经结束,请查看最终配置方案。";
		String Nt = orderDetail.getApplicantEmail().split("@")[0];
		String buiCode = oaSv.getBuiCodeByNt(Nt);
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("param", buiCode);
		String oaNtAccount = oaSv.getOaOperators(paramMap);
		toAddress = oaNtAccount+"@asiainfo.com";
		applyCant = orderDetail.getApplicant();
		model.put("toAddress", toAddress);// 收件人
		model.put("applyCant", applyCant);// 申请人
		model.put("message", message);
		model.put("title", title);
		
		model.put("virtualType", map.get("virtualType"));
		model.put("netType", map.get("netType"));
		model.put("cpu", map.get("cpu"));
		model.put("netBandW", map.get("netBandW"));
		model.put("virtualRam", map.get("virtualRam"));		
		model.put("netNum", map.get("netNum"));
		model.put("virtualHard", map.get("virtualHard"));
		model.put("SysTemChild", map.get("SysTemChild"));
		model.put("vmNumber", map.get("vmNumber"));
		String content = null;
		if(Constants.Order.BelongCloud.ZUYONG_YUN.equals(orderDetail.getBelongCloud())){
			content = VelocityEngineUtils.mergeTemplateIntoString(
						EmailTemplUtil.getVelocityEngineInstance(), "email/zuyongCloseNotify.vm",
						"UTF-8", model);
		}else{
			content = VelocityEngineUtils.mergeTemplateIntoString(
					EmailTemplUtil.getVelocityEngineInstance(), "email/yafaCloseNotify.vm",
					"UTF-8", model);
		}
		
		logger.info("======================邮件模板信息：" + content + "======================");
		// 邮件发送
		JSONObject json = new JSONObject();
		json.put("fromAddress", fromAddress);
		json.put("fromPwd", fromPwd);
		json.put("toAddress", toAddress);
		json.put("emailTitle", title);
		json.put("emailContent", content);
		String service = CacheUtils.getValueByKey("Email.SendEmail"); 
		HttpClientUtil.sendPostRequest(service	+ "/sendEmail/sendEmail", json.toString());
        
        return JSonUtil.toJSon(resVo).toString();
    }

   
    /**
     * 
     * @description 根据工单处理结果获取订单状态
     * @return
     * @author caiyt
     */
    private String getOrdStsByWoRst(String woResult) {
        if (woResult != null) {
            switch (woResult) {
            case Constants.IaasApplyWoResult.OA_CHECK_PASS:
            case Constants.IaasApplyWoResult.USER_DISAGREE_PLAN:
                return Constants.Order.IaasOrderStatus.WAIT_INTEGRATED_SCHEME;
            case Constants.IaasApplyWoResult.OA_CHECK_NOT_PASS:
                return Constants.Order.IaasOrderStatus.WAIT_USER_MODIFY_ORDER;
            case Constants.IaasApplyWoResult.MAINTAIN_MAKE_PLAN:
                return Constants.Order.IaasOrderStatus.WAIT_CONFIRM_SCHEME;
            case Constants.IaasApplyWoResult.USER_AGREE_PLAN:
                return Constants.Order.IaasOrderStatus.WAIT_OPEN;
            case Constants.IaasApplyWoResult.RECORD_OPEN_INFO:
                return Constants.Order.IaasOrderStatus.WAIT_INSTALL_SOFTWARE;
            case Constants.IaasApplyWoResult.RECORD_INSTALL_INFO:
                return Constants.Order.IaasOrderStatus.ORDER_STATUS_CLOSE;
            case "8":
            	return "5";//待oa审核
            }
        	
        		
        }
        return Constants.Order.IaasOrderStatus.WAIT_OA_AUDIT;
    }

    /**
     * 
     * @description 根据工作流返回的变量数组获取相关的参数
     * @return
     * @author caiyt
     */
    public VariablesVo getVariableFromReverseVo(ReverseVariablesVo reverseVo) {
        VariablesVo variable = new VariablesVo();
        for (VariablesVo vo : reverseVo.getVariables()) {
            if (vo.getUserId() != null && !vo.getUserId().trim().equals("")) {
                variable.setUserId(vo.getUserId());
                continue;
            }
            if (vo.getApplyId() != null && !vo.getApplyId().trim().equals("")) {
                variable.setApplyId(vo.getApplyId());
                continue;
            }
            if (vo.getWoResult() != null && !vo.getWoResult().trim().equals("")) {
                variable.setWoResult(vo.getWoResult());
                continue;
            }
            if (vo.getWoDesc() != null && !vo.getWoDesc().trim().equals("")) {
                variable.setWoDesc(vo.getWoDesc());
                continue;
            }
            if (vo.getOrderWoId() != null && !vo.getOrderWoId().trim().equals("")) {
                variable.setOrderWoId(vo.getOrderWoId());
            }
            if (vo.getNtAccount() != null && !vo.getNtAccount().trim().equals("")) {
                variable.setNtAccount(vo.getNtAccount());
            }
            if (vo.getCostCenterCode()!= null && !vo.getCostCenterCode().trim().equals("")) {
                variable.setCostCenterCode(vo.getCostCenterCode());
            }
        }
        return variable;
    }
    /**
     * OA申请单同步
     * @param variablesVo
     * @param orderWo
     * @return
     */
//    public String oaApplySynchronize(VariablesVo variablesVo,OrderWo orderWo){
//    	 
//    }
    
    
    public String createUserServIpaasId(OrderDetail orderDetail) throws PaasException{
		UserProdInstMapper mapper =  template.getMapper(UserProdInstMapper.class);
		UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
		UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();
		criteria.andUserIdEqualTo(orderDetail.getUserId());
		criteria.andUserServiceIdEqualTo(orderDetail.getProdId());
		criteria.andUserProdBynameEqualTo(orderDetail.getProdByname());
		userProdInstCriteria.setOrderByClause(" USER_SERV_IPAAS_ID desc");
		List<UserProdInst> list = mapper.selectByExample(userProdInstCriteria);
		String userServIpaasId = "";
		if((list == null || list.size() == 0) && !Constants.ProdProduct.ProdId.ATS.equals(orderDetail.getProdId())){
			userServIpaasId = orderDetail.getProdByname()+Constants.IPAAS_START_ID;
			return userServIpaasId;
		}		
		UserProdInst userProdInst = list.get(0);
		String maxserServIpaasId = userProdInst.getUserServIpaasId();
		String curNumStr = maxserServIpaasId.substring(orderDetail.getProdByname().length(),maxserServIpaasId.length());
		int nextNum = Integer.parseInt(curNumStr)+1;
		String nexNumStr = String.valueOf(nextNum);
		String nextNumStr = StringUtil.lPad(nexNumStr, Constants.IPAAS_ID_FIX, Constants.IPAAS_ID_LENGTH);
		userServIpaasId = orderDetail.getProdByname() + nextNumStr;
		logger.info("create servIpaasId："+userServIpaasId);		       
		return userServIpaasId;
	}	
    
    public long saveUserProdInst(OrderDetail orderDetail, UserProdInst prodInst) throws PaasException {
		
		UserProdInstMapper mapper =  template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst = new UserProdInst();
		userProdInst.setUserId(orderDetail.getUserId());
		userProdInst.setUserServType(orderDetail.getProdType());
		userProdInst.setUserServiceId(orderDetail.getProdId());
		userProdInst.setUserServIpaasId(prodInst.getUserServIpaasId());		
		userProdInst.setUserServParam(prodInst.getUserServParam());
		userProdInst.setUserServParamZh(prodInst.getUserServParamZh());
		userProdInst.setUserProdByname(orderDetail.getProdByname());
		userProdInst.setUserServState(Constants.UserProdInst.UserServState.OPEN);
		userProdInst.setUserServOpenTime(DateUtil.getSysDate());
		userProdInst.setUserServBackParam(prodInst.getUserServBackParam());	
		mapper.insert(userProdInst);
		return userProdInst.getUserServId();
		
		
	}
   
}