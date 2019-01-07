package com.lantianxiang.security.core.validate.code.sms;

/**
 * create by Lantianxiang
 * Description: 短信发送接口
 * create date: 2019/1/3
 * create time: 17:58
 **/
public interface SmsCodeSender {
    void send(String mobilePhone, String code);
}
