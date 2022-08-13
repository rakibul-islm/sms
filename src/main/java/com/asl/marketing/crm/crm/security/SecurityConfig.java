package com.asl.marketing.crm.crm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.asl.marketing.crm.crm.config.JwtAutenticationFilter;
import com.asl.marketing.crm.crm.service.impl.UserServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired private UserServiceImpl userDetailService;
	@Autowired private JwtAutenticationFilter jwtRequestFilter;

	@Autowired private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/api/sms/authenticate/**").permitAll();
		http.authorizeRequests().antMatchers("/swagger-ui.html").permitAll();
		http.authorizeRequests().antMatchers("/swagger-ui/**").permitAll();
		http.authorizeRequests().antMatchers("/favicon.ico").permitAll();
		http.authorizeRequests().antMatchers("/webjars/**").permitAll();
		http.authorizeRequests().antMatchers("/swagger-resources/**").permitAll();
		http.authorizeRequests().antMatchers("/v2/api-docs/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Autowired
//	private JwtAuthenticatonEntryPoint unAuthorizedHandler;
	
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.userDetailsService(this.userDetailServiceImpl).passwordEncoder(passwordEncoder());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/generate-token", "/user/").permitAll()
//				.antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and().exceptionHandling()
//				.authenticationEntryPoint(unAuthorizedHandler).and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		http.addFilterBefore(jwtAutenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//	}

}