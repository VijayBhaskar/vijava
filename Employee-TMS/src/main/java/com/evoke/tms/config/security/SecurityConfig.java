package com.evoke.tms.config.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
    private UserDetailsService customEmployeDetailsService;
	
	@Resource
	private Environment env;	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customEmployeDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	 
	  http.authorizeRequests() 
	    .antMatchers(env.getRequiredProperty("tms.url.admin")).access("hasRole('"+env.getRequiredProperty("tms.roles.admin")+"')")
	    .antMatchers(env.getRequiredProperty("tms.url.pm")).access("hasRole('"+env.getRequiredProperty("tms.roles.pm")+"')")
	  	.antMatchers(env.getRequiredProperty("tms.url.login")).permitAll()
		.and()
		.formLogin().loginPage(env.getRequiredProperty("tms.url.login")).failureUrl("/login?error").permitAll()
		.defaultSuccessUrl("/home")
		.and()
		.logout().logoutSuccessUrl("/login?logout")
		.and()
		.exceptionHandling().accessDeniedPage("/403")
		.and()
		.csrf().disable();
	}
}

