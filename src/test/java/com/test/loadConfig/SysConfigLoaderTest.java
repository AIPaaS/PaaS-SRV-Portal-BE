package com.test.loadConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.paas.ipaas.user.utils.SysConfigStore;

/**
 * Created by yuanman on 2016/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context/applicationContext.xml"})
public class SysConfigLoaderTest {
	
	@Autowired
	private SysConfigStore configLoader;
	
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void testGetSysConfig() throws Exception {
    	configLoader.processConfig();
    }

}
