package com.lantianxiang.security.core.validate.code;

import java.time.LocalDateTime;

/**
 * Create by Lantianxiang
 * Description: 验证码基类
 * Create Date: 2019/1/2
 * Create Time: 18:35
 **/
public class ValidateCode {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 判断验证码是否过期
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
