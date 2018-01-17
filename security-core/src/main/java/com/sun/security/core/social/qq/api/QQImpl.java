package com.sun.security.core.social.qq.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * @author sunjian.
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ
{
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
    private String appId;
    private String openId;
    private ObjectMapper objectMapper = new ObjectMapper();

    public QQImpl(String accessToken, String appId)
    {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);
        this.openId = StringUtils.substringBetween(result, "\"openid\":", "}");
    }

    @Override
    public QQUserInfo getQQUserInfo()
    {
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);
        try
        {
            return objectMapper.readValue(result,QQUserInfo.class);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("获取用户信息失败");
        }
    }
}
