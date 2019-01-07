package com.lantianxiang.security.browser.support;

/**
 * Create by Lantianxiang
 * Description: 封装返回值的简单JSON对象（字符串，基本类型，对象）
 * Create Date: 2018/12/27
 * Create Time: 15:14
 **/
public class SimpleResponse {

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
