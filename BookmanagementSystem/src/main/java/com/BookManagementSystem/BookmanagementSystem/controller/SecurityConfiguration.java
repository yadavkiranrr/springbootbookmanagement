package com.BookManagementSystem.BookmanagementSystem.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filtterchain(HttpSecurity httpSecurity) throws Exception {
		
		
		httpSecurity.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
	}
	


}
