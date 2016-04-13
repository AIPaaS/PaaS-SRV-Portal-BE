package com.ai.paas.ipaas.user.utils;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class Email {
	
    private static JavaMailSender javaMailSender;
    private static SimpleMailMessage simpleMailMessage;
	private static ApplicationContext contextInfo;
    
  /**
     * @方法名: sendMail 
     * @参数名：@param subject 邮件主题
     * @参数名：@param content 邮件主题内容
     * @参数名：@param to        收件人Email地址
     * @描述语:  发送邮件
     */
    public void sendMail(String subject, String content, String mailSender) {
        
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
          /**
             * new MimeMessageHelper(mimeMessage,true)之true个人见解：
             * 关于true参数,官方文档是这样解释的：
             * use the true flag to indicate you need a multipart message
             * 翻译过来就是：使用true,以表明你需要多个消息
             * 再去翻一下MimeMessageHelper的API,找到这样一句话：
             * supporting alternative texts, inline elements and attachments
             * 也就是说,如果要支持内联元素和附件就必须给定第二个参数为true
             * 否则抛出 java.lang.IllegalStateException 异常
             */
            contextInfo = new ClassPathXmlApplicationContext("context/applicationContext-mail.xml");
	       
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
            messageHelper.setFrom(simpleMailMessage.getFrom()); //设置发件人Email
            messageHelper.setSubject(subject); //设置邮件主题
            messageHelper.setText(content);   //设置邮件主题内容
            messageHelper.setTo(mailSender);          //设定收件人Email
          /**
             * ClassPathResource：很明显就是类路径资源,我这里的附件是在项目里的,所以需要用ClassPathResource
             * 如果是系统文件资源就不能用ClassPathResource,而要用FileSystemResource,例：
             * FileSystemResource file = new FileSystemResource(new File("D:/Readme.txt"));
             */
//            ClassPathResource file = new ClassPathResource("attachment/Readme.txt");
          /**
             * MimeMessageHelper的addAttachment方法：
             * addAttachment(String attachmentFilename, InputStreamSource inputStreamSource)
             * InputStreamSource是一个接口,ClassPathResource和FileSystemResource都实现了这个接口
             */
//            messageHelper.addAttachment(file.getFilename(), file); //添加附件
            
           

           // SimpleMailMessage mail = new SimpleMailMessage(); //<span style="color: #ff0000;">注意SimpleMailMessage只能用来发送text格式的邮件</span>  

            javaMailSender.send(mimeMessage);    //发送附件邮件
            
        } catch (Exception e) {System.out.println("异常信息：" + e);}
    }
    
	public static void   send(String subject, String content, String mailSender) {
		// List <String> numberList=new ArrayList<String>();
		 
	        try {
	        	 contextInfo = new ClassPathXmlApplicationContext("context/applicationContext-mail.xml");
	        	 javaMailSender= (JavaMailSender) contextInfo.getBean("javaMailSender");
	        	 simpleMailMessage.setTo(mailSender);
	        	 simpleMailMessage.setFrom("jonrey_zl@163.com");
	        	 simpleMailMessage.setSubject(subject);
	        	 simpleMailMessage.setText(content);
	        	 javaMailSender.send(simpleMailMessage);
	            
	        } catch (Exception e) {
	        	System.out.println("异常信息：" + e);
	        	e.printStackTrace();
	        }
	    }
      //Spring 依赖注入
    
    public static void main(String[] args) throws Error, InterruptedException {
        List <String> numberList=new ArrayList<String>();
		String content=null;
		try {
			numberList.add("majh5@asiainfo.com");
			numberList.add("zhanglei11@asiainfo.com");
			numberList.add("806533679@qq.com");
			numberList.add("liwx3@asiainfo.com");
			content="test....";
			contextInfo = new ClassPathXmlApplicationContext("context/applicationContext-mail.xml");
	        Email mail = (Email)contextInfo.getBean("simpleMail");
//	        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//	        simpleMailMessage.setFrom("zhanglei11@asiainfo.com");
	        //simpleMailMessage.setTo(numberList);
			for(String number:numberList){
				mail.sendMail("亚信云通知", content, number);
				//send("亚信云通知",content,number);
				//Thread.sleep(3);
			}
		} catch (Error e) {
			e.printStackTrace();
		}
		
	}

	public static JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public static void setJavaMailSender(JavaMailSender javaMailSender) {
		Email.javaMailSender = javaMailSender;
	}

	public static SimpleMailMessage getSimpleMailMessage() {
		return simpleMailMessage;
	}

	public static void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		Email.simpleMailMessage = simpleMailMessage;
	}
    
}
