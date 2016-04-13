package com.ai.paas.ipaas.user.dubbo.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.user.dubbo.interfaces.ISchemeConfirmDubboSv;
import com.ai.paas.ipaas.user.service.ISchemeConfirmSv;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.user.vo.ResponseVo;
import com.alibaba.dubbo.config.annotation.Service;
/**
 * 方案确认
 * @author renfeng
 *
 */
@Service
@Transactional
public class SchemeConfirmDubboSvImpl implements ISchemeConfirmDubboSv {
	private static final Logger logger = LogManager.getLogger(SchemeConfirmDubboSvImpl.class
            .getName());
	@Autowired
	private ISchemeConfirmSv schemeConfirmSvImpl;
	private ResponseVo resVo = new ResponseVo();
	@Override
	public String schemeSubmit(String params) {
		
		try {
			String schemeSubmit = schemeConfirmSvImpl.schemeSubmit(params);
			logger.info("方案确认返回结果----->"+schemeSubmit);
			resVo.setResponseCode(schemeSubmit);
		} catch (Exception e) {
			logger.error("方案确认失败！");
			resVo.setResponseCode("999999");
			e.printStackTrace();
		}
		return JsonUtils.toJsonString(resVo);
	}

}
