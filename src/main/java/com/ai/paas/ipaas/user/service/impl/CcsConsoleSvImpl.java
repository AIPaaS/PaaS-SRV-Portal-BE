package com.ai.paas.ipaas.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.RestfullReq;
import com.ai.paas.ipaas.user.dto.RestfullReturn;
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.ICcsConsoleSv;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;


@Service
@Transactional 
public class CcsConsoleSvImpl implements ICcsConsoleSv {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private ISysParamSv iSysParamSv;
	
	@Autowired
	private IProdProductSv iProdProductSv;	
	
	@Override
	public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo)
			throws PaasException {
		UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
		UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();		
		criteria.andUserIdEqualTo(vo.getUserId()).andUserProdBynameEqualTo("CCS");
		criteria.andUserServRunStateNotEqualTo(Constants.UserProdInst.UserServRunState.CANCEL);
		
		UserProdInstCriteria.Criteria criteria2 = userProdInstCriteria.createCriteria();		
		criteria2.andUserIdEqualTo(vo.getUserId());
		criteria2.andUserProdBynameEqualTo("CCS");
		criteria2.andUserServRunStateIsNull();		
		userProdInstCriteria.or(criteria2);		
		
		UserProdInstMapper UserProdInstMapper = template.getMapper(UserProdInstMapper.class);
		List<UserProdInst> userProdInsts = UserProdInstMapper.selectByExample(userProdInstCriteria);
		List<UserProdInstVo> userProdInstVoist = new ArrayList<UserProdInstVo>();
		if (userProdInsts != null && userProdInsts.size() > 0) {
			for (int i = 0; i < userProdInsts.size(); i++) {
				UserProdInstVo userProdInstVo = new UserProdInstVo();
				BeanUtils.copyProperties(userProdInsts.get(i), userProdInstVo);
				userProdInstVoist.add(userProdInstVo);
			}
		}
		return userProdInstVoist;
	}
	
	@Override
	public String cancleUserProdInst(UserProdInstVo vo) throws PaasException {
		long userServId = vo.getUserServId();
		UserProdInstMapper userProdInstMapper = template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst = userProdInstMapper.selectByPrimaryKey(userServId);
		if (null == userProdInst) {
			throw new PaasException("用户产品实例不存在");
		}
		String prodId = userProdInst.getUserServiceId();
		if (StringUtil.isBlank(prodId)) {
			throw new PaasException("用户产品实例产品编码为空");
		}
		short priKey = Short.parseShort(prodId);
		ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);		
		
//		String address = CacheUtils.getValueByKey("PASS.SERVICE")+ prodProduct.getProdCancleRestfull(); // 获取注销restful
		String address=SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdCancleRestfull();

		if (StringUtil.isBlank(address)) {
			throw new PaasException("产品的的服务地址为空");
		}
		RestfullReq restfullReq = new RestfullReq();
		restfullReq.setUserId(vo.getUserId());
		restfullReq.setServiceId(userProdInst.getUserServIpaasId());
		restfullReq.setApplyType("cancel");
		String param = JSonUtil.toJSon(restfullReq);
		
		String result = HttpClientUtil.send(address, param);
		if (StringUtil.isBlank(result)) {
			throw new PaasException("服务异常");
		}
		RestfullReturn restfullReturn = JSonUtil.fromJSon(result, RestfullReturn.class);
		String resultCode = restfullReturn.getResultCode();
		// 修改用户产品实例
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)){
			userProdInst.setUserServRunState(Constants.UserProdInst.UserServRunState.CANCEL);
			userProdInstMapper.updateByPrimaryKey(userProdInst);
		}		
        return resultCode;
	}
}
