package org.aha.webservice.appdirect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder(
{
    "address",
    "email",
    "firstName",
    "language",
    "lastName",
    "openId",
    "uuid"
})
public class Creator
{
    @JsonProperty("address")
    private Address address;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("firstName")
    private String firstName;
    
    @JsonProperty("language")
    private String language;
    
    @JsonProperty("lastName")
    private String lastName;
    
    @JsonProperty("openId")
    private String openId;
    
    @JsonProperty("uuid")
    private String uuid;

    /**
     *
     * @return The address
     */
    @JsonProperty("address")
    public Address getAddress()
    {
        return address;
    }

    /**
     *
     * @param address The address
     */
    @JsonProperty("address")
    public void setAddress( Address address )
    {
        this.address = address;
    }

    /**
     *
     * @return The email
     */
    @JsonProperty("email")
    public String getEmail()
    {
        return email;
    }

    /**
     *
     * @param email The email
     */
    @JsonProperty("email")
    public void setEmail( String email )
    {
        this.email = email;
    }

    /**
     *
     * @return The firstName
     */
    @JsonProperty("firstName")
    public String getFirstName()
    {
        return firstName;
    }

    /**
     *
     * @param firstName The firstName
     */
    @JsonProperty("firstName")
    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    /**
     *
     * @return The language
     */
    @JsonProperty("language")
    public String getLanguage()
    {
        return language;
    }

    /**
     *
     * @param language The language
     */
    @JsonProperty("language")
    public void setLanguage( String language )
    {
        this.language = language;
    }

    /**
     *
     * @return The lastName
     */
    @JsonProperty("lastName")
    public String getLastName()
    {
        return lastName;
    }

    /**
     *
     * @param lastName The lastName
     */
    @JsonProperty("lastName")
    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    /**
     *
     * @return The openId
     */
    @JsonProperty("openId")
    public String getOpenId()
    {
        return openId;
    }

    /**
     *
     * @param openId The openId
     */
    @JsonProperty("openId")
    public void setOpenId( String openId )
    {
        this.openId = openId;
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

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode( this.address );
        hash = 17 * hash + Objects.hashCode( this.email );
        hash = 17 * hash + Objects.hashCode( this.firstName );
        hash = 17 * hash + Objects.hashCode( this.language );
        hash = 17 * hash + Objects.hashCode( this.lastName );
        hash = 17 * hash + Objects.hashCode( this.openId );
        hash = 17 * hash + Objects.hashCode( this.uuid );
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
        final Creator other = (Creator) obj;
        if ( !Objects.equals( this.email, other.email ) )
        {
            return false;
        }
        if ( !Objects.equals( this.firstName, other.firstName ) )
        {
            return false;
        }
        if ( !Objects.equals( this.language, other.language ) )
        {
            return false;
        }
        if ( !Objects.equals( this.lastName, other.lastName ) )
        {
            return false;
        }
        if ( !Objects.equals( this.openId, other.openId ) )
        {
            return false;
        }
        if ( !Objects.equals( this.uuid, other.uuid ) )
        {
            return false;
        }
        if ( !Objects.equals( this.address, other.address ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Creator{" + "address=" + address + ", email=" + email + ", firstName=" + firstName 
               + ", language=" + language + ", lastName=" + lastName + ", openId=" + openId + ", uuid=" + uuid + '}';
    }
}
