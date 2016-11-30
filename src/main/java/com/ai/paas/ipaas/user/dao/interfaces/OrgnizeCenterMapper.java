package com.ai.paas.ipaas.user.dao.interfaces;

import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeCenter;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeCenterCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgnizeCenterMapper {
    int countByExample(OrgnizeCenterCriteria example);

    int deleteByExample(OrgnizeCenterCriteria example);

    int deleteByPrimaryKey(Integer orgId);

    int insert(OrgnizeCenter record);

    int insertSelective(OrgnizeCenter record);

    List<OrgnizeCenter> selectByExample(OrgnizeCenterCriteria example);

    OrgnizeCenter selectByPrimaryKey(Integer orgId);

    int updateByExampleSelective(@Param("record") OrgnizeCenter record, @Param("example") OrgnizeCenterCriteria example);

    int updateByExample(@Param("record") OrgnizeCenter record, @Param("example") OrgnizeCenterCriteria example);

    int updateByPrimaryKeySelective(OrgnizeCenter record);

    int updateByPrimaryKey(OrgnizeCenter record);
}