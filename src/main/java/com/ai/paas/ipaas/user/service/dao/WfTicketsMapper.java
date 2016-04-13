package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.WfTickets;
import com.ai.paas.ipaas.user.dto.WfTicketsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfTicketsMapper {
    int countByExample(WfTicketsCriteria example);

    int deleteByExample(WfTicketsCriteria example);

    int deleteByPrimaryKey(Long wfTicketsId);

    int insert(WfTickets record);

    int insertSelective(WfTickets record);

    List<WfTickets> selectByExample(WfTicketsCriteria example);

    WfTickets selectByPrimaryKey(Long wfTicketsId);

    int updateByExampleSelective(@Param("record") WfTickets record, @Param("example") WfTicketsCriteria example);

    int updateByExample(@Param("record") WfTickets record, @Param("example") WfTicketsCriteria example);

    int updateByPrimaryKeySelective(WfTickets record);

    int updateByPrimaryKey(WfTickets record);
}