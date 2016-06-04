package org.aha.webservice.appdirect.subscription;

import java.util.UUID;
import org.aha.webservice.appdirect.Creator;
import org.aha.webservice.appdirect.EventType;
import org.aha.webservice.appdirect.Flag;
import org.aha.webservice.appdirect.Notification;
import org.aha.webservice.appdirect.NotificationFetcher;
import org.aha.webservice.appdirect.ds.SubscriptionDAO;
import org.aha.webservice.appdirect.ds.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class SubscriptionServiceImpl implements SubscriptionService
{
    @Autowired 
    NotificationFetcher mFetcher;

    @Autowired
    SubscriptionDAO mSubscriptionDAO;
    
    @Autowired
    UsersDAO mUsersDAO;
    
    @Override
    public Response create( String eventUrl )
    {
        try
        {
            Notification notification = mFetcher.fetch( eventUrl );
            if( notification.getType() != EventType.SUBSCRIPTION_ORDER )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.INVALID_RESPONSE, "invalid notification" );
            }
            
            if( notification.getFlag() == Flag.STATELESS )
            {
                return new SuccessResponse();
            }
            
            Creator creator = notification.getCreator();
            if( mUsersDAO.doesUserExist( creator.getEmail() ) )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.USER_ALREADY_EXISTS, "user already exists" );
            }

            
            UUID uuid = mSubscriptionDAO.create(  notification.getPayload().getCompany().getName(), 
                                                  notification.getPayload().getOrder().getEditionCode(),
                                                  notification.getMarketplace().getBaseUrl() );
            
            
            mUsersDAO.createUser( uuid, creator.getEmail(), creator.getFirstName(), creator.getLastName() );
            return new SuccessResponse( uuid.toString() );
        }
        catch( Exception e )
        {
            System.out.println( e );
            return new ErrorResponse( ErrorResponse.ErrorCode.UNKNOWN_ERROR, "failed to add user" );
        }
        
    }

    @Override
    public Response change( String eventUrl )
    {
        try
        {
            Notification notification = mFetcher.fetch( eventUrl );
            if( notification.getType() != EventType.SUBSCRIPTION_CHANGE )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.INVALID_RESPONSE, "invalid notification" );
            }
            
            if( notification.getFlag() == Flag.STATELESS )
            {
                return new SuccessResponse();
            }
               
            UUID id = UUID.fromString( notification.getPayload().getAccount().getAccountIdentifier() );
            String editionCode = notification.getPayload().getOrder().getEditionCode();
            
            if( ! mSubscriptionDAO.subscriptionExists( id ) )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.ACCOUNT_NOT_FOUND, "account not found" );
            }
            
            if( mSubscriptionDAO.changeEdition( id, editionCode ) )
            {
                return new SuccessResponse();
            }
            else
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.UNKNOWN_ERROR, "failed to update" );
            }
        }
        catch( Exception e )
        {
            return new ErrorResponse( ErrorResponse.ErrorCode.UNKNOWN_ERROR, "failed to update" );
        }
    }

    @Override
    public Response cancel( String eventUrl )
    {
        try
        {
            Notification notification = mFetcher.fetch( eventUrl );
            if( notification.getType() != EventType.SUBSCRIPTION_CANCEL )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.INVALID_RESPONSE, "invalid notification" );
            }
            
            if( notification.getFlag() == Flag.STATELESS )
            {
                return new SuccessResponse();
            }
            
            
            UUID id = UUID.fromString( notification.getPayload().getAccount().getAccountIdentifier() );
            if( mSubscriptionDAO.delete( id ) )
            {
                return new SuccessResponse();
            }
            
            return new ErrorResponse();
            
        }
        catch( Exception e )
        {
            return new ErrorResponse( ErrorResponse.ErrorCode.UNKNOWN_ERROR, "failed to cancel" );
        }
    }
    
    
    @Override
    public Response notice( String eventUrl )
    {
        try
        {
            Notification notification = mFetcher.fetch( eventUrl );
            if( notification.getType() != EventType.SUBSCRIPTION_CANCEL )
            {
                return new ErrorResponse( ErrorResponse.ErrorCode.INVALID_RESPONSE, "invalid notification" );
            }
            
            if( notification.getFlag() == Flag.STATELESS )
            {
                return new SuccessResponse();
            }

            
            UUID id = UUID.fromString( notification.getPayload().getAccount().getAccountIdentifier() );
            switch( notification.getPayload().getNotice() )
            {
                case CLOSED:
                    if( mSubscriptionDAO.delete( id ) )
                    {
                        return new SuccessResponse();
                    }
                    break;
                case DEACTIVATED:
                case REACTIVATED:
                case UPCOMING_INVOICE:
                {
                    if( mSubscriptionDAO.changeNotice( id, notification.getPayload().getNotice() ) )
                    {
                        return new SuccessResponse();
                    }
                    return new ErrorResponse();
                }
            }
        }
        catch( Exception e )
        {
            System.out.println();
            return new ErrorResponse();
        }
        return new ErrorResponse();
    }
    
    


    

}
