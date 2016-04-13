package com.ai.paas.ipaas.user.dubbo.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.cache.CacheUtils;
import com.ai.paas.ipaas.user.dto.OrderWo;
import com.ai.paas.ipaas.user.dto.OrderWoCriteria;
import com.ai.paas.ipaas.user.dubbo.interfaces.IIaasApplyWfReverseSV;
import com.ai.paas.ipaas.user.dubbo.vo.ReverseVariablesVo;
import com.ai.paas.ipaas.user.dubbo.vo.VariablesVo;
import com.ai.paas.ipaas.user.service.IIaasApplyWfReverseServiceSV;
import com.ai.paas.ipaas.user.service.dao.OrderWoMapper;
import com.ai.paas.ipaas.user.utils.HttpRequestUtil;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class IaasApplyWfReverseSVImpl implements IIaasApplyWfReverseSV {
    private static final Logger log = LogManager
            .getLogger(IaasApplyWfReverseSVImpl.class.getName());
    @Autowired
    private SqlSessionTemplate template;
    @Autowired
    private IIaasApplyWfReverseServiceSV iIaasApplyWfReverseServiceSV;

	public String processStartNotify(String params) throws Exception {
        log.info("iaas apply process start notify -> receive params:" + params);
        params = URLDecoder.decode(params, "UTF-8");
        log.info("iaas apply process start notify -> params after decoding:" + params);
        ReverseVariablesVo reverseVo = JsonUtils.fromJSon(params, ReverseVariablesVo.class);
        String resStr = iIaasApplyWfReverseServiceSV.processStartNotify(reverseVo);
        
        log.info("iaas apply process start notify -> response contents is :" + resStr);
        return resStr;
    }

    public String taskDispatch(String params) throws Exception {
        log.info("iaas apply process deal dispatch -> receive params:" + params);
        params = URLDecoder.decode(params, "UTF-8");
        log.info("iaas apply process deal dispatch -> params after decoding:" + params);
        ReverseVariablesVo reverseVo = JsonUtils.fromJSon(params, ReverseVariablesVo.class);
        String resStr = iIaasApplyWfReverseServiceSV.taskDispatch(reverseVo);
        
        log.info("iaas apply process deal dispatch -> response contents is :" + resStr);
        return resStr;
    }

    public String troubleCompleteDispatch(String params) throws Exception {
        log.info("iaas apply process complete dispatch -> receive params:" + params);
        params = URLDecoder.decode(params, "UTF-8");
        log.info("iaas apply process complete dispatch -> params after decoding:" + params);
        ReverseVariablesVo reverseVo = JsonUtils.fromJSon(params, ReverseVariablesVo.class);
        String resStr = iIaasApplyWfReverseServiceSV.troubleCompleteDispatch(reverseVo);
        log.info("iaas apply process complete dispatch -> response contents is :" + resStr);
        return resStr;
    }
    
/**
 * 
 * @description 根据工作流返回的变量数组获取相关的参数
 * @return
 * @author caiyt
 */
public VariablesVo getVariableFromReverseVo(ReverseVariablesVo reverseVo) {
    VariablesVo variable = new VariablesVo();
    for (VariablesVo vo : reverseVo.getVariables()) {
        if (vo.getUserId() != null && !vo.getUserId().trim().equals("")) {
            variable.setUserId(vo.getUserId());
            continue;
        }
        if (vo.getApplyId() != null && !vo.getApplyId().trim().equals("")) {
            variable.setApplyId(vo.getApplyId());
            continue;
        }
        if (vo.getWoResult() != null && !vo.getWoResult().trim().equals("")) {
            variable.setWoResult(vo.getWoResult());
            continue;
        }
        if (vo.getWoDesc() != null && !vo.getWoDesc().trim().equals("")) {
            variable.setWoDesc(vo.getWoDesc());
            continue;
        }
        if (vo.getOrderWoId() != null && !vo.getOrderWoId().trim().equals("")) {
            variable.setOrderWoId(vo.getOrderWoId());
        }
        if (vo.getNtAccount() != null && !vo.getNtAccount().trim().equals("")) {
            variable.setNtAccount(vo.getNtAccount());
        }
    }
    return variable;
}
}