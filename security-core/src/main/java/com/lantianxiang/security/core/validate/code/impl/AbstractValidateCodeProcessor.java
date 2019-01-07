package com.lantianxiang.security.core.validate.code.impl;

import com.lantianxiang.security.core.validate.code.*;
import com.lantianxiang.security.core.validate.code.exception.ValidateCodeException;
import com.lantianxiang.security.core.validate.code.utils.ValidateCodeType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * Create by Lantianxiang
 * Description: 校验码处理器的抽象实现
 * Create Date: 2019/1/4
 * Create Time: 10:22
 **/
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    //操作session的工具类
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    /**
     * 创建校验码，并保存发送
     * @param request Spring的工具类，封装请求的响应
     * @throws Exception
     */
    @Override
    public void create(ServletWebRequest request) throws Exception{
        C validateCode = generator(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    /**
     * 根据类型获取验证码生成器并生成验证码
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    private C generator(ServletWebRequest request){
        String type = getValidateCodeType(request).toString().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator codeGenerator = validateCodeGenerators.get(generatorName);
        if (codeGenerator == null){
            throw new ValidateCodeException("验证码生成器：" + generatorName + " 不存在.");
        }
        return (C) codeGenerator.generate(request);
    }

    /**
     * 将验证码保存进session中
     * @param request
     * @param validateCode 验证码
     */
    private void save(ServletWebRequest request, C validateCode){
        sessionStrategy.setAttribute(request, getSessionKey(request), validateCode);
    }

    /**
     * 发送验证码抽象类，由具体的功能实现
     * @param request
     * @param validateCode
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

    /**
     * 根据类名获取验证码类型
     * @param request
     * @return
     */
    private ValidateCodeType getValidateCodeType(ServletWebRequest request){
        String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }

    /**
     * 构建验证码放入session时的key值
     * @param request
     * @return
     */
    private String getSessionKey(ServletWebRequest request){
        return SESSION_KEY_PREFIX + getValidateCodeType(request).toString().toUpperCase();
    }

    /**
     * 校验验证码
     * @param request
     */
    @SuppressWarnings("unchecked")
    @Override
    public void validate(ServletWebRequest request) {

        ValidateCodeType processorType = getValidateCodeType(request);
        String sessionKey = getSessionKey(request);

        C codeInSession = (C) sessionStrategy.getAttribute(request, sessionKey);

        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
                    processorType.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("获取验证码的值失败");
        }

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException(processorType + "验证码的值不能为空");
        }

        if (codeInSession == null) {
            throw new ValidateCodeException(processorType + "验证码不存在");
        }

        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(request, sessionKey);
            throw new ValidateCodeException(processorType + "验证码已过期");
        }

        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException(processorType + "验证码不匹配");
        }

        sessionStrategy.removeAttribute(request, sessionKey);
    }

}
