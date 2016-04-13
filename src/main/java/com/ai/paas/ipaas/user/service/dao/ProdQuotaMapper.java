package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.ProdQuota;
import com.ai.paas.ipaas.user.dto.ProdQuotaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdQuotaMapper {
    int countByExample(ProdQuotaCriteria example);

    int deleteByExample(ProdQuotaCriteria example);

    int insert(ProdQuota record);

    int insertSelective(ProdQuota record);

    List<ProdQuota> selectByExample(ProdQuotaCriteria example);

    int updateByExampleSelective(@Param("record") ProdQuota record, @Param("example") ProdQuotaCriteria example);

    int updateByExample(@Param("record") ProdQuota record, @Param("example") ProdQuotaCriteria example);
}