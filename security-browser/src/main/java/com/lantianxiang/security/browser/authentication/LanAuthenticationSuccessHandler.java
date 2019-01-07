package com.lantianxiang.security.browser.authentication;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lantianxiang.security.core.properties.LoginType;
import com.lantianxiang.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by Lantianxiang
 * Description: 自定义处理成功的身份验证
 * Create Date: 2018/12/27
 * Create Time: 16:55
 **/
@Component("lanAuthenticationSuccessHandler")
public class LanAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功");

        //如果是JSON格式，则返回JSON，否则跳转页面
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(mapper.writeValueAsString(authentication));
        }else {
            super.onAuthenticationSuccess(request, response, authentication);
        }


    }
}
