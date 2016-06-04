package org.aha.webservice.appdirect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
{
    "company",
    "order",
    "account",
    "notice"
})

public class Payload
{

    @JsonProperty("company")
    private Company company;
    
    @JsonProperty("order")
    private Order order;
    
    @JsonProperty("account")
    private Account account;
    
    @JsonProperty("notice")
    private Notice notice;
    
    
    /**
     *
     * @return The company
     */
    @JsonProperty("company")
    public Company getCompany()
    {
        return company;
    }

    /**
     *
     * @param company The company
     */
    @JsonProperty("company")
    public void setCompany( Company company )
    {
        this.company = company;
    }
    
    
    /**
     *
     * @return The Order
     */
    @JsonProperty("order")
    public Order getOrder()
    {
        return order;
    }

    /**
     *
     * @param order The order
     */
    @JsonProperty("order")
    public void setOrder( Order order )
    {
        this.order = order;
    }
    
    
    /**
     *
     * @return The Account
     */
    @JsonProperty("account")
    public Account getAccount()
    {
        return account;
    }

    /**
     *
     * @param account The Account
     */
    @JsonProperty("account")
    public void setAccount( Account account )
    {
        this.account = account;
    }
    
    /**
     *
     * @return The notice
     */
    @JsonProperty("notice")
    public Notice getNotice()
    {
        return notice;
    }

    /**
     *
     * @param notice The notice
     */
    @JsonProperty("notice")
    public void setNotice( Notice notice )
    {
        this.notice = notice;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode( this.company );
        hash = 97 * hash + Objects.hashCode( this.order );
        hash = 97 * hash + Objects.hashCode( this.account );
        hash = 97 * hash + Objects.hashCode( this.notice );
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
        final Payload other = (Payload) obj;
        if ( !Objects.equals( this.company, other.company ) )
        {
            return false;
        }
        if ( !Objects.equals( this.order, other.order ) )
        {
            return false;
        }
        if ( !Objects.equals( this.account, other.account ) )
        {
            return false;
        }
        if ( this.notice != other.notice )
        {
            return false;
        }
        return true;
    }

    
}