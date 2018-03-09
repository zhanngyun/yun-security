package yun.security.social.qq.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @Author: yzhang
 * @Date: 2018/3/9 17:40
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory {

    public QQConnectionFactory(String providerId, String appId,String appSecret) {
        super(providerId, new QQServiceProvider(appId,appSecret), new QQAdapt());
    }
}
