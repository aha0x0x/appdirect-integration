package org.aha.webservice.appdirect.ds.maintenance;

public class DbMaintenanceException extends Exception
{
    public DbMaintenanceException( String message, Throwable t ) 
    {
        super( message, t );
    }
}
