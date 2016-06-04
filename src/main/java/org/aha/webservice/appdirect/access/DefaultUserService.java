package org.aha.webservice.appdirect.access;

import org.aha.webservice.appdirect.subscription.Response;
import org.springframework.stereotype.Service;


@Service
public class DefaultUserService implements UserService
{

    @Override
    public Response assignUser( String eventUrl )
    {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response updateUser( String eventUrl )
    {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response unassignUser( String eventUrl )
    {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }
    
}
