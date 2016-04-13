package com.ai.paas.ipaas.user.utils;

public class StringUtil {

    public static boolean isBlank(String str) {
        if (null == str) {
            return true;
        }
        if ("".equals(str.trim())) {
            return true;
        }
        return false;
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static String restrictLength(String strSrc, int iMaxLength) {
        if (strSrc == null) {
            return null;
        }
        if (iMaxLength <= 0) {
            return strSrc;
        }
        String strResult = strSrc;
        byte[] b = null;
        int iLength = strSrc.length();
        if (iLength > iMaxLength) {
            strResult = strResult.substring(0, iMaxLength);
            iLength = iMaxLength;
        }
        while (true) {
            b = strResult.getBytes();
            if (b.length <= iMaxLength) {
                break;
            }
            iLength--;
            strResult = strResult.substring(0, iLength);
        }
        return strResult;
    }
    
  
	
	/**
	 * 左补齐
	 * @param target 目标字符串
	 * @param fix 补齐字符
	 * @param length 目标长度
	 * @return
	 */
	public static String lPad(String target, String fix, int length){
		if(target==null || fix ==null || !(target.length()<length))
			return target;
		StringBuffer newStr = new StringBuffer();
		for(int i=0; i<length-target.length(); i++){
			newStr.append(fix);
		}
		return newStr.append(target).toString();
	}
	
	/**
	 * 右补齐
	 * @param target 目标字符串
	 * @param fix 补齐字符
	 * @param length 目标长度
	 * @return
	 */
	public static String rPad(String target, String fix, int length){
		if(target==null || fix ==null || !(target.length()<length))
			return target;
		StringBuffer newStr = new StringBuffer();
		newStr.append(target);
		for(int i=0; i<length-target.length(); i++){
			newStr.append(fix);
		}
		return newStr.toString();
	}
	
	/**
	 * 字符串数据join操作
	 * @param strs
	 * @param spi
	 * @return
	 * @author zhoubo
	 */
	public static String join(String[] strs, String spi){
		StringBuffer buf = new StringBuffer();
		int step = 0;
		for(String str : strs){
			buf.append(str);
			if (step ++ < strs.length - 1)
				buf.append(spi);
		}
		return buf.toString();
	}
    
    //默认值为无
    public static String toString2(Object obj) {
        if (obj == null) {
            return "无";
        }
        return obj.toString();
    }

   
}
