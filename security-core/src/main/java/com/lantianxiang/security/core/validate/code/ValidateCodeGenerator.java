package com.lantianxiang.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * create by Lantianxiang
 * Description: 验证码生成接口
 * create date: 2019/1/2
 * create time: 18:03
 **/
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
