package com.lantianxiang.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Create by Lantianxiang
 * Description: 框架的配置信息
 * Create Date: 2018/12/27
 * Create Time: 15:30
 **/
@ConfigurationProperties(prefix = "com.security.browser")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties validateCodeProperties = new ValidateCodeProperties();

    public ValidateCodeProperties getValidateCodeProperties() {
        return validateCodeProperties;
    }

    public void setValidateCodeProperties(ValidateCodeProperties validateCodeProperties) {
        this.validateCodeProperties = validateCodeProperties;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
