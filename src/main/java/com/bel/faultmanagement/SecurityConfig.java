package com.bel.faultmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//To configure Tomcat user name and password
//by default spring boot security uses passwordencoder. To disable this prefix password with {noop} as shown below
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER");
    }
	
//If CSRF is not disabled/permitAll Request is not allowed then for REST API's response returned as 401 Unauthorized
//Enable either of the below configure method to set httpsecurity to solve 401 unauthorized error 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().permitAll();
//	}

}
