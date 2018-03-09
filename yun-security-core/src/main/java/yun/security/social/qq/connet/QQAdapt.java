package yun.security.social.qq.connet;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import yun.security.social.qq.api.QQ;
import yun.security.social.qq.api.QQUserInfo;

/**
 * @Author: yzhang
 * @Date: 2018/3/9 17:31
 */
public class QQAdapt implements ApiAdapter<QQ> {
    @Override
    public boolean test(QQ qq) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {

        QQUserInfo userInfo = api.getUserInfo();

        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        values.setProfileUrl(null);
        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s) {
        //do nothing
    }
}
