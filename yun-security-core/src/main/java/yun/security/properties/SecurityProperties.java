package yun.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: yzhang
 * @Date: 2018/3/6 16:41
 */

@ConfigurationProperties(prefix = "yun.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeImageProperties code = new ValidateCodeImageProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeImageProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeImageProperties code) {
        this.code = code;
    }
}
