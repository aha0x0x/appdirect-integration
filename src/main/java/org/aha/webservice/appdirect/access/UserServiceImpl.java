package org.aha.webservice.appdirect.access;

import java.util.UUID;
import org.aha.webservice.appdirect.Account;
import org.aha.webservice.appdirect.EventType;
import org.aha.webservice.appdirect.Flag;
import org.aha.webservice.appdirect.Notification;
import org.aha.webservice.appdirect.NotificationFetcher;
import org.aha.webservice.appdirect.User;
import org.aha.webservice.appdirect.ds.SubscriptionDAO;
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
    SubscriptionDAO mSubscriptionDAO;
    
    @Autowired
    UsersDAO mUsersDAO;
    
    @Autowired 
    NotificationFetcher mFetcher;
    
    /**
     * Assigns a new user to a given subscription id 
     * @param eventUrl
     * @return success if user is created else failure
     */
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
            
            Account account = notification.getPayload().getAccount();
            UUID id = UUID.fromString( account.getAccountIdentifier() );
            if( !mSubscriptionDAO.subscriptionExists( id ) )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.ACCOUNT_NOT_FOUND, "account not found " );
            }
            
            
            User user = notification.getPayload().getUser();
            if( mUsersDAO.userExists( user.getEmail() ) )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.USER_ALREADY_EXISTS, "user already exists" );
            }
            
            mUsersDAO.createUser( id, user.getEmail(), user.getFirstName(), user.getLastName() );
            return new SuccessResponse( id.toString() );
            
        }
        catch( Exception e )
        {
            return new ErrorResponse(ErrorResponse.ErrorCode.UNKNOWN_ERROR, e.toString() );
        }
        
        
    }

    
    /**
     * Unassigns and deletes a user given a subscription id
     * @param eventUrl
     * @return success if user is deleted else false. 
     */
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
            
            if( !mUsersDAO.userExists( id, user.getEmail() ) )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.USER_NOT_FOUND, "user not found" );
            }
            
            if( mUsersDAO.deleteUser( id, user.getEmail() ) )
            
            if( mUsersDAO.deleteUser( UUID.fromString( "9268ceae-5309-4bdd-a88b-04eeadc2210e" ), "john.doe@yahoo.com" ) )
            {
                return new SuccessResponse();
            }
            
            return new ErrorResponse(ErrorResponse.ErrorCode.UNKNOWN_ERROR, "failed to remove user" );
            
        }
        catch( Exception e )
        {
            return new ErrorResponse(ErrorResponse.ErrorCode.UNKNOWN_ERROR, e.toString() );
        }
        
    }
    
}
