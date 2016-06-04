package org.aha.webservice.appdirect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    {
        "firstName",
        "fullName",
        "lastName"
    })

public class Address
{

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("lastName")
    private String lastName;

    

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
     * @return The fullName
     */
    @JsonProperty("fullName")
    public String getFullName()
    {
        return fullName;
    }

    /**
     *
     * @param fullName The fullName
     */
    @JsonProperty("fullName")
    public void setFullName( String fullName )
    {
        this.fullName = fullName;
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

    
    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode( this.firstName );
        hash = 23 * hash + Objects.hashCode( this.fullName );
        hash = 23 * hash + Objects.hashCode( this.lastName );
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
        final Address other = (Address) obj;
        if ( !Objects.equals( this.firstName, other.firstName ) )
        {
            return false;
        }
        if ( !Objects.equals( this.fullName, other.fullName ) )
        {
            return false;
        }
        if ( !Objects.equals( this.lastName, other.lastName ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Address{" + "firstName=" + firstName + ", fullName=" + fullName + ", lastName=" + lastName + '}';
    }
    
    
}
