package com.example.configuration;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private static final String ADMIN = "ADMIN";  
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("saiman").password("saiman").roles("USER").and().
		withUser("testman").password("testman").roles(ADMIN);
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			     .antMatchers("/sales-api/asales/**").hasRole(ADMIN)
			     .antMatchers("/sales-api/sales/**").hasAnyRole(ADMIN,"USER")
			     .antMatchers("/").permitAll()
			     .and()
			     .httpBasic();
		
		http.csrf().disable();
	}
	
	
	
}
