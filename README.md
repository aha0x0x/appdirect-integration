# appdirect-integration
This project provides sample Subscription and user event integration with appdirect
Project can be compiled using maven which sould take care of dependencies. 
Project requires a postgres database backend with alteast version 9.0 or up. 
Postgres also requires pgcrypto extension which is used to generate random UUIDs. 
Required schemas need to be created( schema and tables are provided in classes   
org.aha.webservice.appdirect.ds.DbSchema and org.
aha.webservice.appdirect.ds.maintenance.PgMaintenanace )

Relative urls for subscription events:
create: subscription/create
change: subscription/change
cancel: subscription/cancel
notice: subscription/notice

Relative urls for user access events:
assign: access/assign
unassign: access/unassign



