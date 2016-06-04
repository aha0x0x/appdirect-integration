package org.aha.webservice.appdirect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder(
{
    "baseUrl",
    "partner"
})

public class Marketplace
{
    @JsonProperty("baseUrl")
    private String baseUrl;
    
    @JsonProperty("partner")
    private String partner;


    /**
     *
     * @return The baseUrl
     */
    @JsonProperty("baseUrl")
    public String getBaseUrl()
    {
        return baseUrl;
    }

    /**
     *
     * @param baseUrl The baseUrl
     */
    @JsonProperty("baseUrl")
    public void setBaseUrl( String baseUrl )
    {
        this.baseUrl = baseUrl;
    }

    /**
     *
     * @return The partner
     */
    @JsonProperty("partner")
    public String getPartner()
    {
        return partner;
    }

    /**
     *
     * @param partner The partner
     */
    @JsonProperty("partner")
    public void setPartner( String partner )
    {
        this.partner = partner;
    }

    @Override
    public String toString()
    {
        return "Marketplace{" + "baseUrl=" + baseUrl + ", partner=" + partner + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
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
        final Marketplace other = (Marketplace) obj;
        if ( !Objects.equals( this.baseUrl, other.baseUrl ) )
        {
            return false;
        }
        if ( !Objects.equals( this.partner, other.partner ) )
        {
            return false;
        }
        return true;
    }

    

}
