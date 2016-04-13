package com.ai.paas.ipaas.user.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.paas.ipaas.user.dto.UserMessage;
import com.ai.paas.ipaas.user.dto.UserMessageCriteria;

public interface UserMessageMapper {
    int countByExample(UserMessageCriteria example);

    int deleteByExample(UserMessageCriteria example);

    int deleteByPrimaryKey(Integer userMsgId);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    List<UserMessage> selectByExample(UserMessageCriteria example);

    UserMessage selectByPrimaryKey(Integer userMsgId);

    int updateByExampleSelective(@Param("record") UserMessage record, @Param("example") UserMessageCriteria example);

    int updateByExample(@Param("record") UserMessage record, @Param("example") UserMessageCriteria example);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
}