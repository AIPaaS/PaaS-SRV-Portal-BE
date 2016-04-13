package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.OrderScheme;
import com.ai.paas.ipaas.user.dto.OrderSchemeCriteria;
import com.ai.paas.ipaas.user.dto.OrderSchemeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderSchemeMapper {
    int countByExample(OrderSchemeCriteria example);

    int deleteByExample(OrderSchemeCriteria example);

    int deleteByPrimaryKey(Long schemeId);

    int insert(OrderSchemeWithBLOBs record);

    int insertSelective(OrderSchemeWithBLOBs record);

    List<OrderSchemeWithBLOBs> selectByExampleWithBLOBs(OrderSchemeCriteria example);

    List<OrderScheme> selectByExample(OrderSchemeCriteria example);

    OrderSchemeWithBLOBs selectByPrimaryKey(Long schemeId);

    int updateByExampleSelective(@Param("record") OrderSchemeWithBLOBs record, @Param("example") OrderSchemeCriteria example);

    int updateByExampleWithBLOBs(@Param("record") OrderSchemeWithBLOBs record, @Param("example") OrderSchemeCriteria example);

    int updateByExample(@Param("record") OrderScheme record, @Param("example") OrderSchemeCriteria example);

    int updateByPrimaryKeySelective(OrderSchemeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrderSchemeWithBLOBs record);

    int updateByPrimaryKey(OrderScheme record);
}