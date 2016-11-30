package com.ai.paas.ipaas.user.dao.interfaces;

import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeUserInfoCriteria;
import com.ai.paas.ipaas.user.dao.mapper.bo.OrgnizeUserInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgnizeUserInfoMapper {
    int countByExample(OrgnizeUserInfoCriteria example);

    int deleteByExample(OrgnizeUserInfoCriteria example);

    int deleteByPrimaryKey(OrgnizeUserInfoKey key);

    int insert(OrgnizeUserInfoKey record);

    int insertSelective(OrgnizeUserInfoKey record);

    List<OrgnizeUserInfoKey> selectByExample(OrgnizeUserInfoCriteria example);

    int updateByExampleSelective(@Param("record") OrgnizeUserInfoKey record, @Param("example") OrgnizeUserInfoCriteria example);

    int updateByExample(@Param("record") OrgnizeUserInfoKey record, @Param("example") OrgnizeUserInfoCriteria example);
}