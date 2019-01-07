package com.lantianxiang.security.core.properties;

/**
 * Create by Lantianxiang
 * Description: 标准验证码配置
 * Create Date: 2019/1/2
 * Create Time: 16:38
 **/
public class SmsCodeProperties {

    //验证码长度
    private int length = 6;
    //过期时间
    private int expireIn = 60;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
