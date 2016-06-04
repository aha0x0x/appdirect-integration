package org.aha.webservice.appdirect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
{
    "quantity",
    "unit"
})

public class Item
{
    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("unit")
    private String unit;

    /**
     *
     * @return The quantity
     */
    @JsonProperty("quantity")
    public String getQuantity()
    {
        return quantity;
    }

    /**
     *
     * @param quantity The quantity
     */
    @JsonProperty("quantity")
    public void setQuantity( String quantity )
    {
        this.quantity = quantity;
    }

    /**
     *
     * @return The unit
     */
    @JsonProperty("unit")
    public String getUnit()
    {
        return unit;
    }

    /**
     *
     * @param unit The unit
     */
    @JsonProperty("unit")
    public void setUnit( String unit )
    {
        this.unit = unit;
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
        final Item other = (Item) obj;
        if ( !Objects.equals( this.quantity, other.quantity ) )
        {
            return false;
        }
        if ( !Objects.equals( this.unit, other.unit ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Item{" + "quantity=" + quantity + ", unit=" + unit + '}';
    }
}
