package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.SysConfigRel;
import com.ai.paas.ipaas.user.dto.SysConfigRelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConfigRelMapper {
    int countByExample(SysConfigRelCriteria example);

    int deleteByExample(SysConfigRelCriteria example);

    int deleteByPrimaryKey(Short sysConfigRelId);

    int insert(SysConfigRel record);

    int insertSelective(SysConfigRel record);

    List<SysConfigRel> selectByExample(SysConfigRelCriteria example);

    SysConfigRel selectByPrimaryKey(Short sysConfigRelId);

    int updateByExampleSelective(@Param("record") SysConfigRel record, @Param("example") SysConfigRelCriteria example);

    int updateByExample(@Param("record") SysConfigRel record, @Param("example") SysConfigRelCriteria example);

    int updateByPrimaryKeySelective(SysConfigRel record);

    int updateByPrimaryKey(SysConfigRel record);
}