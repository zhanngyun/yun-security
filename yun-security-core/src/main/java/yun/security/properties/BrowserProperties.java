package yun.security.properties;

/**
 * @Author: yzhang
 * @Date: 2018/3/6 16:41
 */
public class BrowserProperties {

    private String loginPage = "/signIn.html";//默认配置


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
