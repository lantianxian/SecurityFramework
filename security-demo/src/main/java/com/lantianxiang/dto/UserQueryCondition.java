package com.lantianxiang.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Create by Lantianxiang
 * Description: 用户查询条件
 * Create Date: 2018/12/25
 * Create Time: 14:49
 **/
public class UserQueryCondition  {

    private String username;

    @ApiModelProperty(value = "用户年龄起始值")
    private int ageStart;

    @ApiModelProperty(value = "用户年龄终止值")
    private int ageEnd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(int ageStart) {
        this.ageStart = ageStart;
    }

    public int getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(int ageEnd) {
        this.ageEnd = ageEnd;
    }
}
