package com.lantianxiang.security.core.validate.code;

import com.lantianxiang.security.core.properties.SecurityProperties;
import com.lantianxiang.security.core.validate.code.image.ImageCodeGenerator;
import com.lantianxiang.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.lantianxiang.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by Lantianxiang
 * Description: 验证码生成器
 * Create Date: 2019/1/2
 * Create Time: 18:27
 **/
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 图片验证码生成器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator(){
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    /**
     * 短信验证码发送器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender(){
        return new DefaultSmsCodeSender();
    }
}
