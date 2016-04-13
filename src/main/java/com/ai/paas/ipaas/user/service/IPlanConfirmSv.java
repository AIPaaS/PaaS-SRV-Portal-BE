package com.ai.paas.ipaas.user.service;

import java.sql.SQLException;

import com.ai.paas.ipaas.user.dubbo.vo.PageEntity;
import com.ai.paas.ipaas.user.dubbo.vo.PageResult;
import com.ai.paas.ipaas.user.dubbo.vo.PlanConfirmVo;

/**
 * 集成方案确认查询
 * @author dingyi5
 *
 */
public interface IPlanConfirmSv {
	public PageResult<PlanConfirmVo> selectPlanConfirm(PageEntity pageEntity) throws SQLException;
	
}
