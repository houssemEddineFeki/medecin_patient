package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials, true from user where username=?")
		.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from user_roles where user_username=?")
		.rolePrefix("ROLE_");
	}   
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder =new BCryptPasswordEncoder();
		return encoder ;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	   http
	   .authorizeRequests()
	   .antMatchers("/patients/**", "/medecins/**", "/roles/**" ).hasRole("ADMIN")
	   .antMatchers("/patients/**").hasRole("MEDECIN")
	   .antMatchers("/patients/**").hasRole("PATIENT")
	   .and()
	   .formLogin()
	   .defaultSuccessUrl("/patients")
	   
	   
	   ;
	   
	}
	
  
}
