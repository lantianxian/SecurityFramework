package com.lantianxiang.security.core.authentication;

import com.lantianxiang.security.core.validate.code.utils.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Create by Lantianxiang
 * Description: TODO
 * Create Date: 2019/1/7
 * Create Time: 11:00
 **/
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler lanAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler lanAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin()
                        .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                        .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                        .successHandler(lanAuthenticationSuccessHandler)
                        .failureHandler(lanAuthenticationFailureHandler);
    }
}
