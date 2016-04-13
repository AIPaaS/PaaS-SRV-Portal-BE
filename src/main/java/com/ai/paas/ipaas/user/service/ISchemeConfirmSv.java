package com.ai.paas.ipaas.user.service;

import java.sql.SQLException;

/**
 * 方案确认
 * @author renfeng
 *
 */
public interface ISchemeConfirmSv {
	/**
	 * 方案确认提交
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String schemeSubmit(String params)throws Exception;
}
