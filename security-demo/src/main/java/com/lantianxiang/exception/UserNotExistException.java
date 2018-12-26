package com.lantianxiang.exception;

/**
 * Create by Lantianxiang
 * Description: user not exit 异常类
 * Create Date: 2018/12/25
 * Create Time: 13:39
 **/
public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id){
        super("user not exit");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
