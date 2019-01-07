package com.lantianxiang.security.core.validate.code.image;

import com.lantianxiang.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * Create by Lantianxiang
 * Description: 图片验证码处理器
 * Create Date: 2019/1/4
 * Create Time: 11:34
 **/
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 发送图形验证码，将其以流的形式写到响应中
     * @param request
     * @param imageCode
     * @throws Exception
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
