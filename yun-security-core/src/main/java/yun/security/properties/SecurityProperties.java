package yun.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: yzhang
 * @Date: 2018/3/6 16:41
 */

@ConfigurationProperties(prefix = "yun.security")
public class SecurityProperties {

    BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
