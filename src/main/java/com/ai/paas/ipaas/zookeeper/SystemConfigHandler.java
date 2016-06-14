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
		/** 门户后场启动时，需要加载sys_config表数据到zk中 **/
		configStore.storeConfig();
		
		/** 从zk中获取sys_config的配置数据，放到HashMap中 **/
		String json = configStore.getNodeValue();
		configMap = SysConfigStore.getConfigMap(json);
	}
}
