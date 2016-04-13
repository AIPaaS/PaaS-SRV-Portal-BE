package com.ai.paas.ipaas.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.user.dto.UserMessage;
import com.ai.paas.ipaas.user.dto.UserMessageCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.PageEntity;
import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.dubbo.vo.UserMessageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.UserMessageVo;
import com.ai.paas.ipaas.user.service.MessageDisplaySv;
import com.ai.paas.ipaas.user.service.dao.UserMessageMapper;
import com.ai.paas.ipaas.user.utils.PageUtils;
@Service
@Transactional 
public class MessageDisplaySvImpl  implements MessageDisplaySv{
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
    private SqlSessionTemplate template;
	@Override
	public PageResult<UserMessageVo> searchPage(UserMessageRequest request) {
        PageEntity pageEntity=request.getPageEntity();
		UserMessageCriteria userMessageCriteria=new UserMessageCriteria();
		UserMessageCriteria.Criteria criteria=userMessageCriteria.createCriteria();
		
		criteria.andUserIdEqualTo(request.getPageEntity().getParams().get("userId"));
		UserMessageMapper userMessageMapper=template.getMapper(UserMessageMapper.class);
		int totalCount=userMessageMapper.countByExample(userMessageCriteria);	
		userMessageCriteria.setLimitStart(pageEntity.getLimitStart());
		userMessageCriteria.setLimitEnd(pageEntity.getLimitEnd());
		userMessageCriteria.setOrderByClause(" USER_MSG_SEND_TIME desc");
		List<UserMessage> userMessages=userMessageMapper.selectByExample(userMessageCriteria);
		List<UserMessageVo> userMessageVos=new ArrayList<UserMessageVo>();
		 if(userMessages!=null&&userMessages.size()>0){
			for(int i=0;i<userMessages.size();i++)
			{
				UserMessageVo userMessageVo=new UserMessageVo();
					BeanUtils.copyProperties(userMessages.get(i),userMessageVo);
				userMessageVos.add(userMessageVo);
			}
		 }
		PageResult<UserMessageVo> pageResult=new PageResult<UserMessageVo>();
		pageResult.setResultList(userMessageVos);
		pageResult.setTotalPages(PageUtils.getTotalPages(totalCount, pageEntity.getPageSize()));
		pageResult.setTotalCount(totalCount);
		pageResult.setCurrentPage(pageEntity.getCurrentPage());
		return pageResult;
	}

	
}
