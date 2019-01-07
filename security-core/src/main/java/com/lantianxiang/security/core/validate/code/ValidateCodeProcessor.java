package com.lantianxiang.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * create by Lantianxiang
 * Description: 校验码处理器，封装不同校验码的处理逻辑
 * create date: 2019/1/4
 * create time: 10:18
 **/
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码，并保存发送
     * @param request Spring的工具类，封装请求的响应
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     * @param servletWebRequest Spring的工具类，封装请求的响应
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);
}
