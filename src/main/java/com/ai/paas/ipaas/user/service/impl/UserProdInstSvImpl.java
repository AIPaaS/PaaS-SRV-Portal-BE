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
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IUserProdInstSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;

@Service
@Transactional
public class UserProdInstSvImpl implements IUserProdInstSv {
    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private SqlSessionTemplate template;

    @Override
    public List<UserProdInstVo> selectUserProdInsts(Map<String, String> map) throws PaasException {
        logger.info("UserProdInstSvImpl ...selectUserProdInsts....");
        UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
        UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();
        criteria.andUserIdEqualTo(map.get("userId"));
        criteria.andUserServTypeEqualTo(map.get("servType"));
        criteria.andUserServiceIdEqualTo(Constants.ProdProduct.ProdId.OM);
        criteria.andUserServRunStateNotEqualTo(Constants.UserProdInst.UserServRunState.CANCEL);

        UserProdInstCriteria.Criteria criteria2 = userProdInstCriteria.createCriteria();
        criteria2.andUserIdEqualTo(map.get("userId"));
        criteria2.andUserServTypeEqualTo(map.get("servType"));
        criteria2.andUserServiceIdEqualTo(Constants.ProdProduct.ProdId.OM);
        criteria2.andUserServRunStateIsNull();
        userProdInstCriteria.or(criteria2);

        userProdInstCriteria.setOrderByClause(" USER_SERV_OPEN_TIME desc");
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
	public UserProdInst selectUserProdInstsById(Long userServId) {
	 
		UserProdInstMapper userProdInstMapper=template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst=userProdInstMapper.selectByPrimaryKey(userServId);
		 
		return userProdInst;
	}

	@Override
	public int updateUserprodInstById(UserProdInst userProdInst) {
		UserProdInstMapper userProdInstMapper=template.getMapper(UserProdInstMapper.class);
		int result=userProdInstMapper.updateByPrimaryKey(userProdInst);
		return result;
	}
	
	
}