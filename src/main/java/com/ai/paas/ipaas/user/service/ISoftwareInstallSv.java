package com.ai.paas.ipaas.user.service;
/**
 * 软件安装提交服务
 * @author renfeng
 *
 */
public interface ISoftwareInstallSv {
	/**
	 * 软件安装提交
	 * @return
	 * @throws Exception
	 */
	public String softwareInstallSubmit(String params)throws Exception;
}
