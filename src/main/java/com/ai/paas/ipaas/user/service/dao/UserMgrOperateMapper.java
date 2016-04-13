package com.ai.paas.ipaas.user.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.paas.ipaas.user.dto.UserMgrOperate;
import com.ai.paas.ipaas.user.dto.UserMgrOperateCriteria;

public interface UserMgrOperateMapper {
    int countByExample(UserMgrOperateCriteria example);

    int deleteByExample(UserMgrOperateCriteria example);

    int deleteByPrimaryKey(Long userOperateId);

    int insert(UserMgrOperate record);

    int insertSelective(UserMgrOperate record);

    List<UserMgrOperate> selectByExample(UserMgrOperateCriteria example);

    UserMgrOperate selectByPrimaryKey(Long userOperateId);

    int updateByExampleSelective(@Param("record") UserMgrOperate record, @Param("example") UserMgrOperateCriteria example);

    int updateByExample(@Param("record") UserMgrOperate record, @Param("example") UserMgrOperateCriteria example);

    int updateByPrimaryKeySelective(UserMgrOperate record);

    int updateByPrimaryKey(UserMgrOperate record);
}