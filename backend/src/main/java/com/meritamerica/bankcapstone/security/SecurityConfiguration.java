package com.meritamerica.bankcapstone.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.meritamerica.bankcapstone.services.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
		http.csrf()
			.disable()
			.authorizeRequests()
			
			.antMatchers("/h2-console").permitAll()
			.antMatchers("/secured-test").hasAnyAuthority("USER", "ADMIN")
			.antMatchers("/admin-test").hasAuthority("ADMIN")
			.antMatchers("/home").permitAll()
			//.antMatchers("/Users").permitAll() // This will be removed after an admin is either hard-coded or already placed in a persistent database!
			// Finish locking down endpoints here:
			.antMatchers("/authenticate").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/Users").permitAll()
			.anyRequest().authenticated()
			//.and().formLogin()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	// Beans:
	
	// Remember that Spring Beans are simply objects that are initialized in a spring container.
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


}	