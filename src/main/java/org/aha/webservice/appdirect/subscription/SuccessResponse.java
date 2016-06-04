package org.aha.webservice.appdirect.subscription;

public class SuccessResponse implements Response
{
    public String accountIdentifier;
    public boolean success;
    
    public SuccessResponse()
    {
        accountIdentifier = null;
        success = true;
    }
    
    public SuccessResponse( String accountId )
    {
        this.accountIdentifier = accountId;
        success = true;
    }
}
