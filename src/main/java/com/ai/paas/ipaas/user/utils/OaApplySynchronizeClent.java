package com.ai.paas.ipaas.user.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.sf.json.JSONObject;

import com.ai.paas.ipaas.cache.CacheUtils;
import com.ai.paas.ipaas.user.dto.OrderWo;
import com.ai.paas.ipaas.user.dubbo.vo.VariablesVo;
import com.ai.paas.ipaas.user.utils.gson.GsonUtil;

/**
 * OA审批申请单同步类
 * @author renfeng
 *
 */
public class OaApplySynchronizeClent {
	private static final Logger logger = LogManager.getLogger(OaApplySynchronizeClent.class
            .getName());
	public static String oaApplySynchronize(VariablesVo variablesVo,OrderWo orderWo){
		logger.info("=================OA审批开始============");
        String oaApplySynchronizeUrl = CacheUtils.getValueByKey("OA.URL_PREFIX")
                + CacheUtils.getValueByKey("OA.APPLY_SYNCHRONIZE");
        StringBuffer oaReqUrl = new StringBuffer(oaApplySynchronizeUrl);
        StringBuffer oaReqUrl2 = new StringBuffer();
        String tenandId = CacheUtils.getValueByKey("OA.TENAND_ID");
        JSONObject matchParamJson = new JSONObject();
        matchParamJson.put("applyType", "0");
        oaReqUrl2.append("tenandId=").append(tenandId);
        oaReqUrl2.append("&applyNbr=").append(variablesVo.getApplyId());
        oaReqUrl2.append("&applyTime=").append(DateUtil.nowEn());
        oaReqUrl2.append("&ntAccount=").append(variablesVo.getNtAccount());
        oaReqUrl2.append("&matchParam=").append(matchParamJson.toString());
        Map<String,String> map2 = new HashMap<String,String> ();
        map2.put("iscParam", variablesVo.getCostCenterCode());
        oaReqUrl2.append("&ruleParam=").append(GsonUtil.toJSon(map2));
        
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    	Map<String,String> map= new HashMap<String,String>();
    	map.put("orderWoId", String.valueOf(orderWo.getOrderWoId()));
    	map.put("iscParam", variablesVo.getCostCenterCode());
    	list.add(map);
    	String jsonString = JsonUtils.toJsonString(list);
        oaReqUrl2.append("&variables=").append(jsonString);
        logger.info("OA审批调用前URL==========》"+oaReqUrl.toString());
        logger.info("OA审批调用前parms==========》"+oaReqUrl2.toString());
        
        String result = HttpRequestUtil.sendPost(oaReqUrl.toString(), oaReqUrl2.toString());
        
        logger.info("iaas apply process taskdispatch -> send requset contents to oa system END!");
        logger.info("OA审批调用返回结果==========》"+result);
        return result;
	}
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		VariablesVo variablesVo= new VariablesVo();
		OrderWo orderWo = new OrderWo();
		variablesVo.setApplyId("1899");
		variablesVo.setNtAccount("dingyi5");
		
		orderWo.setOrderWoId(Long.parseLong("189"));
		OaApplySynchronizeClent oaApplySynchronizeClent = new OaApplySynchronizeClent();
		oaApplySynchronizeClent.oaApplySynchronize(variablesVo, orderWo);
	}
}
