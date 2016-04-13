package com.ai.paas.ipaas.user.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.paas.ipaas.user.dto.SysConfig;
import com.ai.paas.ipaas.user.dto.SysConfigCriteria;

public interface SysConfigMapper {
    int countByExample(SysConfigCriteria example);

    int deleteByExample(SysConfigCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    List<SysConfig> selectByExample(SysConfigCriteria example);

    SysConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysConfig record, @Param("example") SysConfigCriteria example);

    int updateByExample(@Param("record") SysConfig record, @Param("example") SysConfigCriteria example);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);
}