package com.sun.security.core.social.qq.connect;

import com.sun.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author sunjian.
 */
public class QQConnectorFactory extends OAuth2ConnectionFactory<QQ>
{
    public QQConnectorFactory(String providerId, String appId, String appSecret)
    {
        super(providerId, new QQServiceProvider(appId,appSecret), new QQAdaptor());
    }
}
