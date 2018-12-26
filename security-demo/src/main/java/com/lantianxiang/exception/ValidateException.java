package com.lantianxiang.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Create by Lantianxiang
 * Description: 验证异常
 * Create Date: 2018/12/25
 * Create Time: 13:42
 **/
public class ValidateException extends RuntimeException {

    private List<ObjectError> errors;

    public ValidateException(List<ObjectError> errors){
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }
}
