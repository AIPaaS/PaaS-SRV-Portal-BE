package com.ai.paas.ipaas.user.dubbo.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.OrderDetail;
import com.ai.paas.ipaas.user.dto.ProdQuota;
import com.ai.paas.ipaas.user.dto.UserCenter;
import com.ai.paas.ipaas.user.dubbo.interfaces.ProdQuotaApi;
import com.ai.paas.ipaas.user.service.IOaSv;
import com.ai.paas.ipaas.user.service.IOrderSv;
import com.ai.paas.ipaas.user.service.IUserSv;
import com.ai.paas.ipaas.user.service.ProdQuotaSv;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Transactional
public class ProdQuotaApiImpl implements ProdQuotaApi {
	
	private static final Log logger = LogFactory.getLog(ProdQuotaApiImpl.class);
	@Autowired
	private IUserSv iUserSv;  //UserCenter  getUserInfo(String userId) throws PaasException;//获取用户信息 // UserCenter  getUserInfoByEmail(String email) throws PaasException;//获取用户信息
	@Autowired
	private ProdQuotaSv prodQuotaSv;
	@Autowired
	private IOrderSv orderDetailSv;
	@Autowired
	private IOaSv iOaSv;
	

	
	
	@Override
	public String prodQuotaByNt(String Nt) {

		logger.info("prodQuotaByNt入参："+Nt);
		ProdQuota prodQuota = new ProdQuota();
		try {
			String sbu2 = iOaSv.getBuiCodeByNt(Nt); 
			if(sbu2!=null  && !"999999".equals(sbu2)){
				prodQuota.setProdId(11);
				prodQuota.setUserOrgName(sbu2);
				List<ProdQuota> list = prodQuotaSv.getProdQuotaInfo(prodQuota);
				logger.info("prodQuotaSv.getProdQuotaInfo查询结果>>>："+list);
				if(list!=null && list.size()>0){
					ProdQuota ProdQuota = list.get(0);
					 JSONObject jsonww = new JSONObject(ProdQuota);
					 jsonww.put("Code", "000000");
					  logger.info("jsonww:"+jsonww.toString());
					 return jsonww.toString();
				}
				
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return "{\"Code\":\"999999\"}";
	}

	
	
	@Override
	public String prodQuotaByOrderId(String orderId) {
		logger.info("prodQuotaByOrderId入参>>>："+orderId);
		long orderIdL = Long.valueOf(orderId.trim());
		ProdQuota prodQuota = new ProdQuota();
		try {
			OrderDetail orderDetail = orderDetailSv.selectByPrimaryKey(orderIdL);
			logger.info("selectByPrimaryKey查询结果>>>："+orderDetail);
			if(orderDetail!=null && orderDetail.getUserId()!=null && !"".equals(orderDetail.getUserId())){
				
				UserCenter userCenter =iUserSv.getUserInfo(orderDetail.getUserId());
				logger.info("getUserInfo查询结果>>>："+userCenter);
				if(userCenter!=null && userCenter.getUserEmail()!=null && !"".equals(userCenter.getUserOrgName()) && !"".equals(userCenter.getUserEmail().split("@asiainfo.com")[0]) ){
				String Nt = userCenter.getUserEmail().split("@asiainfo.com")[0];//
				String sbu2 = iOaSv.getBuiCodeByNt(Nt);
				logger.info("getBuiCodeByNt查询结果sbu2>>>："+sbu2);
				   if(sbu2!=null  && !"999999".equals(sbu2)){
					   
						prodQuota.setProdId(11);
						prodQuota.setUserOrgName(sbu2);
						
						List<ProdQuota> list = prodQuotaSv.getProdQuotaInfo(prodQuota);
						if(list!=null && list.size()>0){
							ProdQuota ProdQuota = list.get(0);
							 JSONObject jsonww = new JSONObject(ProdQuota);
							  logger.info("jsonww:"+jsonww.toString());
							 return jsonww.toString();
						}
				   }
					
				}
	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	@Override
	public String updateProdQuota(ProdQuota record) {
		logger.info("updateProdQuota入参>>>："+record);
		 String res = "";
		try {
			 res =prodQuotaSv.updateProdQuota(record);
			 logger.info("updateProdQuota查询结果res>>>："+res);
		} catch (PaasException e) {
			e.printStackTrace();
		}

		return "{\"responseCode\":\""+res+"\"}";
	}
		
}
