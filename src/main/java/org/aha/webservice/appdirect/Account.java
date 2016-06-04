package org.aha.webservice.appdirect;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
public class Account
{

    @JsonProperty("accountIdentifier")
    private String accountIdentifier;
    @JsonProperty("status")
    private String status;
    
    /**
     *
     * @return The accountIdentifier
     */
    @JsonProperty("accountIdentifier")
    public String getAccountIdentifier()
    {
        return accountIdentifier;
    }

    /**
     *
     * @param accountIdentifier The accountIdentifier
     */
    @JsonProperty("accountIdentifier")
    public void setAccountIdentifier( String accountIdentifier )
    {
        this.accountIdentifier = accountIdentifier;
    }

    /**
     *
     * @return The status
     */
    @JsonProperty("status")
    public String getStatus()
    {
        return status;
    }

    /**
     *
     * @param status The status
     */
    @JsonProperty("status")
    public void setStatus( String status )
    {
        this.status = status;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass() != obj.getClass() )
        {
            return false;
        }
        final Account other = (Account) obj;
        if ( !Objects.equals( this.accountIdentifier, other.accountIdentifier ) )
        {
            return false;
        }
        if ( !Objects.equals( this.status, other.status ) )
        {
            return false;
        }
        return true;
    }
    
    
    
    
}
