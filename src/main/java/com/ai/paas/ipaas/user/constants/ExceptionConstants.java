package com.ai.paas.ipaas.user.constants;

public class ExceptionConstants {	

	/**
	 * 请求
	 * @author archer
	 *
	 */
	public static class Request {

		public static final String PARAM_IS_NULL = "100100"; // "请求参数为空!"

		public static final String PARAM_IS_NOT_VALID = "100101"; // "请求参数格式不合法!"
	}

	/**
	 * 处理
	 * @author archer
	 *
	 */
	public static class Trade {
		
        //处理成功
		public static final String TRADE_SUCCESS = "000000";  //"处理成功";

		//处理失败
		public static final String TRADE_FAILURE = "999999";  //"系统繁忙，请稍后重试!"

	}
	
	/**
	 * 返回
	 * @author archer
	 *
	 */
	public static class Response {
		
		public static final String NO_RESULT = "200000"; // 查询结果为空
		public static final String NO_QUOTA = "500000"; // 核减配额

	}

}
