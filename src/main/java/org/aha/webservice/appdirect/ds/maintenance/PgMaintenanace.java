    package org.aha.webservice.appdirect.ds.maintenance;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import javax.sql.DataSource;
import org.aha.webservice.appdirect.ds.DbSchema;
import org.springframework.beans.factory.annotation.Autowired;


public class PgMaintenanace implements DbMaintenance
{
    @Autowired
    private final DataSource mDs; 
    
    public PgMaintenanace( final DataSource ds )
    {
        mDs = ds;
    }
        
    @Override
    public void initializeDbSchema() throws DbMaintenanceException
    {
        try
        {
            if( schemaExists() ){
                return;
            }
            createSchema();
        }
        catch ( SQLException ex )
        {
            throw new DbMaintenanceException("failed to check if schema exists", ex);
        }
    }
    
    private void createSchema() throws SQLException
    {
        Optional<PreparedStatement> stmt = Optional.empty();
        try
        {
            StringBuilder builder = new StringBuilder();
            builder.append( getCreateSchemaSql() );
            builder.append( getCreateSubscriptionTableSql() );
            builder.append( getCreateUserTableSql() );
            
            stmt = Optional.of( mDs.getConnection().prepareStatement( builder.toString()) );
            stmt.get().executeUpdate();
        }
        finally
        {
            if( stmt.isPresent() ) { try { stmt.get().close(); } catch ( SQLException ex ){ } }
        }
    }
    
    private String getCreateSchemaSql() 
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "create schema ").append( DbSchema.NAME );
        return builder.toString();
    }

    private String getCreateSubscriptionTableSql() throws SQLException 
    {
        /**
         * create table subscription (
         *  id uuid primary key default uuid_generate_v4(),
         *  company varchar not null,
         *  edition varchar not null,
         *  status  varchar, 
         *  marketplace varchar not null );
         */
        StringBuilder builder = new StringBuilder();
        builder.append( "create table ").append( DbSchema.NAME ).append( "." ).append( DbSchema.SubscriptionTable.NAME );
        builder.append( " ( ")
                .append( DbSchema.SubscriptionTable.ID_COLUMN ).append( " UUID primary key default gen_random_uuid(),\n ")
                .append( DbSchema.SubscriptionTable.COMPANY_COLUMN ).append( " varchar not null,\n ")
                .append( DbSchema.SubscriptionTable.EDITION_COLUMN ).append( " varchar not null,\n ")
                .append(DbSchema.SubscriptionTable.MARKETPLACE_COLUMN ).append( " varchar not null ").append( ");");
        return builder.toString();
    }

        
    private String getCreateUserTableSql() throws SQLException
    {
        /**
         * create table appdirect.users  (
         *  id uuid references subscription (id ),\n 
         *  email varchar not null,
         *  openid varchar,
         *  first_name varchar, 
         *  last_name varchar )
         */
        StringBuilder builder = new StringBuilder();
        builder.append( "create table ").append( DbSchema.NAME ).append( "." ).append( DbSchema.UsersTable.NAME );
        builder.append( " ( ")
            .append( DbSchema.UsersTable.ID_COLUMN ).append( " UUID REFERENCES " ).append( DbSchema.SubscriptionTable.NAME ).append( "(").append( DbSchema.SubscriptionTable.ID_COLUMN ).append( ") ON DELETE CASCADE,\n");
        builder.append( DbSchema.UsersTable.EMAIL_COLUMN ).append( " varchar not null,\n ");
        builder.append( DbSchema.UsersTable.OPENID_COLUMN ).append( "varchar,\n ");
        builder.append( DbSchema.UsersTable.FIRSTNAME_COLUMN ).append( "varchar,\n");
        builder.append( DbSchema.UsersTable.LASTNAME_COLUMN ).append( "varchar,\n");
        builder.append( ")");
        return builder.toString();
    }

    private boolean schemaExists() throws SQLException
    {
        Optional<PreparedStatement> stmt = Optional.empty();
        try
        {
            StringBuilder builder = new StringBuilder();
            builder.append( "select exists ( select 1 from pg_namespace where nspname = '").append(  DbSchema.NAME ).append( "')" );
        
            stmt = Optional.of( mDs.getConnection().prepareStatement( builder.toString()) );
            ResultSet result = stmt.get().executeQuery();
            result.next();
            return result.getBoolean( 1 );
        }
        finally
        {
            if( stmt.isPresent() )
            {
                try { stmt.get().close(); } catch ( SQLException ex ){ }
            }
        }
    }
}
