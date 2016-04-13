package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.OrderAttribute;
import com.ai.paas.ipaas.user.dto.OrderAttributeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderAttributeMapper {
    int countByExample(OrderAttributeCriteria example);

    int deleteByExample(OrderAttributeCriteria example);

    int deleteByPrimaryKey(Long orderDetailId);

    int insert(OrderAttribute record);

    int insertSelective(OrderAttribute record);

    List<OrderAttribute> selectByExample(OrderAttributeCriteria example);

    OrderAttribute selectByPrimaryKey(Long orderDetailId);

    int updateByExampleSelective(@Param("record") OrderAttribute record, @Param("example") OrderAttributeCriteria example);

    int updateByExample(@Param("record") OrderAttribute record, @Param("example") OrderAttributeCriteria example);

    int updateByPrimaryKeySelective(OrderAttribute record);

    int updateByPrimaryKey(OrderAttribute record);
}