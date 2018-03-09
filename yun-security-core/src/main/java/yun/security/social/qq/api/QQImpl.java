package yun.security.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * @Author: yzhang
 * @Date: 2018/3/9 16:44
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=12345&openid=%s";


    private ObjectMapper objectMapper = new ObjectMapper();
    private String openid;
    private String appid;

    public QQImpl(String accessToken,String appid){
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appid = appid;


        String url = String.format(URL_GET_OPENID,accessToken);
        String result = getRestTemplate().getForObject(url, String.class);

        this.openid = StringUtils.substringBetween(result,"\"openid:\"","}");
    }

    @Override
    public QQUserInfo getUserInfo() {

        String url = String.format(URL_GET_USERINFO,appid,openid);
        String result = getRestTemplate().getForObject(url, String.class);
        try {
            return objectMapper.readValue(result, QQUserInfo.class);
        }catch (Exception e){
            throw new RuntimeException("获取用户信息失败",e);
        }

    }
}
