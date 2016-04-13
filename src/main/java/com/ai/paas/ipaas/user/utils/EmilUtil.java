package com.ai.paas.ipaas.user.utils;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


public class EmilUtil {
	public static void main(String[] args) {
        
		try {
			sendEmail();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
       
    }

	
	public static void sendEmail() {
		
		SimpleMailSender sms = MailSenderFactory.getSender();

	        List<String> recipients = new ArrayList<String>();

	        recipients.add("majh5@asiainfo.com");
	        recipients.add("zhanglei11@asiainfo.com");
	        recipients.add("806533679@qq.com");

	        try {
		        //邮件主题
		        String subject ="【亚信云】服务申请审核结果通知";
		        
		        //邮件内容
		        String content ="您好："
		        		+ "您订购的512G的缓存服务已经订购成功，可以进行使用了，谢谢您使用我们的云缓存服务！";
	
		        sms.send(recipients, subject, content);

	        } catch (AddressException e) {

	            e.printStackTrace();

	        } catch (MessagingException e) {

	            e.printStackTrace();

	        }

	}
}
