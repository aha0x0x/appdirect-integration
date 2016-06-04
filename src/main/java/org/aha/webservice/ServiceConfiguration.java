package org.aha.webservice;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl;
import org.springframework.security.oauth.consumer.BaseProtectedResourceDetails;
import org.springframework.security.oauth.consumer.client.OAuthRestTemplate;


@Configuration
@EnableWebSecurity
public class ServiceConfiguration extends WebSecurityConfigurerAdapter
{
    @Value("${datasource.driver}")
    private String dsDriver;
    
    @Value("${datasource.url}")
    private String dsUrl;
    
    @Value("${datasource.username}")
    private String dsUsername;
    
    @Value("${datasource.password}")
    private String dsPassword;
    
    
    @Value("${oauth.key}")
    private String oAuthKey;
    
    @Value("$(oauth.secret)")
    private String oAuthSecret;
    
    @Bean
    DataSource getDataSource()
    {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName( dsDriver );
        ds.setUrl( dsUrl  );
        ds.setUsername( dsUsername  );
        ds.setPassword( dsPassword  );
        return ds;
    }
    
    @Bean
    OAuthRestTemplate getOAuthTemplate()
    {
        SharedConsumerSecretImpl sharedSecret = new SharedConsumerSecretImpl( oAuthSecret );
        final BaseProtectedResourceDetails resource = new BaseProtectedResourceDetails();
        resource.setConsumerKey(  oAuthKey );
        resource.setSharedSecret( sharedSecret );
        
        return new OAuthRestTemplate( resource );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception 
    {
        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated();
    }
    

    
    
}