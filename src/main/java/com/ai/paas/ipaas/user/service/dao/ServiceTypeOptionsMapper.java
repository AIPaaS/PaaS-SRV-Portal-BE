package com.ai.paas.ipaas.user.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.paas.ipaas.user.dto.ServiceTypeOptions;
import com.ai.paas.ipaas.user.dto.ServiceTypeOptionsCriteria;

public interface ServiceTypeOptionsMapper {
    int countByExample(ServiceTypeOptionsCriteria example);

    int deleteByExample(ServiceTypeOptionsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceTypeOptions record);

    int insertSelective(ServiceTypeOptions record);

    List<ServiceTypeOptions> selectByExample(ServiceTypeOptionsCriteria example);

    ServiceTypeOptions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceTypeOptions record, @Param("example") ServiceTypeOptionsCriteria example);

    int updateByExample(@Param("record") ServiceTypeOptions record, @Param("example") ServiceTypeOptionsCriteria example);

    int updateByPrimaryKeySelective(ServiceTypeOptions record);

    int updateByPrimaryKey(ServiceTypeOptions record);
}