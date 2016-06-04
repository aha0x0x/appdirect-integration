package org.aha.webservice.appdirect.subscription;

/**
 * This service will encapsulate the subscription behavior
 * https://docs.appdirect.com/developer/distribution/event-notifications/subscription-events
 * 
 */
public interface SubscriptionService
{
    Response create( String eventUrl );
    Response change( String eventUrl );
    Response cancel( String eventUrl );
    Response notice( String eventUrl );
    
    


}
