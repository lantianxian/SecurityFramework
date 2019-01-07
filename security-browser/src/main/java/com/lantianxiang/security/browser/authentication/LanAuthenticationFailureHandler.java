package com.lantianxiang.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lantianxiang.security.browser.support.SimpleResponse;
import com.lantianxiang.security.core.properties.LoginType;
import com.lantianxiang.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by Lantianxiang
 * Description: 自定义处理失败的身份验证
 * Create Date: 2018/12/28
 * Create Time: 15:49
 **/
@Component("lanAuthenticationFailureHandler")
public class LanAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        logger.info("登录失败");

        //如果是JSON格式，则返回JSON，否则跳转页面
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(mapper.writeValueAsString(new SimpleResponse(e.getMessage())));
        }else {
            super.onAuthenticationFailure(request, response, e);
        }
    }
}
