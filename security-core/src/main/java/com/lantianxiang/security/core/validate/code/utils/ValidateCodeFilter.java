package com.lantianxiang.security.core.validate.code.utils;

import com.lantianxiang.security.core.properties.SecurityProperties;
import com.lantianxiang.security.core.validate.code.ValidateCodeProcessorHolder;
import com.lantianxiang.security.core.validate.code.exception.ValidateCodeException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Create by Lantianxiang
 * Description: 图片验证码过滤器
 * Create Date: 2018/12/29
 * Create Time: 11:22
 **/
@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 系统中的校验码处理器
     */
    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 存放所有需要校验验证码的url
     */
    private Map<String, ValidateCodeType> urlMap = new HashMap<>();

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 初始化要拦截的url配置信息
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();

        urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
        addUrlToMap(securityProperties.getValidateCodeProperties().getProperties().getUrl(), ValidateCodeType.IMAGE);

        urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, ValidateCodeType.SMS);
        addUrlToMap(securityProperties.getValidateCodeProperties().getSmsCodeProperties().getUrl(), ValidateCodeType.SMS);
    }

    /**
     * 系统中配置的需要校验验证码的URL根据校验的类型放入map
     * @param urlString
     * @param type
     */
    protected void addUrlToMap(String urlString, ValidateCodeType type) {
        if (StringUtils.isNotBlank(urlString)) {
            String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
            for (String url : urls) {
                urlMap.put(url, type);
            }
        }
    }

    /**
     * 执行过滤
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        ValidateCodeType type = getValidateCodeType(request);
        if (type != null){
            logger.info("校验请求({}),中的验证码，验证码的类型为：{}", request.getRequestURI(), type);
            try{
                validateCodeProcessorHolder.findValidateCodeProcessor(type).validate(new ServletWebRequest(request, response));
            }catch (ValidateCodeException e){
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * 获取校验码的类型，如果当前请求不需要校验，则返回null
     * @param request
     * @return
     */
    private ValidateCodeType getValidateCodeType(HttpServletRequest request) {
        ValidateCodeType result = null;
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), "get")) {
            Set<String> urls = urlMap.keySet();
            for (String url : urls) {
                if (pathMatcher.match(url, request.getRequestURI())) {
                    result = urlMap.get(url);
                }
            }
        }
        return result;
    }
}
