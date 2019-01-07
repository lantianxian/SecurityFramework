package com.lantianxiang.security.core.properties;

/**
 * Create by Lantianxiang
 * Description: 验证码相关配置项
 * Create Date: 2019/1/2
 * Create Time: 16:43
 **/
public class ValidateCodeProperties {

    private ImageCodeProperties properties = new ImageCodeProperties();

    private SmsCodeProperties smsCodeProperties = new SmsCodeProperties();

    public ImageCodeProperties getProperties() {
        return properties;
    }

    public void setProperties(ImageCodeProperties properties) {
        this.properties = properties;
    }

    public SmsCodeProperties getSmsCodeProperties() {
        return smsCodeProperties;
    }

    public void setSmsCodeProperties(SmsCodeProperties smsCodeProperties) {
        this.smsCodeProperties = smsCodeProperties;
    }

}
