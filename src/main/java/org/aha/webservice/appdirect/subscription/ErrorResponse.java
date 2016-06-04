package org.aha.webservice.appdirect.subscription;

public class ErrorResponse implements Response
{
    public enum ErrorCode
    {
        USER_ALREADY_EXISTS,
        USER_NOT_FOUND,
        ACCOUNT_NOT_FOUND,
        MAX_USERS_REACHED,
        UNAUTHORIZED,
        OPERATION_CANCELED,
        CONFIGURATION_ERROR,
        INVALID_RESPONSE,
        PENDING,
        FORBIDDEN,
        BINDING_NOT_FOUND,
        TRANSPORT_ERROR,
        UNKNOWN_ERROR
    }
    
    public boolean success;
    public ErrorCode errorCode; 
    public String message;
    
    public ErrorResponse()
    {
        success = false;
        errorCode = ErrorCode.UNKNOWN_ERROR;
        message = null;
    }
    
    public ErrorResponse( ErrorCode errorCode, String message )
    {
        success = false;
        this.errorCode = errorCode;
        this.message = message;
    }
}
