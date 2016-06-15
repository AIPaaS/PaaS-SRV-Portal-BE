package com.test.loadConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.paas.ipaas.zookeeper.SysConfigStore;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;

/**
 * Created by yuanman on 2016/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:context/test-config.xml" })
public class SysConfigLoaderTest {
	
	@Autowired
	private SysConfigStore configStore;
	
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

//    @Test
//    public void testGetSysConfig() throws Exception {
//    	configStore.storeConfig();
//    	String json = configStore.getConfig();
//    	System.out.println("====return:"+json);
//    	configStore.getConfigMap(json);
//    }
	
	@Test
	public void testGetConfigFromMap() {
		System.out.println(SystemConfigHandler.configMap.get("IPAAS-UAC.MODIFYACCOUNT.URL"));
	}

}
