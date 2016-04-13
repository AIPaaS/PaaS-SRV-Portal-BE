package com.ai.paas.ipaas.user.utils;

public class MailSenderFactory {

	

	/**
     * 服务邮箱
     */
    private static SimpleMailSender serviceSms = null;
 
    /**
     * 获取邮箱
     * 
     * @param type 邮箱类型
     * @return 符合类型的邮箱
     */
    public static SimpleMailSender getSender() {
        if (serviceSms == null) {
        serviceSms = new SimpleMailSender("zhanglei11@qq.com",
            "zlhappy1988");
        }
        return serviceSms;
    }

}
