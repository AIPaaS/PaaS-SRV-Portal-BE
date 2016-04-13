package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.OaOperaters;
import com.ai.paas.ipaas.user.dto.OaOperatersCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaOperatersMapper {
    int countByExample(OaOperatersCriteria example);

    int deleteByExample(OaOperatersCriteria example);

    int deleteByPrimaryKey(Short oaId);

    int insert(OaOperaters record);

    int insertSelective(OaOperaters record);

    List<OaOperaters> selectByExample(OaOperatersCriteria example);

    OaOperaters selectByPrimaryKey(Short oaId);

    int updateByExampleSelective(@Param("record") OaOperaters record, @Param("example") OaOperatersCriteria example);

    int updateByExample(@Param("record") OaOperaters record, @Param("example") OaOperatersCriteria example);

    int updateByPrimaryKeySelective(OaOperaters record);

    int updateByPrimaryKey(OaOperaters record);
}