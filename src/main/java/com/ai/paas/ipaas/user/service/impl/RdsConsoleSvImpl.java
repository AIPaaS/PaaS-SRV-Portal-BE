package com.ai.paas.ipaas.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.IRdsConsoleSv;
import com.ai.paas.ipaas.user.service.IUserProdInstSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.util.StringUtil;
import com.google.gson.Gson;
@Service
@Transactional 
public class RdsConsoleSvImpl implements IRdsConsoleSv {
	private final Log logger = LogFactory.getLog(RdsConsoleSvImpl.class);
	@Autowired
	private SqlSessionTemplate template;
	@Autowired
	private IProdProductSv iProdProductSv;	
	@Autowired
	private IUserProdInstSv iUserProdInstSv;
	
	@Override
	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)
			throws PaasException {
		UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
		UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();		
		criteria.andUserIdEqualTo(vo.getUserId()).andUserProdBynameEqualTo("RDS");
		criteria.andUserServRunStateNotEqualTo(Constants.UserProdInst.UserServRunState.CANCEL);
		
		UserProdInstCriteria.Criteria criteria2 = userProdInstCriteria.createCriteria();		
		criteria2.andUserIdEqualTo(vo.getUserId());
		criteria2.andUserProdBynameEqualTo("RDS");
		criteria2.andUserServRunStateIsNull();		
		userProdInstCriteria.or(criteria2);		
		
		UserProdInstMapper UserProdInstMapper = template.getMapper(UserProdInstMapper.class);
		List<UserProdInst> userProdInsts = UserProdInstMapper.selectByExample(userProdInstCriteria);
		List<UserProdInstVo> userProdInstVoist = new ArrayList<UserProdInstVo>();
		if (userProdInsts != null && userProdInsts.size() > 0) {
			for (int i = 0; i < userProdInsts.size(); i++) {
				UserProdInstVo userProdInstVo = new UserProdInstVo();
				BeanUtils.copyProperties(userProdInsts.get(i), userProdInstVo);
				
				//获得ProName-------start
				String prodId = userProdInstVo.getUserServiceId();
				if (StringUtil.isBlank(prodId)) {
					throw new PaasException("用户产品实例产品编码为空");
				}
				short priKey = Short.parseShort(prodId);
				ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
				userProdInstVo.setProdName(prodProduct.getProdName());
				//获得ProName-------end
				
				//获得UserServParam字段中对应map的值---------start
				String prodParam = userProdInstVo.getUserServParam();
				String prodBackParam = userProdInstVo.getUserServBackParam();
				Gson gson = new Gson();
				Map<String,String> map = gson.fromJson(prodParam, Map.class);	
				Map<String,String> mapBack = gson.fromJson(prodBackParam, Map.class);	
				String serviceName = map.get("serviceName");
				if(serviceName == null){
					serviceName="";
				}
				userProdInstVo.setServiceName(serviceName);
				//获得UserServParam字段中对应map的值---------end
				userProdInstVo.setUserServParamMap(map);
				userProdInstVo.setUserServBackParamMap(mapBack);
				userProdInstVo.setUserServBackParam(prodBackParam.replaceAll("\"", ""));
				userProdInstVoist.add(userProdInstVo);
			}
		}
		return userProdInstVoist;
	}

	public ResponseHeader stopRdsContainer(String paraprodBackPara)  throws PaasException{
		ResponseHeader responseHeader = new ResponseHeader();
		return responseHeader;
	}

	public ResponseHeader startRdsContainer(String paraprodBackPara)   throws PaasException{
		ResponseHeader responseHeader = new ResponseHeader();
		return responseHeader;
	}

	
	public ResponseHeader cleanRdsContainer(String paraprodBackPara,String destroy)  throws PaasException{
		ResponseHeader responseHeader = new ResponseHeader();
		return responseHeader;
	}
	
	@Override
	public ResponseHeader destroyContainer(String paraprodBackPara) throws PaasException {
		ResponseHeader responseHeader = new ResponseHeader();
		return responseHeader;
	}
	
	//更新订单实例的状态
	public void updateUserprodInstById(String paraprodBackPara)  throws PaasException{
		String userServId = paraprodBackPara.substring(paraprodBackPara.indexOf("userServId")+11,paraprodBackPara.length()-1);;
		UserProdInst uerProdInst =iUserProdInstSv.selectUserProdInstsById(Long.valueOf(userServId));
		uerProdInst.setUserServRunState("2");
		iUserProdInstSv.updateUserprodInstById(uerProdInst);
	}
	
}
