package com.sun.security.core.social.qq.config;

import com.sun.security.core.properties.QQProperties;
import com.sun.security.core.properties.SecurityProperties;
import com.sun.security.core.social.qq.connect.QQConnectorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author sunjian.
 */
@Configuration
@ConditionalOnProperty(prefix = "com.sun.security.social.qq",name = "app-id") // com.sun.security.social.qq.app-id有值才会进行下面的配置
public class QQAutoConfig extends SocialAutoConfigurerAdapter
{
    private final SecurityProperties securityProperties;

    @Autowired
    public QQAutoConfig(SecurityProperties securityProperties)
    {
        this.securityProperties = securityProperties;
    }

    @Override
    protected ConnectionFactory<?> createConnectionFactory()
    {
        QQProperties qqConfig = securityProperties.getSocialProperties().getQq();
        return new QQConnectorFactory(qqConfig.getProviderId(),qqConfig.getAppId(),qqConfig.getAppSecret());
    }
}
