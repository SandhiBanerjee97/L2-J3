package com.StudentManager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.StudentManager.service.CustomUserDetailService;

/*the userDetailsService method takes an Object of "UserDetailsService Interface" , We provide the Implementation for
 * this Interface by Implementing it Which Returns Object Of "UserDetails".  */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailService customUserDetailsService;
	

	@Override				//configure method for Authentication
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override				//configure method for Authorization
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers(HttpMethod.GET,"/students").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/students").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/students").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/students").hasRole("ADMIN")
		.and().httpBasic()
		.and().formLogin()
		.and().csrf().disable();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
