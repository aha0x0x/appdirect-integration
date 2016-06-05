package org.aha.webservice.appdirect.ds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.sql.DataSource;
import org.aha.webservice.appdirect.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionDAO
{
    private final String SUBSCRIPTION_TABLE = DbSchema.NAME + "." + DbSchema.SubscriptionTable.NAME;
    
    @Autowired
    private DataSource mDs; 
    
    /**
     * create a new subscription
     * @param company
     * @param orderEdition
     * @return new subscription id
     * @throws SQLException 
     */
    public UUID create( String company, String orderEdition ) throws SQLException
    {
        String sql =  "INSERT INTO " + SUBSCRIPTION_TABLE 
                        + " ( " 
                        + DbSchema.SubscriptionTable.COMPANY_COLUMN + " , " 
                        + DbSchema.SubscriptionTable.EDITION_COLUMN + " ) values ( ?, ?     ) returning id"; 

        PreparedStatement pstmt = null;
        try 
        {
            pstmt = mDs.getConnection().prepareStatement( sql );
            pstmt.setString( 1, company );
            pstmt.setString( 2, orderEdition );

            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            if (rs.next()) 
            {
                String uuidString = rs.getString( DbSchema.SubscriptionTable.ID_COLUMN );
                return UUID.fromString( uuidString );
            }
            return null;
            
        }
        finally 
        {
            if ( pstmt != null ) 
            {
                pstmt.close();
            }
        }
    }
    
    /**
     * checks if a given subscription exists.
     * @param subscriptionId
     * @return true if subscription exists else false
     * @throws SQLException 
     */
    public boolean subscriptionExists( UUID subscriptionId ) throws SQLException
    {
        String sql = "SELECT EXISTS ( SELECT 1 FROM " + SUBSCRIPTION_TABLE 
                      + " WHERE " + DbSchema.UsersTable.ID_COLUMN +" = ?  )";
        
        PreparedStatement pstmt = null;
        try 
        {
            pstmt = mDs.getConnection().prepareStatement( sql );
            pstmt.setObject( 1, subscriptionId );
            
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
        finally 
        {
            if ( pstmt != null ) 
            {
                pstmt.close();
            }
        }
        
    }
    
    
    /**
     * change subscription edition 
     * @param id
     * @param orderEdition
     * @return true if edition was changed successfully else false
     * @throws SQLException 
     */
    public boolean changeEdition( UUID id, String orderEdition ) throws SQLException
    {
        String sql =  "update " + SUBSCRIPTION_TABLE 
                        + "set (" 
                        + DbSchema.SubscriptionTable.EDITION_COLUMN + " = ? "  
                        + " WHERE " + DbSchema.SubscriptionTable.ID_COLUMN + "  = ? ";
        
        
        PreparedStatement pstmt = null;
        try 
        {
            pstmt = mDs.getConnection().prepareStatement( sql );
            pstmt.setString( 1, orderEdition );
            pstmt.setString( 2, id.toString() );
            
            int rows = pstmt.executeUpdate();
            mDs.getConnection().commit();
            
            return rows == 1;
            
        }
        finally 
        {
            if ( pstmt != null ) 
            {
                pstmt.close();
            }
        }
        
        
    }
    
    /**
     * delete a given subscription 
     * @param id
     * @return true if subscription was deleted successfully else false
     * @throws SQLException 
     */
    public boolean delete( UUID id ) throws SQLException
    {
        String sql = "DELETE from " + SUBSCRIPTION_TABLE 
                     + " WHERE id = ? CASCADE";
        
        PreparedStatement pstmt = null;
        try 
        {
            pstmt = mDs.getConnection().prepareStatement( sql );
            pstmt.setString( 1, id.toString() );
            
            int rows = pstmt.executeUpdate();
            mDs.getConnection().commit();
            return rows == 1;
        }
        finally 
        {
            if ( pstmt != null ) 
            {
                pstmt.close();
            }
        }
    }
    
    /**
     * change subscription notice 
     * @param id
     * @param notice
     * @return true if notice was changed successfully else false
     * @throws SQLException 
     */
    public boolean changeNotice( UUID id, Notice notice ) throws SQLException
    {
        String sql =  "UPDATE " + SUBSCRIPTION_TABLE 
                      + " SET " + DbSchema.SubscriptionTable.NOTICE_COLUMN + " = ? "  
                      + " WHERE " + DbSchema.SubscriptionTable.ID_COLUMN + "  = ? ";
        
        PreparedStatement pstmt = null;
        try 
        {
            pstmt = mDs.getConnection().prepareStatement( sql );
            pstmt.setString( 1, notice.toString() );
            pstmt.setString( 2, id.toString() );
            
            int rows = pstmt.executeUpdate();
            mDs.getConnection().commit();
            return rows == 1;
        }
        finally 
        {
            if ( pstmt != null ) 
            {
                pstmt.close();
            }
        }
    }
}
