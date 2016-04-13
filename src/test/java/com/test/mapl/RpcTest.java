package com.test.mapl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.service.IAtsConsoleSv;
import com.test.springcontext.SpringContext;
  


public class RpcTest {
	
public static void main(String[] args) throws ParseException{
		
		demoTest();
		
	}

public static void demoTest(){

	ClassPathXmlApplicationContext context = SpringContext.getContext();
	
	String [] names=context.getBeanDefinitionNames();
	System.out.print("Beans:");
	for (String string : names) {
		System.out.print(string);
		System.out.println(",");
	}
	
	IAtsConsoleSv IDemoApi=(IAtsConsoleSv) context.getBean("atsConsoleSvImpl");
	try {
		IDemoApi.searchOneMessage(null);
	} catch (PaasException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (IOException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (URISyntaxException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
}

}
