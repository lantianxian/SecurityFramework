package com.lantianxiang.security.core.validate.code.image;

import com.lantianxiang.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Create by Lantianxiang
 * Description: 图形验证码类
 * Create Date: 2018/12/29
 * Create Time: 10:38
 **/
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


}
