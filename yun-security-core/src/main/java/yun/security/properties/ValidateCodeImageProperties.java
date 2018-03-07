package yun.security.properties;

/**
 * @Author: yzhang
 * @Date: 2018/3/7 14:23
 */
public class ValidateCodeImageProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    SmsCodeProperties sms = new SmsCodeProperties();


    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }

    public SmsCodeProperties getSms() {
        return sms;
    }

    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }
}
