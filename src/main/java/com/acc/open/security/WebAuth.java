package com.acc.open.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.acc.open.service.MyAppUserDetailsService;

@Configuration
public class WebAuth extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyAppUserDetailsService customAppUserDetailsService;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	 auth.userDetailsService(customAppUserDetailsService).passwordEncoder(passwordEncoder);
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	  http
          	.authorizeRequests()
	            .antMatchers("/css/**").permitAll()
	            .antMatchers("/js/**").permitAll()
	            .antMatchers("/img/**").permitAll();
              
    	  http
	    	.authorizeRequests()
	    		.anyRequest().authenticated()
				.and().formLogin()  //login configuration
		        .loginPage("/login").permitAll() // Custom login page
		        .loginProcessingUrl("/login")
		        .usernameParameter("username")
		        .passwordParameter("password")
		        .defaultSuccessUrl("/account")	
				.and()
				.logout().permitAll()
				.and()
				.logout().clearAuthentication(true)
				.logoutUrl("/logout")
				.and().exceptionHandling() //exception handling configuration
				.accessDeniedPage("/error")
				.and()
		    	.csrf().disable();

    }
    
   
}