package yun.security.social.qq.connet;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import yun.security.social.qq.api.QQ;
import yun.security.social.qq.api.QQImpl;

/**
 * @Author: yzhang
 * @Date: 2018/3/9 17:19
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    private static final String URL_ACCESSTOKEN = "https://graph.qq.com/oauth2.0/token";


    public QQServiceProvider(String appid, String clientSecret) {
        super(new OAuth2Template(appid,clientSecret,URL_AUTHORIZE,URL_ACCESSTOKEN));
        this.appid = appid;
    }

    private String appid;

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken,appid);
    }
}
