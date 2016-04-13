package com.ai.paas.ipaas.user.dubbo.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.user.dubbo.interfaces.ISoftwareInstallAPI;
import com.ai.paas.ipaas.user.service.ISoftwareInstallSv;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.user.vo.ResponseVo;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 软件安装完成APIIMPL
 * @author renfeng
 *
 */
@Transactional
@Service
public class SoftwareInstallAPIImpl implements ISoftwareInstallAPI {
	private static final Logger logger = LogManager.getLogger(SoftwareInstallAPIImpl.class
            .getName());
	@Autowired
	private ISoftwareInstallSv softwareInstallSvImpl;
	private ResponseVo resVo = new ResponseVo();
	@Override
	public String softwareInstallSubmit(String params) {
			try {
				String softwareInstallSubmit = softwareInstallSvImpl.softwareInstallSubmit(params);
				logger.info("软件安装提交返回结果----->"+softwareInstallSubmit);
				resVo.setResponseCode(softwareInstallSubmit);
			} catch (Exception e) {
				logger.error("软件安装提交失败！");
				resVo.setResponseCode("999999");
				e.printStackTrace();
			}
			return JsonUtils.toJsonString(resVo);
	}

}
