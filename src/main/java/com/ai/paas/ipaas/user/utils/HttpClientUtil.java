package com.ai.paas.ipaas.user.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.ai.paas.ipaas.user.dubbo.vo.WorkflowResponse;
import com.ai.paas.ipaas.user.exception.BusinessException;
import com.ai.paas.ipaas.user.utils.oamd5.OaMd5Util;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;

public class HttpClientUtil {
    private static final Log logger = LogFactory.getLog(HttpClientUtil.class);

    public static String sendPostRequest(String url, String param) throws IOException,
            URISyntaxException {
    	logger.info("restful request url:"+url);
    	logger.info("restful request param:"+param);
    	CloseableHttpClient httpclient = null;
    	CloseableHttpResponse response = null;
    	StringBuffer buffer = new StringBuffer();
        try {
        	 httpclient = HttpClients.createDefault();
             HttpPost httpPost = new HttpPost(new URL(url).toURI());
             StringEntity dataEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
             httpPost.setEntity(dataEntity);
             response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        entity.getContent()));                
                String tempStr;
                while ((tempStr = reader.readLine()) != null)
                    buffer.append(tempStr);
            } else {
            	WorkflowResponse response2 = new WorkflowResponse();
            	response2.setResponCode(String.valueOf(response.getStatusLine().getStatusCode()));
            	response2.setResponMessage("请求异常！");
            	String response2Json = JsonUtils.toJsonStr(response2);
            	logger.error("=============http请求异常===="+response2Json.toString());
            	
            	return response2Json.toString();
            }
        }catch(Exception e){
        	e.printStackTrace();
        	logger.error(e.getMessage(),e);
        } finally {
        	try {
        		if(response != null ){
        			response.close();    			
        		}
        		if(httpclient != null ){
        			httpclient.close();    			
        		}
        	} catch (IOException e) {
	        	logger.error(e.getMessage(),e);
			}
        }
        return buffer.toString();
    }

    public static String send(String address, String param) {
        logger.info("restful address : " + address);
        logger.info("param : " + param);
        String result = "";
        try {
            result = HttpClientUtil.sendPostRequest(address, param);
            logger.info("result : " + result);
        } catch (IOException e) {
            String errorMessage = e.getMessage();
            logger.error(errorMessage, e);
        } catch (URISyntaxException e) {
            String errorMessage = e.getMessage();
            logger.error(errorMessage, e);
        }
        // 请求发生异常后，result 为 空
        return result;
    }

    /**
     * 发送GET请求
     * 
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String sendGet(String url, Map<String, String> parameters) {
        StringBuffer buffer = new StringBuffer();// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if (parameters.size() == 1) {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=")
                            .append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
                }
                params = sb.toString();
            } else {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=")
                            .append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"))
                            .append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            String full_url = url + "?" + params;
            logger.info("restful address : " + full_url);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(full_url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            // 建立实际的连接
            httpConn.connect();
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
       
    	String object = null;
		String key;
		try {					
//            String	addressTime = CacheUtils.getOptionByKey("OA.OA", "getAIServerTime");
			String	addressTime = SystemConfigHandler.configMap.get("OA.OA.getAIServerTime");
			key = OaMd5Util.encryptToMD5(HttpRequestUtil.sendGet(addressTime, "")
					+ "AIHRA_EMPLOYEE_INFO_FOR_HR_Vdjk*3k@-3_31");

			String ntAccount = "'mapl'";
			
			Map reqMap = new HashMap();
			reqMap.put("key", key);
			reqMap.put("sw=nt_account", ntAccount);			
//			String	addressEmp = CacheUtils.getOptionByKey("OA.OA", "getAIHRA_EMPLOYEE");	
			String	addressEmp = SystemConfigHandler.configMap.get("OA.OA.getAIHRA_EMPLOYEE");
			object = HttpClientUtil.sendGet(addressEmp,reqMap);
			System.out.println(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("OA接口异常");
		}
    }
}
