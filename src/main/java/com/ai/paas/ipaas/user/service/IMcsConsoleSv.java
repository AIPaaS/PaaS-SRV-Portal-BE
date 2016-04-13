package com.ai.paas.ipaas.user.service;

import java.util.List;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;

public interface IMcsConsoleSv {

    public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo) throws PaasException;

    /**
     * @description 清空MCS实例所有数据
     * @param vo
     * @return
     * @throws Exception
     * @author caiyt
     */
    public ResponseHeader operatMcsServer(UserProdInstVo vo) throws Exception;

    public List<UserProdInstVo> selectMcsById(UserProdInstVo selectRequestVo) throws PaasException;

    public ResponseHeader mdyServPwd(UserProdInstVo vo) throws PaasException;
}
