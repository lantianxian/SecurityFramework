package com.lantianxiang.security.browser;

import com.lantianxiang.security.browser.support.SimpleResponse;
import com.lantianxiang.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by Lantianxiang
 * Description: 处理身份认证请求
 * Create Date: 2018/12/27
 * Create Time: 14:48
 **/
@RestController
public class BrowserSecurityController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份验证时，跳转到此
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response){

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null){
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是：{}", targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")){
                try {
                    redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页面");
    }
}
