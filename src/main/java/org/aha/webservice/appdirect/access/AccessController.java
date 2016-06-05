package org.aha.webservice.appdirect.access;

import org.aha.webservice.appdirect.subscription.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("access")
public class AccessController
{
    @Autowired
    private UserService mUserService;
    
    @RequestMapping("assign")
    public Response assign( @RequestParam(value="url") String eventUrl ) 
    {
        return mUserService.assignUser( eventUrl );
    }
    
    @RequestMapping("unassign")
    public Response unassign( @RequestParam(value="url") String eventUrl ) 
    {
        return mUserService.unassignUser( eventUrl );
    }
}
