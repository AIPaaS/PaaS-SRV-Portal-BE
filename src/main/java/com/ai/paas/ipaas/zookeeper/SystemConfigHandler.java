package com.ai.paas.ipaas.zookeeper;

import java.util.HashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class SystemConfigHandler implements InitializingBean {

	@Autowired
	private SysConfigStore configStore;
	
	public static HashMap<String, String> configMap = new HashMap<String, String>();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		String json = configStore.getConfig();
		configMap = SysConfigStore.getConfigMap(json);
	}
}
