package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class SelectWithNoPageRequest<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private T selectRequestVo ; // 参数对象

	public T getSelectRequestVo() {
		return selectRequestVo;
	}

	public void setSelectRequestVo(T selectRequestVo) {
		this.selectRequestVo = selectRequestVo;
	}
}
