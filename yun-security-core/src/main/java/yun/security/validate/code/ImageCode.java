package yun.security.validate.code;

import yun.security.validate.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author: yzhang
 * @Date: 2018/3/7 13:17
 * 图形验证码
 */
public class ImageCode extends ValidateCode{


    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn){
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
