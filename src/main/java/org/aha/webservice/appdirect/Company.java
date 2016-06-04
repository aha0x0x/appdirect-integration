package org.aha.webservice.appdirect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
{
    "country",
    "name",
    "phoneNumber",
    "uuid",
    "website"
})

public class Company
{
    @JsonProperty("country")
    private String country;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    
    @JsonProperty("uuid")
    private String uuid;
    
    @JsonProperty("website")
    private String website;
    
    /**
     *
     * @return The country
     */
    @JsonProperty("country")
    public String getCountry()
    {
        return country;
    }

    /**
     *
     * @param country The country
     */
    @JsonProperty("country")
    public void setCountry( String country )
    {
        this.country = country;
    }

    /**
     *
     * @return The name
     */
    @JsonProperty("name")
    public String getName()
    {
        return name;
    }

    /**
     *
     * @param name The name
     */
    @JsonProperty("name")
    public void setName( String name )
    {
        this.name = name;
    }

    /**
     *
     * @return The phoneNumber
     */
    @JsonProperty("phoneNumber")
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber The phoneNumber
     */
    @JsonProperty("phoneNumber")
    public void setPhoneNumber( String phoneNumber )
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return The uuid
     */
    @JsonProperty("uuid")
    public String getUuid()
    {
        return uuid;
    }

    /**
     *
     * @param uuid The uuid
     */
    @JsonProperty("uuid")
    public void setUuid( String uuid )
    {
        this.uuid = uuid;
    }

    /**
     *
     * @return The website
     */
    @JsonProperty("website")
    public String getWebsite()
    {
        return website;
    }

    /**
     *
     * @param website The website
     */
    @JsonProperty("website")
    public void setWebsite( String website )
    {
        this.website = website;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode( this.country );
        hash = 23 * hash + Objects.hashCode( this.name );
        hash = 23 * hash + Objects.hashCode( this.phoneNumber );
        hash = 23 * hash + Objects.hashCode( this.uuid );
        hash = 23 * hash + Objects.hashCode( this.website );
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
        final Company other = (Company) obj;
        if ( !Objects.equals( this.country, other.country ) )
        {
            return false;
        }
        if ( !Objects.equals( this.name, other.name ) )
        {
            return false;
        }
        if ( !Objects.equals( this.phoneNumber, other.phoneNumber ) )
        {
            return false;
        }
        if ( !Objects.equals( this.uuid, other.uuid ) )
        {
            return false;
        }
        if ( !Objects.equals( this.website, other.website ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Company{" + "country=" + country + ", name=" + name + ", phoneNumber=" + phoneNumber + ", uuid=" + uuid + ", website=" + website + '}';
    }
}
