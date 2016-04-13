package com.ai.paas.ipaas.user.utils;

import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ai.paas.ipaas.PaasException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
	/**
	 * 创建JSONObject
	 */
	public static JSONObject createJSONObject(String proName,String proValue){
		JSONObject jsonObject=new JSONObject();
		jsonObject.put(proName, proValue);
		return jsonObject;
	}
	/**
	 * 创建JSONObject
	 * @throws PaasException 
	 */
	public static JSONObject createJSONObject(String... str ) throws PaasException{
		if (str.length%2==1) {
			throw new PaasException("参数数量不对，为偶数");
		}
		JSONObject jsonObject=new JSONObject();
		for (int i = 0; i < str.length; i=i+2) {
			jsonObject.put(str[i], str[i+1]);
		}
		return jsonObject;
	}
	/**
	 * 创建JSONObject
	 */
	public static JSONObject parse(String str ){
		JSONObject jsonObject=new JSONObject(str);
		return jsonObject;
	}
	/**
	 * 创建JSONObject
	 */
	public static JSONObject parse(Object object){
		JSONObject jsonObject=new JSONObject(object);
		return jsonObject;
	}
	/**
	 * 创建JSONArray
	 */
	public static JSONArray parseArray(List<String> list){
		JSONArray jsonArray=new JSONArray(list);
		return jsonArray;
	}
	/**
	 * 创建JSONArray
	 */
	public static JSONArray parseArray(Set<String> list){
		JSONArray jsonArray=new JSONArray(list);
		return jsonArray;
	}
	/**
	 * 返回JSON格式字符串
	 */
	public static String toJsonString(Object object){
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	
    /**
     * json串转换成简单类
     * 
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T fromJSon(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        T t = gson.fromJson(json, clazz);
        return t;
    }
    /**
     * org下对像转jsonString
     * @param object
     * @return
     */
	public static String toJsonStr(Object object){
		JSONObject json = new JSONObject(object);
		return json.toString();
	}
	public static void main(String[] args){
				
		String gson = "{\"userId\":\"123\",\"applyType\":\"create\"}";
		JSONObject prodParamJson = new JSONObject();
		prodParamJson = JsonUtils.parse(gson);
		prodParamJson.put("username", "sange");		
		System.out.println(prodParamJson.toString());
		System.out.println(prodParamJson.get("username"));
	}
}
