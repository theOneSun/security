package com.sun.security.core.social.qq.connect;

import com.sun.security.core.social.qq.api.QQ;
import com.sun.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author sunjian.
 */
public class QQAdaptor implements ApiAdapter<QQ>
{
    @Override
    public boolean test(QQ api)
    {
        //todo 判断api是否可用(发请求判断)
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values)
    {
        QQUserInfo userInfo = api.getQQUserInfo();
        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        values.setProfileUrl(null);
        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ qq)
    {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s)
    {
        // do nothing
    }
}
