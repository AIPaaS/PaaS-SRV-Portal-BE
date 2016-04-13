package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.UserCenter;
import com.ai.paas.ipaas.user.dto.UserCenterCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.UserVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserCenterMapper {
    int countByExample(UserCenterCriteria example);

    int deleteByExample(UserCenterCriteria example);

    int deleteByPrimaryKey(String userId);

    int insert(UserCenter record);

    int insertSelective(UserCenter record);

    List<UserCenter> selectByExample(UserCenterCriteria example);

    UserCenter selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserCenter record, @Param("example") UserCenterCriteria example);

    int updateByExample(@Param("record") UserCenter record, @Param("example") UserCenterCriteria example);

    int updateByPrimaryKeySelective(UserCenter record);

    int updateByPrimaryKey(UserCenter record);
}