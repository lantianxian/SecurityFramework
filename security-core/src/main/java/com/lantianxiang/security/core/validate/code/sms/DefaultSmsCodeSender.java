package com.lantianxiang.security.core.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create by Lantianxiang
 * Description: 默认实现短信验证码发送功能，可通过接口覆盖
 * Create Date: 2019/1/3
 * Create Time: 17:59
 **/
public class DefaultSmsCodeSender implements SmsCodeSender {

    private Logger logger = LoggerFactory.getLogger(DefaultSmsCodeSender.class);

    @Override
    public void send(String mobilePhone, String code) {
        logger.info("向手机发送短信验证码: phone number {}, code {}", (Object[]) new String[]{mobilePhone, code});
    }
}
