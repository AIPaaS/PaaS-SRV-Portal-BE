package com.ai.paas.ipaas.cache;

import java.util.List;

public class CacheUtils {
    @SuppressWarnings("unchecked")
    /**
     * 
     * @description  根据key获取全部对象(key, value)
     * @author caiyt
     */
    public static List<CodeValueObject> getCodeValueListByKey(String key) {
        return (List<CodeValueObject>) RedisClient.get4Serial(key);
    }

    /**
     * 
     * @description 根据key获取唯一对象(key, value)
     * @author caiyt
     */
    public static CodeValueObject getCodeValueByKey(String key) {
        List<CodeValueObject> codeValueList = getCodeValueListByKey(key);
        if (codeValueList != null && codeValueList.size() == 1) {
            return codeValueList.get(0);
        }
        return null;
    }

    /**
     * 
     * @description 根据key获取唯一对象的值(value)
     * @author caiyt
     */
    public static String getValueByKey(String key) {
        CodeValueObject obj = getCodeValueByKey(key);
        if (obj != null) {
            return obj.getValue();
        }
        return null;
    }
    
    /**
     * 
     * @description  根据key，code获取value
     * @author mapl
     */
    public static String getOptionByKey(String key,String  code) {
    	List<CodeValueObject> list  =  (List<CodeValueObject>) RedisClient.get4Serial(key);
    	String value="";
    	for(CodeValueObject codeValueObject : list){
    		if(codeValueObject.getCode().equals(code)){
    			value = codeValueObject.getValue();
    		}
    	}
        return value;
    }
    
   public static void main(String[] args) { 
	   
       System.out.println(CacheUtils.getOptionByKey("IPAAS-WEB.SERVICE","IP_PORT_SERVICE")+CacheUtils.getOptionByKey("IPAAS-WEB.IAASCONSOLE","URL"));
   }
}