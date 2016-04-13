package com.ai.paas.ipaas.user.utils.gson;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.paas.ipaas.util.JSonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    private static final transient Logger log = LoggerFactory.getLogger(GsonUtil.class);

    private static Gson gson =  new GsonBuilder().registerTypeAdapter(Timestamp.class,new TimestampTypeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * 对象转json
     * 
     * @param obj
     * @return
     */
    public static String toJSon(Object obj) {
        String json = gson.toJson(obj);
        if (log.isInfoEnabled()) {
            log.info(obj + " trasform into json:" + json);
        }
        return json;
    }
    
    /**
     * 对象转json
     * @param <T>
     * 
     * @param obj
     * @return
     */
    public static <T> String toJSon(Object obj,Class<T> clazz) {
        String json = gson.toJson(obj,clazz);
        if (log.isInfoEnabled()) {
            log.info(obj + " trasform into json:" + json);
        }
        return json;
    }
    

    /**
     * json串转换成简单类
     * 
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T fromJSon(String json, Class<T> clazz) {
        T t = gson.fromJson(json, clazz);
        if (log.isInfoEnabled()) {
            log.info(json + " trasform into class:" + clazz + ",object:" + t);
        }
        return t;
    }

    public static void main(String[] args) {    	
    	/*ResourceGeoInfo resourceGeoInfo = new ResourceGeoInfo();
    	resourceGeoInfo.setOpenStatus("1111111111");
    	resourceGeoInfo.setAa(111);
    	resourceGeoInfo.setPreOpenDate(DateUtil.getSysDate());
    	String jsonString = GsonUtil.toJSon(resourceGeoInfo, ResourceGeoInfo.class);
    	System.out.println(jsonString);*/
    	
    	/*String json = "{\"preOpenDate\":\"2015-09-23 16:15:18\",\"openStatus\":\"1111111111\",\"aa\":111}";
    	
    	ResourceGeoInfo resourceGeoInfo1 = GsonUtil.fromJSon(json, ResourceGeoInfo.class);
    	System.out.println(resourceGeoInfo1.getPreOpenDate());*/
    	
    }
    
    
}
