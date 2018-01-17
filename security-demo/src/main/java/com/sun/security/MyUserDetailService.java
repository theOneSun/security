package com.sun.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author sunjian.
 */
@Service
public class MyUserDetailService implements UserDetailsService,SocialUserDetailsService
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        logger.info("登录的用户是:"+username);
        // TODO: 用户校验的逻辑
        return new User(username,"123",true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList("role1,role2"));
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException
    {
        logger.info("登录的用户id是:"+userId);
        // TODO: 用户校验的逻辑
        return new SocialUser(userId,"123",true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList("role1,role2"));
    }
}
