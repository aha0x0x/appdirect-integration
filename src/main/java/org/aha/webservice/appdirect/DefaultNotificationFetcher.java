package org.aha.webservice.appdirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth.consumer.client.OAuthRestTemplate;
import org.springframework.stereotype.Service;

@Service
public class DefaultNotificationFetcher implements NotificationFetcher
{
    
    @Autowired
    OAuthRestTemplate mAuthRestTemplate;
    
    public Notification fetch( String url )
    {
        return mAuthRestTemplate.getForObject( url, Notification.class );
    }
    

}
