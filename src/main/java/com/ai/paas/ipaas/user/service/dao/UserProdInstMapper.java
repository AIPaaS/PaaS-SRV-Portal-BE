package com.ai.paas.ipaas.user.service.dao;

import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserProdInstMapper {
    int countByExample(UserProdInstCriteria example);

    int deleteByExample(UserProdInstCriteria example);

    int deleteByPrimaryKey(Long userServId);

    int insert(UserProdInst record);

    int insertSelective(UserProdInst record);

    List<UserProdInst> selectByExample(UserProdInstCriteria example);

    UserProdInst selectByPrimaryKey(Long userServId);

    int updateByExampleSelective(@Param("record") UserProdInst record, @Param("example") UserProdInstCriteria example);

    int updateByExample(@Param("record") UserProdInst record, @Param("example") UserProdInstCriteria example);

    int updateByPrimaryKeySelective(UserProdInst record);

    int updateByPrimaryKey(UserProdInst record);
}