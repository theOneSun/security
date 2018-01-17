package com.sun.security.core.properties;

/**
 * @author sunjian.
 */
public class SecurityProperties
{
    private SocialProperties socialProperties = new SocialProperties();

    public SocialProperties getSocialProperties()
    {
        return socialProperties;
    }

    public void setSocialProperties(SocialProperties socialProperties)
    {
        this.socialProperties = socialProperties;
    }
}
