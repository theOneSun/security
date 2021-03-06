package com.sun.security.core.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;
import javax.swing.*;

/**
 * @author sunjian.
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter
{
    private final DataSource dataSource;

    @Autowired
    public SocialConfig(@Qualifier("dataSource") DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator)
    {
        return new JdbcUsersConnectionRepository(dataSource,connectionFactoryLocator, Encryptors.noOpText());
    }
    @Bean
    public SpringSocialConfigurer socialSecurityConfigurer(){
        return new SpringSocialConfigurer();
    }
}
