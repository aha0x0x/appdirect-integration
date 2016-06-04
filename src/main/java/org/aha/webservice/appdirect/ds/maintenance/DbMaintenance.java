package org.aha.webservice.appdirect.ds.maintenance;

public interface DbMaintenance
{
    void initializeDbSchema() throws DbMaintenanceException;
}
