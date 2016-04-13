package com.ai.paas.ipaas.user.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 读取properties文件
 * @author renfeng
 *
 */
public class ReadPropertiesUtil {

	
	public static void main(String[] args) throws IOException {
		
		Properties properties = ReadPropertiesUtil.getProperties("/context/email.properties");
		String property = properties.getProperty("asiainfo.host");
		System.out.println(property);
	}
	public static Properties getProperties(String filePath) throws IOException{
		Properties pp = new Properties();
		InputStream fs = Object.class.getResourceAsStream(filePath);  
		pp.load(fs);
		fs.close();
		return pp;
	}
}
