package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.OrderWo;
import com.ai.paas.ipaas.user.dto.OrderWoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderWoMapper {
    int countByExample(OrderWoCriteria example);

    int deleteByExample(OrderWoCriteria example);

    int deleteByPrimaryKey(Long orderWoId);

    int insert(OrderWo record);

    int insertSelective(OrderWo record);

    List<OrderWo> selectByExample(OrderWoCriteria example);

    OrderWo selectByPrimaryKey(Long orderWoId);

    int updateByExampleSelective(@Param("record") OrderWo record, @Param("example") OrderWoCriteria example);

    int updateByExample(@Param("record") OrderWo record, @Param("example") OrderWoCriteria example);

    int updateByPrimaryKeySelective(OrderWo record);

    int updateByPrimaryKey(OrderWo record);
}