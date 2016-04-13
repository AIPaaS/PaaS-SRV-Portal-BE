package com.test.springcontext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext { 
	public static ClassPathXmlApplicationContext getContext() {		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( new String[] {"classpath*:test-consumer.xml"});
		context. start();		
		return context;
	}

}
