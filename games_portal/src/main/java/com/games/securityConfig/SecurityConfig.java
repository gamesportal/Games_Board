package com.games.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig {
	
	/*protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("user").password(passwordEncoder().encode("password")).roles("Admin");
	//	auth.userDetailsService(userDetailsService);

	}*/
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http
         .csrf(csrf -> csrf.disable()) // Disable CSRF for testing
         .authorizeHttpRequests(auth -> auth
             .anyRequest().permitAll() // Allow ALL requests without authentication
         )
         .formLogin(login -> login.disable()) // Disable login page
         .httpBasic(basic -> basic.disable()); // Disable basic authentication

     return http.build();
	    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
