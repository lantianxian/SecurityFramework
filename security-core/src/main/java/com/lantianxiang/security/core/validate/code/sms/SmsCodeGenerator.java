package com.lantianxiang.security.core.validate.code.sms;

import com.lantianxiang.security.core.properties.SecurityProperties;
import com.lantianxiang.security.core.validate.code.ValidateCode;
import com.lantianxiang.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Create by Lantianxiang
 * Description: 标准验证码生成器
 * Create Date: 2019/1/2
 * Create Time: 16:38
 **/
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private SecurityProperties securityProperties;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.security.core.validate.code.ValidateCodeGenerator#generate(org.
	 * springframework.web.context.request.ServletWebRequest)
	 */
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getValidateCodeProperties().getSmsCodeProperties().getLength());
		return new ValidateCode(code, securityProperties.getValidateCodeProperties().getSmsCodeProperties().getExpireIn());
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
	

}
