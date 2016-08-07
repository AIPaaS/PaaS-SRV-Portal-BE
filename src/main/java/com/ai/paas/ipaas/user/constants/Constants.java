package com.ai.paas.ipaas.user.constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final String SECURITY_KEY = "7331c9b6b1a1d521363f7bca8acb095f";// md5
	
	public static final String OPERATE_CODE_SUCCESS = "0000";// 操作成功
	
	public static final String OPERATE_CODE_FAIL = "9999";// 操作失败
	
	public static final String IPAAS_START_ID = "001";// ipaas服务id起始
	
	public static final String IPAAS_ID_FIX = "0";// ipaas服务id起始
	
	public static final int IPAAS_ID_LENGTH = 3;// ipaas服务id数字长度	
	
	/**
	 * 订单常量
	 * @author mapl
	 *
	 */
	public static class Order {
		
        public static class PaasOrderStatus {
            // 开始
            public static final String ORDER_STATUS_START = "1";

            // 执行中
            public static final String ORDER_STATUS_EXECUTE = "2";

            // 结束
            public static final String ORDER_STATUS_FINISH = "3";

            // 关闭
            public static final String ORDER_STATUS_CLOSE = "4";

        }

        /**
         * IAAS虚拟机订单状态变化
         * 
         * @author archer
         * 
         */
        public static class IaasOrderStatus {

            // 待OA审核
            public static final String WAIT_OA_AUDIT = "5";

            // 待制定集成方案
            public static final String WAIT_INTEGRATED_SCHEME = "6";

            // 待用户确认方案
            public static final String WAIT_CONFIRM_SCHEME = "7";

            // 待开通
            public static final String WAIT_OPEN = "8";

            // 待安装软件
            public static final String WAIT_INSTALL_SOFTWARE = "9";

            // 待用户修改订单
            public static final String WAIT_USER_MODIFY_ORDER = "10";

            // 关闭
            public static final String ORDER_STATUS_CLOSE = "4";

        }

        /**
         * 
         * Description: 产品类型 ：Ipaas 或 Iaas <br>
         * Date: 2015年6月4日 <br>
         * 
         * @author caiyt
         */
        public static class ProductType {
            // Ipaas
            public static final String PROD_IPAAS = "1";

            // Iaas
            public static final String PROD_IAAS = "2";
        }

        public static class OrderCheckStatus {
            // 待审核
            public static final String CHECK_STATUS_AUDITING = "1";

            // 已审核
            public static final String CHECK_STATUS_AUDITED = "2";
        }

        public static class OrderCheckResult {
            // 审核通过
            public static final String CHECK_PASS = "1";

            // 审核不通过
            public static final String CHECK_NOT_PASS = "2";
        }

        public static class OpenState {
            // 1. 待处理
            public static final String PENDING = "1";

            // 2. 已处理
            public static final String PROCESSED = "2";

            // 3. 处理中
            public static final String HANDING = "3";

        }

        public static class OpenResult {
            public final static String SUCCESS = "1"; // 成功

            public final static String FAIL = "2"; // 失败

        }
        
        public static class SbutractFlag {
            public final static String REDUCED = "Y"; // 已核减

            public final static String NOT_REDUCED = "N"; // 未核减

        }
        
        public static class BelongCloud {
            public final static String YANFA_YUN = "1"; // 研发云

            public final static String ZUYONG_YUN = "2"; //租用云

        }
        
        public static class OperateType{
    		public static final String APPLY="1";       	 	//申请
    		public static final String UPDATE="2";	  	 		//扩容
    		public static final String UNSUBSCRIBE="3";   		//退订
    	}

    }

    /**
     * 账户来源 mapl
     */
    public static class authSource {
        public static final String AUTHSOURCE_WEB = "WEB";

        public static final String AUTHSOURCE_SDK = "SDK";
    }

    /**
     * 产品常量 mapl
     */
    public static class ProdProduct {
        /**
         * 产品编码
         * 
         * @author mapl
         */
        public static class ProdId {
            public final static String CCS = "1"; // 配置中心

            public final static String MCS = "2"; // 缓存中心

            public final static String MDS = "3"; // 消息中心

            public final static String RCS = "4"; // 实时计算

            public final static String ATS = "5"; // 最终事物一致

            public final static String DSS = "6"; // 存储中心

            public final static String TXS = "7"; // 事务保障服务

            public final static String DBS = "8"; // 分布式数据库服务

            public final static String TSC = "9"; // 事务保障服务中心

            public final static String IAAS_PHYSI = "10"; // 事务保障服务中心

            public final static String IAAS_VIRTA = "11"; // 事务保障服务中心

            public final static String IAAS_MEMORY = "12"; // 事务保障服务中心

            public final static String OM = "13"; // 运维中心服务

            public final static String DES = "14"; // 实时增量数据获取服务

            public final static String SES = "15"; // 搜索服务
            
            public final static String RDS = "17"; // 分布式关系数据库
        }

        /**
         * 产品英文简写
         * 
         * @author mapl
         */
        public static class ProdEnSimp {
            public final static String CCS = "CCS"; // 配置中心

            public final static String MCS = "MCS"; // 缓存中心

            public final static String MDS = "MDS"; // 消息中心

            public final static String RCS = "RCS"; // 实时计算

            public final static String ATS = "ATS"; // 最终事物一致

            public final static String DSS = "DSS"; // 存储中心

            public final static String TXS = "TXS"; // 事务保障服务

            public final static String DBS = "DBS"; // 分布式数据库服务

            public final static String TSC = "TSC"; // 事务保障服务中心

            public final static String IAAS_PHYSI = "IAAS_PHYSI";

            public final static String IAAS_VIRTA = "IAAS_VIRTA";

            public final static String IAAS_MEMORY = "IAAS_MEMORY";

            public final static String DES = "DES";// 实时增量数据获取服务

            public final static String SES = "SES";// 搜索服务
            
            public final static String RDS = "RDS";// 分布式关系数据库
        }
    }

    public static class Restful {
        /**
         * 服务开通返回结果
         * 
         * @author mapl
         */
        public static class OpenServResult {
            public final static String SUCCESS = "000000"; // 成功

            public final static String FAIL = "999999"; // 失败
        }

        /**
         * rest json返回key
         * 
         * @author mapl
         */
        public static class OpenServKey {
            public final static String CODE = "resultCode";
        }

    }

    public static class UserProdInst {
        /**
         * 开通状态
         */
        public static class UserServState {
            public final static String OPEN = "0"; // 开通

            public final static String CLOSE = "1"; // 失败

        }

        /**
         * 运行状态
         */
        public static class UserServRunState {
            public final static String OPEN = "0"; // 启用

            public final static String CLOSE = "1"; // 停用

            public final static String CANCEL = "2"; // 注销

        }
    }

    public static class UserMgrOperate {
        /**
         * 操作动作
         */
        public static class UserOperateAction {
            public final static String MDYPWD = "1"; // 修改ipaas服务密码

            public final static String START = "2"; // 启

            public final static String STOP = "3"; // 停

            public final static String FULLCLEAR = "4"; // 全部清理数据

            public final static String KEYCLEAR = "5"; // 单key清理数据

            public final static String CANCLE = "6"; // 注销

            public final static String RESTART = "7"; // 重启
            
            public final static String ModifyConfiguration="8"; //修改配置
            
            public final static String UserEmail = "11"; //用户登录账户置换
			public final static String UserPs = "12"; //用户登录账户密码修改
        }

        public final static Map<String, String> userOperateActionMap = new HashMap<String, String>();

        static {

            userOperateActionMap.put("1", "修改服务密码");
            userOperateActionMap.put("2", "启动");
            userOperateActionMap.put("3", "停用");
            userOperateActionMap.put("4", "全部清理数据");
            userOperateActionMap.put("5", "单key清理数据");
            userOperateActionMap.put("6", "注销");
        }

        /**
         * 操作结果
         */
        public static class UserOperateResult {
            public final static String SUCCESS = "1"; // 成功

            public final static String FAIL = "0"; // 失败

        }
    }

    public static class UsedAmount {
        // 单位
        public final static String M = "M";

        public final static String KB = "Kb";
    }

    /**
     * 
     * Description: 调用工作流接口URL后缀 <br>
     * Date: 2015年7月30日 <br>
     * Copyright (c) 2015 AILK <br>
     * 
     * @author caiyt
     */
    public static class WorkflowReqUrlSuffix {
        // 流程启动
        public static final String PROCESS_START = "/core/runtime/processInstance/start";

        // 流程终止
        public static final String PROCESS_OVER = "/core/runtime/processInstance/void";

        // 任务领用
        public static final String TASK_CLAIM = "/core/runtime/task/claim";

        // 任务完成
        public static final String TASK_COMPLETE = "/core/runtime/task/complete";

        // 任务转派
        public static final String TASK_DELEGATE = "/core/runtime/task/resolved";
    }

    /**
     * 
     * Description: 工作流服务响应码<br>
     * Date: 2015年7月29日 <br>
     * Copyright (c) 2015 AILK <br>
     * 
     * @author caiyt
     */
    public static class WorkflowResponseCode {
        // 操作成功，响应返回（GET和POST请求）
        public static final String SUCCESS = "200";

        // 请求参数错误。参数包含未经转换的特殊字符，或者缺少必传参数
        public static final String REQ_PARAMS_WRONG = "400";

        // 认证失败。请求没有通过权限认证
        public static final String AUTHENTICATE_FAILURE = "401";

        // 找不到服务。表示根据URL地址，无法找到服务
        public static final String SERVICE_NOT_FOUND = "404";

        // 表示因为冲突导致无法执行操作
        public static final String CAN_NOT_OPERATE = "409";

        // 服务器发生未知异常。执行操作时出现了预期外的异常
        public static final String SERVICE_UNKNOWN_EXCEPTION = "500";
    }

    public static class CacheKeys {
        // 工作流访问路径前缀
        public static final String WORKFLOW_URL_PREFIX = "WORKFLOW.URL_PREFIX";

        // 工作流访问令牌
        public static final String WORKFLOW_TICKET = "WORKFLOW_TICKET";
    }
    
    
    /**
	 * 工作流单据流程关系
	 * mapl
	 */	
	public static class WfTickets{
		/**
		 * 单据类型
		 * @author mapl
		 */
		public static class TicketType{
			public final static String IAAS_VM = "1"; //IAAS虚拟机申请		
		}
		/**
		 * 有效标识
		 * @author mapl
		 */
		public static class VaildFlag{
		
			public static final String NO = "0"; // 无效

			public static final String Yes = "1"; // 有效
		}
	}


    /**
     * 
     * Description: Iaas申请流程工单处理结果<br>
     * Date: 2015年9月24日 <br>
     * Copyright (c) 2015 AILK <br>
     * 
     * @author caiyt
     */
    public static class IaasApplyWoResult {
        // OA审核通过
        public static final String OA_CHECK_PASS = "1";

        // OA审核不通过
        public static final String OA_CHECK_NOT_PASS = "2";

        // 运维已制定集成方案
        public static final String MAINTAIN_MAKE_PLAN = "3";

        // 用户已同意集成方案
        public static final String USER_AGREE_PLAN = "4";

        // 用户不同意集成方案
        public static final String USER_DISAGREE_PLAN = "5";

        // 已录入开通信息
        public static final String RECORD_OPEN_INFO = "6";

        // 已录入安装软件信息
        public static final String RECORD_INSTALL_INFO = "7";

        // 申请人修改提交
        public static final String USER_UPT_COMMIT = "8";
    }

    /**
     * 
     * Description: 字段的属性<br>
     * Date: 2015年9月24日 <br>
     * Copyright (c) 2015 AILK <br>
     * 
     * @author caiyt
     */
    public static class ColumnStatus {
        // 有效
        public static final String EFFECTIVE = "1";

        // 无效
        public static final String INVALID = "0";
    }

    /**
     * 
     * Description: 工单处理状态<br>
     * Date: 2015年9月24日 <br>
     * Copyright (c) 2015 AILK <br>
     * 
     * @author caiyt
     */
    public static class WoStatus {
        // 已处理
        public static final String HAS_OPERATED = "1";

        // 待处理
        public static final String WAIT_OPERATED = "0";
    }

    /**
     * 
     * Description: 工单处理状态<br>
     * Date: 2015年9月24日 <br>
     * Copyright (c) 2015 AILK <br>
     * 
     * @author caiyt
     */
    public static class DisplayFlag {
        // 显示
        public static final String DISPLAY = "0";

        // 不显示
        public static final String NOT_DISPLAY = "1";
    }
    
    /**
	 * 集成方案表
	 * mapl
	 */	
	public static class OrderScheme{
		

		public static class UserOperateAction {
			public final static String MDYPWD = "1"; //修改ipaas服务密码
			public final static String START = "2"; //启
			public final static String STOP = "3"; //停
			public final static String FULLCLEAR = "4"; //全部清理数据
			public final static String KEYCLEAR = "5"; //单key清理数据
			public final static String CANCLE = "6"; //注销
			public final static String RESTART = "7"; //重启
			public final static String UserEmail = "11"; //用户登录账户置换
			public final static String UserPs = "12"; //用户登录账户密码修改
		}

		/**
		 * 有效标识
		 * @author mapl
		 */

		public static class VaildFlag{
		
			public static final String  YES= "0"; // 有效

			public static final String  NO = "1"; // 无效
		}
	}
}