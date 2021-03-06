package com.diatoz.college.confiig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.diatoz.college.service.MyUserDetailsService;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	public static final String [] swaggerURL = {
			"/v2/api-docs",
			"/swagger-resources",
			"/swagger-ui/**",
			"/webjars/**",
			"/configuration/ui",
			"/configuration/security"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests().antMatchers("/userauthenticate").permitAll()
		.antMatchers(swaggerURL).permitAll()
		.antMatchers("/admin/*").hasAuthority("ADMIN")
		.antMatchers("/teacher/*").hasAnyAuthority("ADMIN" , "TEACHER")
		.antMatchers("/student/marks").hasAuthority("STUDENT")
		.antMatchers("/student/*").hasAnyAuthority("ADMIN" , "TEACHER")
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		//http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
//				"/swagger-ui.html", "/webjars/**");
//	}
}

