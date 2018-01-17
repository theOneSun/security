package com.sun.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author sunjian.
 */
public class QQProperties extends SocialProperties
{
//    private String appId;
//    private String appSecret;
    private String providerId = "qq";

    public String getProviderId()
    {
        return providerId;
    }

    public void setProviderId(String providerId)
    {
        this.providerId = providerId;
    }
}
