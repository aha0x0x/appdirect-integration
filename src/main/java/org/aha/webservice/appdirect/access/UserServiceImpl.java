package org.aha.webservice.appdirect.access;

import java.util.UUID;
import org.aha.webservice.appdirect.Account;
import org.aha.webservice.appdirect.EventType;
import org.aha.webservice.appdirect.Flag;
import org.aha.webservice.appdirect.Notification;
import org.aha.webservice.appdirect.NotificationFetcher;
import org.aha.webservice.appdirect.User;
import org.aha.webservice.appdirect.ds.UsersDAO;
import org.aha.webservice.appdirect.subscription.ErrorResponse;
import org.aha.webservice.appdirect.subscription.Response;
import org.aha.webservice.appdirect.subscription.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    UsersDAO mUsersDAO;
    
    @Autowired 
    NotificationFetcher mFetcher;
    
    @Override
    public Response assignUser( String eventUrl )
    {
        try
        {
            Notification notification = mFetcher.fetch( eventUrl );
            if( notification.getType() != EventType.USER_ASSIGNMENT )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.INVALID_RESPONSE, "invalid notification" );
            }
            
            if( notification.getFlag() == Flag.STATELESS )
            {
                return new SuccessResponse();
            }
            
            User user = notification.getPayload().getUser();
            if( mUsersDAO.userExists( user.getEmail() ) )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.USER_ALREADY_EXISTS, "user already exists" );
            }
            
            Account account = notification.getPayload().getAccount();
            
            mUsersDAO.createUser( UUID.fromString( account.getAccountIdentifier() ), user.getEmail(), user.getFirstName(), user.getLastName() );
            
            return new SuccessResponse();
            
        }
        catch( Exception e )
        {
            return new ErrorResponse(ErrorResponse.ErrorCode.UNKNOWN_ERROR, e.toString() );
        }
        
        
    }

    @Override
    public Response unassignUser( String eventUrl )
    {
        
        try
        {
            Notification notification = mFetcher.fetch( eventUrl );
            if( notification.getType() != EventType.USER_UNASSIGNMENT )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.INVALID_RESPONSE, "invalid notification" );
            }
            
            if( notification.getFlag() == Flag.STATELESS )
            {
                return new SuccessResponse();
            }
            
            UUID id  = UUID.fromString( notification.getPayload().getAccount().getAccountIdentifier() );
            User user = notification.getPayload().getUser();
            
            if( mUsersDAO.deleteUser( id, user.getEmail() ) )
            {
                return new SuccessResponse( id.toString() );
            }
            
            return new ErrorResponse();
            
        }
        catch( Exception e )
        {
            return new ErrorResponse(ErrorResponse.ErrorCode.UNKNOWN_ERROR, e.toString() );
        }
        
    }
    
}
