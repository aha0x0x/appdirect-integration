package org.aha.webservice.appdirect.ds;

public class DbSchema 
{
    public static String NAME = "appdirect";
    
    public static class UsersTable 
   {
        public static String NAME = "users";

        public static String ID_COLUMN          = "id";
        public static String EMAIL_COLUMN       = "email";
        public static String OPENID_COLUMN      = "open_id";
        public static String FIRSTNAME_COLUMN   = "first_name";
        public static String LASTNAME_COLUMN    = "last_name";
    }
    
    public static class SubscriptionTable
    {
        // id, company_name, edition, status, notice, market_place
        
        public static String NAME = "subscription";
        
        public static String ID_COLUMN              = "id";
        public static String COMPANY_COLUMN         = "company";
        public static String EDITION_COLUMN         = "edition";
        public static String STATUS_COLUMN          = "status";
        public static String NOTICE_COLUMN          = "notice";
        public static String MARKETPLACE_COLUMN     = "marketplace";
        
        
        
    }
}
