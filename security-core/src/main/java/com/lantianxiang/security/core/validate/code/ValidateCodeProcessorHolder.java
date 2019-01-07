package com.lantianxiang.security.core.validate.code;

import com.lantianxiang.security.core.validate.code.exception.ValidateCodeException;
import com.lantianxiang.security.core.validate.code.utils.ValidateCodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Create by Lantianxiang
 * Description: 获取校验码处理器
 * Create Date: 2019/1/4
 * Create Time: 11:42
 **/
@Component
public class ValidateCodeProcessorHolder {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * 获取验证码处理器
     * @param type
     * @return
     */
    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    /**
     * 获取验证码处理器
     * @param type
     * @return
     */
    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }
}
