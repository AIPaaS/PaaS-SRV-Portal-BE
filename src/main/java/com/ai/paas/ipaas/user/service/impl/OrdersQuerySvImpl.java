package com.ai.paas.ipaas.user.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.paas.ipaas.user.dto.OrderAttribute;
import com.ai.paas.ipaas.user.dto.OrderAttributeCriteria;
import com.ai.paas.ipaas.user.dto.OrderDetail;
import com.ai.paas.ipaas.user.dto.OrderDetailCriteria;
import com.ai.paas.ipaas.user.dto.OrderDetailCriteria.Criteria;
import com.ai.paas.ipaas.user.dto.OrderSchemeCriteria;
import com.ai.paas.ipaas.user.dto.OrderSchemeWithBLOBs;
import com.ai.paas.ipaas.user.dto.OrderWo;
import com.ai.paas.ipaas.user.dto.OrderWoCriteria;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.ProdProductCriteria;
import com.ai.paas.ipaas.user.service.IOrdersQuerySv;
import com.ai.paas.ipaas.user.service.dao.OrderAttributeMapper;
import com.ai.paas.ipaas.user.service.dao.OrderDetailMapper;
import com.ai.paas.ipaas.user.service.dao.OrderSchemeMapper;
import com.ai.paas.ipaas.user.service.dao.OrderWoMapper;
import com.ai.paas.ipaas.user.service.dao.ProdProductMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.user.vo.OrdersForm;
import com.ai.paas.ipaas.user.vo.OrdersVo;
import com.ai.paas.ipaas.user.vo.PageEntity;
import com.ai.paas.ipaas.util.JSonUtil;
/**
 * 订单查询
 * @author renfeng
 *
 */
@Service
public class OrdersQuerySvImpl implements IOrdersQuerySv {
	private static final Logger logger = LogManager.getLogger(OrdersQuerySvImpl.class
            .getName());
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public String queryOrders(OrdersForm orderform) throws SQLException {
		
		OrderDetailCriteria orderDetailCriteria = new OrderDetailCriteria();
		Criteria orderDetailCreateCriteria = orderDetailCriteria.createCriteria();
		
		OrderAttributeCriteria orderAttributeCriteria = new OrderAttributeCriteria();
		com.ai.paas.ipaas.user.dto.OrderAttributeCriteria.Criteria 
		orderAttributeCreateCriteria = orderAttributeCriteria.createCriteria();
		
		OrderSchemeCriteria orderSchemeCriteria = new OrderSchemeCriteria();
		com.ai.paas.ipaas.user.dto.OrderSchemeCriteria.Criteria orderSchemeCreateCriteria 
		= orderSchemeCriteria.createCriteria();
		
		ProdProductCriteria prodProductCriteria = new ProdProductCriteria();
		com.ai.paas.ipaas.user.dto.ProdProductCriteria.Criteria 
		prodProductCreateCriteria = prodProductCriteria.createCriteria();
		
		OrderWoCriteria orderWoCriteria = new OrderWoCriteria();
		com.ai.paas.ipaas.user.dto.OrderWoCriteria.Criteria 
		orderWocreateCriteria = orderWoCriteria.createCriteria();
		List<OrderWo> orderWoList =null;
		if(orderform.getOrderDetailId()!=null && !"".equals(orderform.getOrderDetailId())){
			orderDetailCreateCriteria.andOrderDetailIdEqualTo(Long.parseLong(orderform.getOrderDetailId()));
		}else{
			if(orderform.getOperateId()!=null && !"".equals(orderform.getOperateId())){
				orderWocreateCriteria.andOperateIdLike(orderform.getOperateId());
			}
			orderWocreateCriteria.andWoStatusEqualTo("0");//0-待处理
			OrderWoMapper orderWoMapper = template.getMapper(OrderWoMapper.class);
			orderWoList = orderWoMapper.selectByExample(orderWoCriteria);
			
			List<Long> orderDetailIdList1= new ArrayList<Long>();
			
			if(orderWoList!=null && orderWoList.size()>0){
				for(OrderWo orderwo:orderWoList){
					orderDetailIdList1.add(orderwo.getOrderDetailId());
				}
			}else{
				return "";
			}
			orderDetailCreateCriteria.andOrderDetailIdIn(orderDetailIdList1);
			
			if(orderform.getLimitStart()>=0 && orderform.getLimitEnd()!=0){
				orderDetailCriteria.setLimitStart(orderform.getLimitStart());
				orderDetailCriteria.setLimitEnd(orderform.getLimitEnd());
			}
			if(orderform.getAppDateStart()!=null &&!"".equals(orderform.getAppDateStart())){
				orderDetailCreateCriteria.andOrderAppDateGreaterThanOrEqualTo(
						DateUtil.strToTimestampByPattern(orderform.getAppDateStart(),"yyyy-MM-dd"));
			}
			if(orderform.getAppDateEnd()!=null &&!"".equals(orderform.getAppDateEnd())){
				orderDetailCreateCriteria.andOrderAppDateLessThanOrEqualTo(
						DateUtil.strToTimestampByPattern(orderform.getAppDateEnd(),"yyyy-MM-dd"));
			}
			if(orderform.getApplicant()!=null &&!"".equals(orderform.getApplicant())){
				orderDetailCreateCriteria.andApplicantLike(orderform.getApplicant());
			}
			if(orderform.getApplicantDept()!=null &&!"".equals(orderform.getApplicantDept())){
				orderDetailCreateCriteria.andApplicantDeptLike(orderform.getApplicantDept());
			}
			if(orderform.getBelongCloud()!=null &&!"".equals(orderform.getBelongCloud())){
				orderDetailCreateCriteria.andBelongCloudEqualTo(orderform.getBelongCloud());
			}
			if(orderform.getApplicantTel()!=null &&!"".equals(orderform.getApplicantTel())){
				orderDetailCreateCriteria.andApplicantTelLike(orderform.getApplicantTel());
			}
			if(orderform.getUserId()!=null &&!"".equals(orderform.getUserId())){
				orderDetailCreateCriteria.andUserIdEqualTo(orderform.getUserId());
			}
			if(orderform.getOrderStatus()!=null &&!"".equals(orderform.getOrderStatus())){
				String[] split = orderform.getOrderStatus().split(",");
				List<String> orderStatusList = new ArrayList<String>();
				for(String orderStatus: split){
					orderStatusList.add(orderStatus);
				}
				orderDetailCreateCriteria.andOrderStatusIn(orderStatusList);
			}
			if(orderform.getSortFlag()!=null &&!"".equals(orderform.getSortFlag())){
				if("1".equals(orderform.getSortFlag())){
					orderDetailCriteria.setOrderByClause("ORDER_APP_DATE desc");
				}else{
					orderDetailCriteria.setOrderByClause("ORDER_APP_DATE");
				}
			}else{
				orderDetailCriteria.setOrderByClause("ORDER_APP_DATE desc");
			}
		}
		OrderDetailMapper orderDetailMapper = template.getMapper(OrderDetailMapper.class);
		List<OrderDetail> orderDetailList = orderDetailMapper.selectByExampleWithBLOBs(orderDetailCriteria);
		
		List<Long> orderDetailIdList = new ArrayList<Long>();
		List<String> prodEnSimpList =new ArrayList<String>();
		if(orderDetailList!=null && orderDetailList.size()>0){
			for(OrderDetail orderDetail: orderDetailList){
				prodEnSimpList.add(orderDetail.getProdByname());
				orderDetailIdList.add(orderDetail.getOrderDetailId());
			}
		}else{
			return "";
		}
		orderAttributeCreateCriteria.andOrderDetailIdIn(orderDetailIdList);
		if(orderform.getApplyDesc()!=null &&!"".equals(orderform.getApplyDesc())){
			orderAttributeCreateCriteria.andApplyDescLike(orderform.getApplyDesc());
		}
		OrderAttributeMapper orderAttributeMapper = template.getMapper(OrderAttributeMapper.class);
		List<OrderAttribute> orderAttributeList = orderAttributeMapper.selectByExample(orderAttributeCriteria);
		
		
		
		int selectCount=0;
		List<OrdersVo> ordersList = new ArrayList<OrdersVo>(); 
		if(orderform.getApplyDesc()!=null &&!"".equals(orderform.getApplyDesc())){
			if(orderAttributeList!=null&&orderAttributeList.size()>0){
				orderAttributeCriteria.setLimitStart(null);
				orderAttributeCriteria.setLimitEnd(null);
				selectCount = orderAttributeMapper.countByExample(orderAttributeCriteria);
				for(OrderAttribute orderAttribute: orderAttributeList){
					for(OrderDetail orderDetail:orderDetailList){
						if(orderAttribute.getOrderDetailId().longValue()==orderDetail.getOrderDetailId().longValue()){
							OrdersVo ordersVo= new OrdersVo();
							BeanUtils.copyProperties(orderDetail, ordersVo);
							BeanUtils.copyProperties(orderAttribute, ordersVo);
							ordersList.add(ordersVo);
						}
					}
				}
			}else{
				return "";
			}
		}else{
			orderDetailCriteria.setLimitStart(null);
			orderDetailCriteria.setLimitEnd(null);
			selectCount= orderDetailMapper.countByExample(orderDetailCriteria);
			for(OrderDetail orderDetail:orderDetailList){
				for(OrderAttribute orderAttribute: orderAttributeList){
					if(orderAttribute.getOrderDetailId().longValue()==orderDetail.getOrderDetailId().longValue()){
						OrdersVo ordersVo= new OrdersVo();
						BeanUtils.copyProperties(orderDetail, ordersVo);
						BeanUtils.copyProperties(orderAttribute, ordersVo);
						ordersList.add(ordersVo);
					}
				}
			}
		}
		if(orderform.getOrderDetailId()==null || "".equals(orderform.getOrderDetailId())){
			for(int i=0;i<ordersList.size();i++){
				for(OrderWo orderWo : orderWoList){
					if(ordersList.get(i).getOrderDetailId().longValue()==orderWo.getOrderDetailId().longValue()){
						ordersList.get(i).setOrderWoId(orderWo.getOrderWoId());
						ordersList.get(i).setReceiptUrl(orderWo.getReceiptUrl());
					}
				}
			}
		}
		orderSchemeCreateCriteria.andOrderDetailIdIn(orderDetailIdList);
		orderSchemeCreateCriteria.andValidFlagEqualTo("0");
		OrderSchemeMapper orderSchemeMapper = template.getMapper(OrderSchemeMapper.class);
		List<OrderSchemeWithBLOBs> orderSchemeList = orderSchemeMapper.selectByExampleWithBLOBs(orderSchemeCriteria);
		if(orderSchemeList!=null && orderSchemeList.size()>0){
			for(int i=0;i<ordersList.size();i++){
				for(OrderSchemeWithBLOBs orderScheme :orderSchemeList){
					if(ordersList.get(i).getOrderDetailId().longValue()==orderScheme.getOrderDetailId().longValue()){
						ordersList.get(i).setProdParamZh(orderScheme.getProdParamZh());
						ordersList.get(i).setProdParam(orderScheme.getProdParam());
					}
				}
			}
		}
		prodProductCreateCriteria.andProdEnSimpIn(prodEnSimpList);
		ProdProductMapper prodProductMapper = template.getMapper(ProdProductMapper.class);
		List<ProdProduct> prodProductLlist = prodProductMapper.selectByExample(prodProductCriteria);
		if(prodProductLlist!=null && prodProductLlist.size()>0){
			for(int i=0;i<ordersList.size();i++){
				for(ProdProduct prodProduct :prodProductLlist){
					if(ordersList.get(i).getProdByname()!=null&&!"".equals(ordersList.get(i).getProdByname())&&ordersList.get(i).getProdByname().equals(prodProduct.getProdEnSimp())){
						ordersList.get(i).setProdByname(prodProduct.getProdName());
					}
				}
			}
		}
		
		PageEntity pageEntity = new PageEntity();
        BeanUtils.copyProperties(orderform, pageEntity);
        pageEntity.setTotalCount(selectCount);
        pageEntity.setList(ordersList);
        logger.info("ordersVo : query orders result=="
                + JSonUtil.toJSon(pageEntity).toString());
        
        return JsonUtils.toJsonStr(pageEntity);
		
	}
	
	

}
