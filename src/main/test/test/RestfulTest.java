package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.paas.ipaas.cache.CacheUtils;
import com.ai.paas.ipaas.user.dubbo.vo.SysParamVo;
import com.ai.paas.ipaas.user.dubbo.vo.SysParmRequest;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.HttpRequestUtil;
import com.ai.paas.ipaas.user.utils.gson.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RestfulTest {
	
	
	/**
     * 流程启动通知模拟测试
	 * @throws URISyntaxException 
	 * @throws IOException 
     */
    public static void other() throws IOException, URISyntaxException {
       String req = "{\"processInstanceId\":\"612544\",\"businessKey\":\"1626\",\"variables\":[{\"applyId\":\"1626\"},{\"ntAccount\":\"dingyi5\"},{\"userId\":\"488228CB65774FBE9B5E76E7491802EB\"}]}";
      String result = HttpClientUtil.sendPostRequest(
              "http://127.0.0.1:20881/ipaas/workflow/iaasapply/processInstance/notify", req);
      System.out.println(result);
    }
    /**
     * 派单模拟测试
     * @throws URISyntaxException 
     * @throws IOException 
     */
    public static void other2() throws IOException, URISyntaxException {
        String req = "{\"taskId\":\"612550\",\"taskType\":\"\",\"parentTaskId\":\"\",\"processInstanceId\":\"612544\",\"owner\":\"\",\"callBackAddr\":\"http://10.1.228.198:10889/ipaas/workflow/iaasapply/process/deal\",\"URL\":\"a\",\"delegate\":\"\",\"createTime\":\"2015-10-19 10:05:57\",\"variables\":[{\"applyId\":\"1626\"},{\"ntAccount\":\"dingyi5\"},{\"userId\":\"488228CB65774FBE9B5E76E7491802EB\"}]}";
        String req2 = "{\"taskId\":\"612550\",\"taskType\":\"\",\"parentTaskId\":\"\",\"processInstanceId\":\"612544\",\"owner\":\"\",\"callBackAddr\":\"http://10.1.228.198:10889/ipaas/workflow/iaasapply/process/deal\",\"URL\":\"a\",\"delegate\":\"\",\"createTime\":\"2015-10-19 10:05:57\",\"variables\":[{\"applyId\":\"1626\"},{\"ntAccount\":\"dingyi5\"},{\"woDesc\":\"aaaaaa\"},{\"woResult\":\"4\"}]}";
      String result = HttpClientUtil.sendPostRequest(
              "http://127.0.0.1:20881/ipaas/workflow/iaasapply/process/deal", req);
      System.out.println(result);
    }
	
    public static void main(String[] args) throws IOException, URISyntaxException {
		String json = "{\"fromAddress\":\"ai-cloud@asiainfo.com\",\"fromPwd\":\"Paas0309_\",\"toAddress\":\"renfeng3@asiainfo.com\",\"emailTitle\":\"BBB\",\"emailContent\":\"你好！\"}";
//		String service = "http://127.0.0.1:20882/sendemail";
		String service = "http://10.1.228.198:20184/sendemail";
		String result = null;
		System.out.println(new Timestamp(System.currentTimeMillis()).toString());
		result = HttpClientUtil.sendPostRequest(
				service+"/sendEmail/sendEmail",
				json);
		System.out.println(new Timestamp(System.currentTimeMillis()).toString());
		System.out.println(result);
	}
//	public static void main(String[] argrs) throws Exception{
////		other();
////		other2();
//		
//		String valueByKey = CacheUtils.getValueByKey("CONTROLLER.CONTROLLER");
//		String key = CacheUtils.getValueByKey("VirtualMachine.SERVICE_INFORMULATE");
//		System.out.println(valueByKey.substring(0, valueByKey.lastIndexOf("/")));
//		System.out.println(key);
//		
//		
//	
//		
////		String url = "http://localhost:8080/iPaas-Web/oa/getOaOperators";
////		String param="param=AIC";
////		String sendPostRequest = HttpRequestUtil.sendGet(url, param);
////		System.out.println(sendPostRequest);
//	} 
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	public static void oaAuditResultNotifyTest(){		
		String url = "http://localhost:8080/iPaas-Web/oa/oaAuditResultNotify";
		String param = "applyNbr=1400&operType=AGREE&variables=[{\"userId\":\"alalnlcldne\",\"woResult\":\"1\",\"applyId\":\"12344\",\"orderWoId\":\"1\",\"ntAccount\":\"mapl\"}]";
		try {
			//String resutl = HttpRequestUtil.sendGet(url, param);
			String resutl = HttpRequestUtil.sendPost(url, param);
			System.out.println(resutl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void saveIaasIntegratedScheme(){
		String service = "http://192.168.1.111:20881/ipaas";
		String url = "/user/iOrderApi/saveIaasIntegratedScheme";
		Map map = new HashMap();
		
		map.put("orderWoId", "1")	;  //工单号
		map.put("orderDetailId", "1400")	; //订单号
		map.put("prodParam", "{serviceName:测试}")	;	//集成参数	
		map.put("prodParamZh", "{服务名称：测试}")	;   //集成参数中文
		map.put("schemeMaker", "mapl")	;   //方案制定人
		
		System.out.println("to MAIN rest:" + service + url);
		String param = GsonUtil.toJSon(map);
		System.out.println(param);
		String result;
		try {
			result = HttpClientUtil.sendPostRequest(service + url, param);
			System.out.println("MAIN return :" + result);					
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	

	
	/**
	 * POST请求方式
	 * @param path
	 * @param params
	 * @return
	 */
	public static String sendPost(String path,String params) {
		
		try {
			URL url = new URL(path);// 把字符串转换为URL请求地址
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
			connection.setDoOutput(true);  
			connection.setDoInput(true);  
			connection.setRequestMethod("POST"); 
			connection.setUseCaches(false);// Post 请求不能使用缓存
			connection.connect();// 连接会话
			byte[] bypes = params.toString().getBytes("utf-8");
			connection.getOutputStream().write(bypes);// 输入参数
			// 获取输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {// 循环读取流
				sb.append(line);
			}
			br.close();// 关闭流
			connection.disconnect();// 断开连接
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}    
		return null;
	}
	
	public static void getOaOperatorsTest(){		
		String url = "http://localhost:8080/iPaas-Web/oa/getOaOperators";
		try {
			String resutl = HttpRequestUtil.sendGet(url, "param=1001");
			System.out.println(resutl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void saveIaasOrderTest(){
		
		String service = "http://192.168.1.106:20881/ipaas";
		String url = "/user/iOrderApi/saveIaasOrder";
		Map map = new HashMap();		
		map.put("operateType", "1");   //操作类型		
		map.put("userId", "AAC5A58917984C5CA63311B11E9C57B2");  //userId
		map.put("prodId", "11"); //产品id
		map.put("prodParamZh", "{\"容量\":\"128\",\"是否集群\":\"single\",\"服务名称\":\"test-wx\"}"); //中文产品参数
		map.put("prodParam", "{\"capacity\":\"128\",\"haMode\":\"single\",\"serviceName\":\"test-wx\"}"); //英文产品参数
		map.put("applicant", "mapl");  //申请人		
		map.put("applicantDept", "aic");  //申请人部门		
		map.put("applicantTel", "13126566340");  //申请人电话		
		map.put("applicantEmail", "mapl@asiainfo.com"); //申请人邮箱		
		map.put("applicantReason", "研发需要机器");  //申请原因		
		map.put("applicantDesc", "11111111");  //备注		
		map.put("expirationDate", DateUtil.getSysDate());  //到期时间		
		map.put("belongCloud", "1");  //归属平台		
		
		
		map.put("costCenterCode", "AIC_TSD");  //成本中心编码
		map.put("costCenterName", "AIC技术保障部");  //成本中心名称
		map.put("userMaxNumbers", 5);  //用户数		
		map.put("concurrentNumbers", 100);   //最大访问量		
		map.put("applyType", "1"); //资源申请方式		
		map.put("useType", "1");  //用途说明		
		map.put("applyDesc", "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");  //业务描绘		
		

		System.out.println("to MAIN rest:" + service + url);
		String param = GsonUtil.toJSon(map);
		String result;
		try {
			result = HttpClientUtil.sendPostRequest(service + url, param);
			System.out.println("MAIN return :" + result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	
	public static void oaTest(){
		String service = "http://192.168.1.111:20881/ipaas";
		String url = "/user/iUserApi/getAiEmployeeInfo";
		Map map = new HashMap();		
		map.put("ntAccount", "mapl");   //nt账号		
		System.out.println("to MAIN rest:" + service + url);
		String param = GsonUtil.toJSon(map);
		System.out.println(param);
		String result;
		try {
			result = HttpClientUtil.sendPostRequest(service + url, param);
			//System.out.println("MAIN return :" + result);
			
			Map resmap = GsonUtil.fromJSon(result, HashMap.class);
		    String object  = (String) resmap.get("object");
		    
		    Gson gson = new Gson();
		    List<Map<String,Object>> list= gson.fromJson(object,
		    new TypeToken<List<Map<String,Object>>>() {
		    }.getType());		    
		    Map lais = list.get(0);
		    System.out.println(lais.get("assignment_number"));		    
		    System.out.println(lais.get("contract"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		test001();
//	}
//	public static void test001(){
//		String service = "http://127.0.0.1:20881/ipaas";
//		String url = "/order/queryOrdersInfo";
//		String result = HttpClientUtil.sendPostRequest(service + url, "{\"orderDetailId\":\"1111111\"}");
//		System.out.println(result);
//		
//	}
	
	
	public static void saveIaasOpenParam(){
		String service = "http://192.168.1.113:20881/ipaas";
		String url = "/user/iOrderApi/saveIaasOpenParam";
		Map map = new HashMap();
		
		map.put("orderWoId", "1")	;  //工单号
		map.put("orderDetailId", "1400")	; //订单号
		
		Map openParamMap = new HashMap();
		openParamMap.put("serviceName", "测试");
		map.put("openParam",  GsonUtil.toJSon(openParamMap))	;	//开通参数	
		
		map.put("email", "mapl@asiainfo.com")	;   //操作人邮箱
		
		System.out.println("to MAIN rest:" + service + url);
		String param = GsonUtil.toJSon(map);
		System.out.println(param);
		String result;
		try {
			result = HttpClientUtil.sendPostRequest(service + url, param);
			System.out.println("MAIN return :" + result);					
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	

}
