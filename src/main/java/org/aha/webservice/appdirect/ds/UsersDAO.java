package org.aha.webservice.appdirect.ds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAO
{
    
    private static String USERS_TABLE = DbSchema.NAME + "." + DbSchema.UsersTable.NAME;
    
    @Autowired
    private DataSource mDs; 
    
    /**
     * 
     * @param email
     * @return 
     */
    public boolean doesUserExist( String email ) throws SQLException
    {
        String sql = "SELECT EXISTS ( SELECT 1 FROM " + USERS_TABLE 
                      + " WHERE " + DbSchema.UsersTable.EMAIL_COLUMN +" = ?  )";
        
        PreparedStatement pstmt = null;
        try 
        {
            pstmt = mDs.getConnection().prepareStatement( sql );
            pstmt.setString( 1, email );
            
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
     * 
     * @return
     * @throws SQLException 
     */
    public void createUser( UUID id, String email, String firstname, String lastname ) throws SQLException
    {
        
        String sql = "INSERT INTO " + USERS_TABLE  
                     + "( " 
                     + DbSchema.UsersTable.ID_COLUMN  + ","
                     + DbSchema.UsersTable.EMAIL_COLUMN + ","
                     + DbSchema.UsersTable.FIRSTNAME_COLUMN + ","
                     + DbSchema.UsersTable.LASTNAME_COLUMN +") values ( ?, ?, ?, ? )";
                     
        
        PreparedStatement pstmt = null;
        try 
        {
            pstmt = mDs.getConnection().prepareStatement( sql );
            pstmt.setObject( 1, id );
            pstmt.setString( 2, email );
            pstmt.setString( 3, firstname );
            pstmt.setString( 4, lastname );

            pstmt.executeUpdate();
            
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
