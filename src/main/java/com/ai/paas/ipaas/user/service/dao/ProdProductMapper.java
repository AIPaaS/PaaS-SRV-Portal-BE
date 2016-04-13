package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.ProdProductCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdProductMapper {
    int countByExample(ProdProductCriteria example);

    int deleteByExample(ProdProductCriteria example);

    int deleteByPrimaryKey(Short prodId);

    int insert(ProdProduct record);

    int insertSelective(ProdProduct record);

    List<ProdProduct> selectByExample(ProdProductCriteria example);

    ProdProduct selectByPrimaryKey(Short prodId);

    int updateByExampleSelective(@Param("record") ProdProduct record, @Param("example") ProdProductCriteria example);

    int updateByExample(@Param("record") ProdProduct record, @Param("example") ProdProductCriteria example);

    int updateByPrimaryKeySelective(ProdProduct record);

    int updateByPrimaryKey(ProdProduct record);
}