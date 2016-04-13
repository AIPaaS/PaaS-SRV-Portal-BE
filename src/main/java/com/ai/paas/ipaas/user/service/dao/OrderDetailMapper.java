package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.OrderDetail;
import com.ai.paas.ipaas.user.dto.OrderDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    int countByExample(OrderDetailCriteria example);

    int deleteByExample(OrderDetailCriteria example);

    int deleteByPrimaryKey(Long orderDetailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExampleWithBLOBs(OrderDetailCriteria example);

    List<OrderDetail> selectByExample(OrderDetailCriteria example);

    OrderDetail selectByPrimaryKey(Long orderDetailId);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailCriteria example);

    int updateByExampleWithBLOBs(@Param("record") OrderDetail record, @Param("example") OrderDetailCriteria example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailCriteria example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKeyWithBLOBs(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}