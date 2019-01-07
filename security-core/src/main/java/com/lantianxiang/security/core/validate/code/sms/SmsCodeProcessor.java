package com.lantianxiang.security.core.validate.code.sms;

import com.lantianxiang.security.core.validate.code.utils.SecurityConstants;
import com.lantianxiang.security.core.validate.code.ValidateCode;
import com.lantianxiang.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Create by Lantianxiang
 * Description: 验证码发送的短信实现类
 * Create Date: 2019/1/4
 * Create Time: 11:24
 **/
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired
    private SmsCodeSender smsCodeSender;

    /**
     * 发送验证码抽象类的实现
     * @param request
     * @param validateCode
     * @throws Exception
     */
    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        String phoneNum = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.send(phoneNum, validateCode.getCode());
    }
}
