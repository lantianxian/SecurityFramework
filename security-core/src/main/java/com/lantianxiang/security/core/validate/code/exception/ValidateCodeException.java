package com.lantianxiang.security.core.validate.code.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Create by Lantianxiang
 * Description: 自定义身份认证异常类
 * Create Date: 2019/1/2
 * Create Time: 14:02
 **/
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
