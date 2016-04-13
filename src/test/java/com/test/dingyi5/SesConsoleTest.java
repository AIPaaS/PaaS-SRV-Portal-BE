package com.test.dingyi5;

import java.text.ParseException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.paas.ipaas.user.dubbo.interfaces.ISesConsoleDubboSv;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.test.springcontext.SpringContext;

public class SesConsoleTest {
public static void main(String[] args) throws ParseException{
		
	stopServiceTest();
		
	}

public static void startServiceTest(){

	ClassPathXmlApplicationContext context = SpringContext.getContext();
	
	 
	
	ISesConsoleDubboSv sesConsoleDubboSv=(ISesConsoleDubboSv) context.getBean("sesConsoleDubboSvImpl");
	UserProdInstVo vo=new UserProdInstVo();
	vo.setUserId("488228CB65774FBE9B5E76E7491802EB");
	vo.setUserServId((long) 10611);
	ResponseHeader responseHeader=sesConsoleDubboSv.startService(vo);
	
	System.out.println(responseHeader.toString());
	
}
public static void stopServiceTest(){

	ClassPathXmlApplicationContext context = SpringContext.getContext();
	
	 
	
	ISesConsoleDubboSv sesConsoleDubboSv=(ISesConsoleDubboSv) context.getBean("sesConsoleDubboSvImpl");
	UserProdInstVo vo=new UserProdInstVo();
	vo.setUserId("488228CB65774FBE9B5E76E7491802EB");
	vo.setUserServId((long) 10611);
	ResponseHeader responseHeader=sesConsoleDubboSv.stopService(vo);
	
	System.out.println(responseHeader.toString());
	
}

public static void cancleServiceTest(){

	ClassPathXmlApplicationContext context = SpringContext.getContext();
	
	 
	
	ISesConsoleDubboSv sesConsoleDubboSv=(ISesConsoleDubboSv) context.getBean("sesConsoleDubboSvImpl");
	UserProdInstVo vo=new UserProdInstVo();
	vo.setUserId("488228CB65774FBE9B5E76E7491802EB");
	vo.setUserServId((long) 10611);
	ResponseHeader responseHeader=sesConsoleDubboSv.cancleService(vo);
	
	System.out.println(responseHeader.toString());
	
}

}
