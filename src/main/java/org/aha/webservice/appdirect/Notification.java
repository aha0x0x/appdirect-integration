package org.aha.webservice.appdirect;

    import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
{
    "type",
    "marketplace",
    "flag",
    "creator",
    "payload"
})

public class Notification
{

    @JsonProperty("type")
    private EventType type;

    @JsonProperty("marketplace")
    private Marketplace marketplace;

    @JsonProperty("flag")
    private Flag flag; 
    
    @JsonProperty("creator")
    private User creator;

    @JsonProperty("payload")
    private Payload payload;

    /**
     *
     * @return The type
     */
    @JsonProperty("type")
    public EventType getType()
    {
        return type;
    }

    /**
     *
     * @param type The type
     */
    @JsonProperty("type")
    public void setType( EventType type )
    {
        this.type = type;
    }

    /**
     *
     * @return The marketplace
     */
    @JsonProperty("marketplace")
    public Marketplace getMarketplace()
    {
        return marketplace;
    }

    /**
     *
     * @param marketplace The marketplace
     */
    @JsonProperty("marketplace")
    public void setMarketplace( Marketplace marketplace )
    {
        this.marketplace = marketplace;
    }

    /**
     *
     * @return state flag
     */
    @JsonProperty("flag")
    public Flag getFlag()
    {
        return flag;
    }

    /**
     *
     * @param creator The creator
     */
    @JsonProperty("flag")
    public void setFlag( Flag flag )
    {
        this.flag = flag;
    }
    
    /**
     *
     * @return The creator
     */
    @JsonProperty("creator")
    public User getCreator()
    {
        return creator;
    }

    /**
     *
     * @param creator The creator
     */
    @JsonProperty("creator")
    public void setCreator( User creator )
    {
        this.creator = creator;
    }

    /**
     *
     * @return The payload
     */
    @JsonProperty("payload")
    public Payload getPayload()
    {
        return payload;
    }

    /**
     *
     * @param payload The payload
     */
    @JsonProperty("payload")
    public void setPayload( Payload payload )
    {
        this.payload = payload;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode( this.type );
        hash = 59 * hash + Objects.hashCode( this.marketplace );
        hash = 59 * hash + Objects.hashCode(this.creator );
        hash = 59 * hash + Objects.hashCode( this.payload );
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
        final Notification other = (Notification) obj;
        if ( this.type != other.type )
        {
            return false;
        }
        if ( !Objects.equals( this.marketplace, other.marketplace ) )
        {
            return false;
        }
        if ( !Objects.equals(this.creator, other.creator ) )
        {
            return false;
        }
        if ( !Objects.equals( this.payload, other.payload ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Notification{" + "type=" + type + ", marketplace=" + marketplace + ", creator=" + creator + ", payload=" + payload + '}';
    }

    
    
    
}
