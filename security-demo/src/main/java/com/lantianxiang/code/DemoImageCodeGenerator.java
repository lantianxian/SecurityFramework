package com.lantianxiang.code;

import com.lantianxiang.security.core.validate.code.image.ImageCode;
import com.lantianxiang.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Create by Lantianxiang
 * Description: TODO
 * Create Date: 2019/1/3
 * Create Time: 11:30
 **/
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
