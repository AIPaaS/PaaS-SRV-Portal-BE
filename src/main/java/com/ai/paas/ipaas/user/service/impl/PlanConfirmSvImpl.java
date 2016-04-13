package com.ai.paas.ipaas.user.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ai.paas.ipaas.user.dto.OrderSchemeCriteria;
import com.ai.paas.ipaas.user.dto.OrderSchemeWithBLOBs;
import com.ai.paas.ipaas.user.dto.OrderWo;
import com.ai.paas.ipaas.user.dto.OrderWoCriteria;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.ProdProductCriteria;
import com.ai.paas.ipaas.user.dto.ProdProductCriteria.Criteria;
import com.ai.paas.ipaas.user.dubbo.vo.PageEntity;
import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.dubbo.vo.PlanConfirmVo;
import com.ai.paas.ipaas.user.service.IPlanConfirmSv;
import com.ai.paas.ipaas.user.service.dao.OrderAttributeMapper;
import com.ai.paas.ipaas.user.service.dao.OrderDetailMapper;
import com.ai.paas.ipaas.user.service.dao.OrderSchemeMapper;
import com.ai.paas.ipaas.user.service.dao.OrderWoMapper;
import com.ai.paas.ipaas.user.service.dao.ProdProductMapper;
import com.ai.paas.ipaas.user.utils.PageUtils;
import com.ai.paas.ipaas.util.JSonUtil;
 

@Service
public class PlanConfirmSvImpl implements IPlanConfirmSv {
	private static final Logger logger = LogManager.getLogger(PlanConfirmSvImpl.class
            .getName());
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public PageResult<PlanConfirmVo> selectPlanConfirm(PageEntity pageEntity)throws SQLException{
		 
		ProdProductCriteria prodProductCriteria=new ProdProductCriteria();
		Criteria prodCriteria=prodProductCriteria.createCriteria();
		
		OrderDetailCriteria orderDetailCriteria=new OrderDetailCriteria();
		com.ai.paas.ipaas.user.dto.OrderDetailCriteria.Criteria orderCriteria=orderDetailCriteria.createCriteria();
		
		OrderWoCriteria orderWoCriteria=new OrderWoCriteria();
		com.ai.paas.ipaas.user.dto.OrderWoCriteria.Criteria woCriteria=orderWoCriteria.createCriteria();
		
		OrderAttributeCriteria orderAttributeCriteria=new OrderAttributeCriteria();
		com.ai.paas.ipaas.user.dto.OrderAttributeCriteria.Criteria attributeCriteria=orderAttributeCriteria.createCriteria();
		
		OrderSchemeCriteria orderSchemeCriteria=new OrderSchemeCriteria();
		com.ai.paas.ipaas.user.dto.OrderSchemeCriteria.Criteria schemeCriteria=orderSchemeCriteria.createCriteria();
		
		Map<String, String> request=new HashMap<String, String>();
		request=pageEntity.getParams();
		woCriteria.andOperateIdEqualTo(request.get("operateId"));
		woCriteria.andWoStatusEqualTo("0");//工单状态为待处理
		OrderWoMapper orderWoMapper=template.getMapper(OrderWoMapper.class);
		List<OrderWo> orderWolist=orderWoMapper.selectByExample(orderWoCriteria);
		if(orderWolist==null||orderWolist.size()==0)
		{
			throw new SQLException("查询工单失败");
		}
		
		List<Long> orderDetailIdlist=new ArrayList<Long>();
		for(int i=0;i<orderWolist.size();i++)
		{
			orderDetailIdlist.add(orderWolist.get(i).getOrderDetailId());
		}
		orderCriteria.andOrderDetailIdIn(orderDetailIdlist);
		orderCriteria.andOrderStatusEqualTo("7");
		orderDetailCriteria.setOrderByClause("ORDER_APP_DATE desc");
		OrderDetailMapper detailMapper=template.getMapper(OrderDetailMapper.class);
		int totalCount=detailMapper.countByExample(orderDetailCriteria);
		
		orderDetailCriteria.setLimitStart(pageEntity.getLimitStart());
		orderDetailCriteria.setLimitEnd(pageEntity.getLimitEnd());
		
		
		List<OrderDetail> orderDetaillist=detailMapper.selectByExample(orderDetailCriteria);
		if(orderDetaillist==null||orderDetaillist.size()==0)
		{
			throw new SQLException("查询申请单失败");
		}
		
		List<Long> detailIdlist=new ArrayList<Long>();
		List<String> prodbyNameList=new ArrayList<String>();
		for(int i=0;i<orderDetaillist.size();i++)
		{
			detailIdlist.add(orderDetaillist.get(i).getOrderDetailId());
			prodbyNameList.add(orderDetaillist.get(i).getProdByname());
		}
		
		prodCriteria.andProdEnSimpIn(prodbyNameList);
		
		ProdProductMapper prodProductMapper=template.getMapper(ProdProductMapper.class);
		List<ProdProduct> productslist=prodProductMapper.selectByExample(prodProductCriteria);
		
		
		attributeCriteria.andOrderDetailIdIn(detailIdlist);
		OrderAttributeMapper orderAttributeMapper=template.getMapper(OrderAttributeMapper.class);
		List<OrderAttribute> orderAttributeslist=orderAttributeMapper.selectByExample(orderAttributeCriteria);
		
		schemeCriteria.andOrderDetailIdIn(detailIdlist);
		schemeCriteria.andValidFlagEqualTo("0");//有效的集成方案
		OrderSchemeMapper orderSchemeMapper=template.getMapper(OrderSchemeMapper.class);
		List<OrderSchemeWithBLOBs> orderSchemelist=orderSchemeMapper.selectByExampleWithBLOBs(orderSchemeCriteria);
		if(orderSchemelist.size()==0||orderSchemelist==null)
		{
			throw new SQLException("未查询到有效的集成方案");
		}
		List<PlanConfirmVo> confirmVolist=new ArrayList<PlanConfirmVo>();
		for(int i=0;i<orderDetaillist.size();i++)
		{
			PlanConfirmVo confirmVo=new PlanConfirmVo();
			BeanUtils.copyProperties(orderDetaillist.get(i),confirmVo);
			confirmVolist.add(confirmVo);
		}
		for(int i=0;i<confirmVolist.size();i++)
		{
			for(int j=0;j<productslist.size();j++)
			{
				if(confirmVolist.get(i).getProdByname().equals(productslist.get(j).getProdEnSimp()))
				{
					confirmVolist.get(i).setProdName((productslist.get(j).getProdName()));
				}
			}
		}
		for(int i=0;i<confirmVolist.size();i++)
		{
			for(int j=0;j<orderAttributeslist.size();j++)
			{ 
				if(confirmVolist.get(i).getOrderDetailId().equals(orderAttributeslist.get(j).getOrderDetailId())){
					confirmVolist.get(i).setCostCenterCode(orderAttributeslist.get(j).getCostCenterCode());
					confirmVolist.get(i).setCostCenterName(orderAttributeslist.get(j).getCostCenterName());
					confirmVolist.get(i).setUserMaxNumbers(orderAttributeslist.get(j).getUserMaxNumbers());
					confirmVolist.get(i).setConcurrentNumbers(orderAttributeslist.get(j).getConcurrentNumbers());
					confirmVolist.get(i).setApplyType(orderAttributeslist.get(j).getApplyType());
					confirmVolist.get(i).setUseType(orderAttributeslist.get(j).getUseType());
					confirmVolist.get(i).setApplyDesc(orderAttributeslist.get(j).getApplyDesc());
				}
			}
		}
		for(int i=0;i<confirmVolist.size();i++)
		{
			for(int j=0;j<orderSchemelist.size();j++)
			{ 
				if(confirmVolist.get(i).getOrderDetailId().equals(orderSchemelist.get(j).getOrderDetailId())){
					confirmVolist.get(i).setProdParam(orderSchemelist.get(j).getProdParam());
					confirmVolist.get(i).setProdParamZh(orderSchemelist.get(j).getProdParamZh());
					confirmVolist.get(i).setValidFlag(orderSchemelist.get(j).getValidFlag());
					confirmVolist.get(i).setSchemeMaker(orderSchemelist.get(j).getSchemeMaker());
					confirmVolist.get(i).setSchemeMakeTime(orderSchemelist.get(j).getSchemeMakeTime());
				}
			}
		}
		
		PageResult<PlanConfirmVo> result=new PageResult<PlanConfirmVo>();
		result.setResultList(confirmVolist);
	    result.setCurrentPage(pageEntity.getCurrentPage());
	    result.setTotalPages(PageUtils.getTotalPages(totalCount, pageEntity.getPageSize()));
	    logger.info("plan confirm result:"+JSonUtil.toJSon(result).toString());
				
		return result;
	}

}
