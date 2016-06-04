package org.aha.webservice.appdirect.access;

import org.aha.webservice.appdirect.subscription.Response;


public interface UserService
{
    Response assignUser( String eventUrl );
    Response unassignUser( String eventUrl );
}
