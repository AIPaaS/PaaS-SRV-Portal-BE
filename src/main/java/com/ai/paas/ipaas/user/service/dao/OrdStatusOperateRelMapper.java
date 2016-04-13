package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.OrdStatusOperateRel;
import com.ai.paas.ipaas.user.dto.OrdStatusOperateRelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdStatusOperateRelMapper {
    int countByExample(OrdStatusOperateRelCriteria example);

    int deleteByExample(OrdStatusOperateRelCriteria example);

    int deleteByPrimaryKey(Short operateRelId);

    int insert(OrdStatusOperateRel record);

    int insertSelective(OrdStatusOperateRel record);

    List<OrdStatusOperateRel> selectByExample(OrdStatusOperateRelCriteria example);

    OrdStatusOperateRel selectByPrimaryKey(Short operateRelId);

    int updateByExampleSelective(@Param("record") OrdStatusOperateRel record, @Param("example") OrdStatusOperateRelCriteria example);

    int updateByExample(@Param("record") OrdStatusOperateRel record, @Param("example") OrdStatusOperateRelCriteria example);

    int updateByPrimaryKeySelective(OrdStatusOperateRel record);

    int updateByPrimaryKey(OrdStatusOperateRel record);
}