package com.lantianxiang.security.core.properties;

/**
 * Create by Lantianxiang
 * Description: TODO
 * Create Date: 2019/1/2
 * Create Time: 16:38
 **/
public class ImageCodeProperties extends SmsCodeProperties {

    private int width = 67;
    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
