package org.aha.webservice.appdirect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
{
    "editionCode",
    "pricingDuration",
    "item"
})

public class Order
{

    @JsonProperty("editionCode")
    private String editionCode;
    
    @JsonProperty("pricingDuration")
    private String pricingDuration;
    
    @JsonProperty("item")
    private Item item;

    /**
     *
     * @return The editionCode
     */
    @JsonProperty("editionCode")
    public String getEditionCode()
    {
        return editionCode;
    }

    /**
     *
     * @param editionCode The editionCode
     */
    @JsonProperty("editionCode")
    public void setEditionCode( String editionCode )
    {
        this.editionCode = editionCode;
    }

    /**
     *
     * @return The pricingDuration
     */
    @JsonProperty("pricingDuration")
    public String getPricingDuration()
    {
        return pricingDuration;
    }

    /**
     *
     * @param pricingDuration The pricingDuration
     */
    @JsonProperty("pricingDuration")
    public void setPricingDuration( String pricingDuration )
    {
        this.pricingDuration = pricingDuration;
    }

    /**
     *
     * @return The item
     */
    @JsonProperty("item")
    public Item getItem()
    {
        return item;
    }

    /**
     *
     * @param item The item
     */
    @JsonProperty("item")
    public void setItem( Item item )
    {
        this.item = item;
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
        final Order other = (Order) obj;
        if ( !Objects.equals( this.editionCode, other.editionCode ) )
        {
            return false;
        }
        if ( !Objects.equals( this.pricingDuration, other.pricingDuration ) )
        {
            return false;
        }
        if ( !Objects.equals( this.item, other.item ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode( this.editionCode );
        hash = 71 * hash + Objects.hashCode( this.pricingDuration );
        hash = 71 * hash + Objects.hashCode( this.item );
        return hash;
    }

    @Override
    public String toString()
    {
        return "Order{" + "editionCode=" + editionCode + ", pricingDuration=" + pricingDuration + ", item=" + item + '}';
    }



}
