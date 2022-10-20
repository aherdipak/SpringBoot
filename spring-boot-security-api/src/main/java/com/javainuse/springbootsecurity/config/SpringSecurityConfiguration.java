package com.javainuse.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity

public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		//.csrf().disable()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		//authorized user who has admin role can access this url
		.authorizeRequests()
		.antMatchers("/helloadmin").hasRole("ADMIN")
		.antMatchers("/hellouser").hasAnyRole("USER","ADMIN")
		.antMatchers("/postRequest").hasAnyRole("USER","ADMIN")
		.antMatchers("/getRequest").hasAnyRole("USER","ADMIN")
		
		
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		

	}

	
	
	
	

	


}
