package com.lantianxiang.security.core.validate.code.utils;


import com.lantianxiang.security.core.validate.code.utils.SecurityConstants;

/**
 * create by Lantianxiang
 * Description: 验证码类型枚举
 * create date: 2019/1/4
 * create time: 10:37
 **/
public enum ValidateCodeType {

    /**
     * 短信验证码
     */
    SMS{
        public String getParamNameOnValidate(){
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },

    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     * @return
     */
    public abstract String getParamNameOnValidate();
}
