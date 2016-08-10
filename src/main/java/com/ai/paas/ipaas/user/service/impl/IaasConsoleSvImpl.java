package com.ai.paas.ipaas.user.service.impl;

import java.util.ArrayList;
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

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IIaasConsoleSv;
import com.ai.paas.ipaas.user.service.IMcsConsoleSv;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.google.gson.Gson;

@Service
@Transactional 
public class IaasConsoleSvImpl implements IIaasConsoleSv{
	
	private final Log logger = LogFactory.getLog(IaasConsoleSvImpl.class);
	@Autowired
	private SqlSessionTemplate template;
	@Autowired
	private IProdProductSv iProdProductSv;	

	@Override
	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)
			throws PaasException {
		UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
		UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();
		criteria.andUserIdEqualTo(vo.getUserId());
		criteria.andUserServiceIdEqualTo(vo.getUserServiceId());
		if(vo.getUserServId()!=null){
			criteria.andUserServiceIdEqualTo(vo.getUserServId().toString());
		}
		criteria.andUserServRunStateNotEqualTo(Constants.UserProdInst.UserServRunState.CANCEL);
		
		
		UserProdInstCriteria.Criteria criteria2 = userProdInstCriteria.createCriteria();		
		criteria2.andUserIdEqualTo(vo.getUserId());
		criteria2.andUserServiceIdEqualTo(vo.getUserServiceId());
		criteria2.andUserServRunStateIsNull();		
		userProdInstCriteria.or(criteria2);
		
		userProdInstCriteria.setOrderByClause(" USER_SERV_OPEN_TIME desc");
		UserProdInstMapper UserProdInstMapper = template.getMapper(UserProdInstMapper.class);
		List<UserProdInst> userProdInsts = UserProdInstMapper.selectByExample(userProdInstCriteria);
		List<UserProdInstVo> userProdInstVoist = new ArrayList<UserProdInstVo>();
		if (userProdInsts != null && userProdInsts.size() > 0) {
			for (int i = 0; i < userProdInsts.size(); i++) {
				
				UserProdInst userProdInst = userProdInsts.get(i);
				String jsonStr = userProdInst.getUserServParam();
				Map<String,String> userServParamMap  = new HashMap<String,String>();
				userServParamMap = new Gson().fromJson(jsonStr, userServParamMap.getClass());
				Map<String,Object> userServBackParam  = new HashMap<String,Object>();
				userServBackParam = new Gson().fromJson(userProdInst.getUserServBackParam(), userServBackParam.getClass());
				UserProdInstVo userProdInstVo = new UserProdInstVo();
				BeanUtils.copyProperties(userProdInsts.get(i), userProdInstVo);
				userProdInstVo.setUserServParamMap(userServParamMap);
				userProdInstVo.setUserServBackParamMap(userServBackParam);
				userProdInstVoist.add(userProdInstVo);
			}
		}
		return userProdInstVoist;
	}

}
