package com.lantianxiang.security.core.properties;

/**
 * Create by Lantianxiang
 * Description: 与浏览器相关的配置项
 * Create Date: 2018/12/27
 * Create Time: 15:25
 **/
public class BrowserProperties {

    //默认的标准登录页，如果未配置自定义登录页，则登录到此
    private String loginPage = "/login.html";

    //默认使用返回JSON的方式
    private LoginType loginType = LoginType.JSON;

    //秒数
    private int rememberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
