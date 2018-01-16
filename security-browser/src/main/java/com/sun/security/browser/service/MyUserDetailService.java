package com.sun.security.browser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author sunjian.
 */
@Service
public class MyUserDetailService implements UserDetailsService
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        logger.info("登录的用户是:"+username);
        // TODO: 用户校验的逻辑
        return new User(username,"123",false,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList("role1,role2"));
    }
}
