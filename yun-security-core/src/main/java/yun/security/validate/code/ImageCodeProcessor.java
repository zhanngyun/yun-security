package yun.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;
import yun.security.validate.AbstractValidateCodeProcessor;

import javax.imageio.ImageIO;

/**
 * @Author: yzhang
 * @Date: 2018/3/7 15:23
 */
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {


    /**
     * 发送图形验证码，将其写到响应中
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
