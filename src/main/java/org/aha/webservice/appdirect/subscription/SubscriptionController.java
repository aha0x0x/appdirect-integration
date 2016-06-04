package org.aha.webservice.appdirect.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subscription")
public class SubscriptionController 
{
    @Autowired
    SubscriptionService mSubscriptionService;
    
    
    
    @RequestMapping("create")
    public Response create( @RequestParam(value="url") String eventUrl ) 
    {
        return mSubscriptionService.create( eventUrl );
    }
    
    @RequestMapping("change")
    public Response change( @RequestParam(value="url") String eventUrl ) 
    {
        return mSubscriptionService.change( eventUrl );
    }
    
    @RequestMapping("cancel")
    public Response cancel( @RequestParam(value="url") String eventUrl ) 
    {
        return mSubscriptionService.cancel(eventUrl );
    }
    
    @RequestMapping("notice")
    public Response notice( @RequestParam(value="url") String eventUrl ) 
    {
        return mSubscriptionService.notice( eventUrl );
    }
    
    
    
}