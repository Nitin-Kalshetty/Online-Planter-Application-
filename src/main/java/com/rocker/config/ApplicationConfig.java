package com.rocker.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.rocker.config.jwtSecurity.JwtTokenGeneratorFilter;
import com.rocker.config.jwtSecurity.JwtTokenValidationFilter;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class ApplicationConfig {

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				// .and()
				// .csrf().disable()
				// .cors().configurationSource(new CorsConfigurationSource() {

				// @Override
				// public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				// CorsConfiguration cfg = new CorsConfiguration();
				// cfg.setAllowedOrigins(Collections.singletonList("*"));
				// cfg.setAllowedMethods(Collections.singletonList("*"));
				// // cfg.setAllowCredentials(true);
				// cfg.setAllowedHeaders(Collections.singletonList("*"));
				// cfg.setExposedHeaders(Arrays.asList("Authorization"));
				// cfg.setMaxAge(3600L);
				// return cfg;
				// }
				// })
				.and()
				.authorizeHttpRequests()
				.requestMatchers(HttpMethod.POST, "/customer").permitAll()
				.requestMatchers(HttpMethod.GET, "/customer", "/plantById", "/planterById", "/seedById", "/plants",
						"/plantsByName", "/plantsByType", "/plantsByHeight",
						"/plantsBySpread", "/plantsByTemperature", "/plantsByCost", "/planters", "/plantersByCapacity",
						"/plantersByHeight", "/plantersByCost", "/plantersByHoles",
						"/seeds", "/seedsByName", "/seedsByType", "/seedsByTemperature", "/seedsByCost",
						"/seedsPerPacket")
				.hasRole("USER")
				.requestMatchers(HttpMethod.GET, "/customers").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/customer").hasAnyRole("ADMIN", "USER")
				.requestMatchers(HttpMethod.POST, "/planter", "/plant", "/seed").hasRole("SELLER")
				.requestMatchers(HttpMethod.PUT, "/planter", "/plant", "/seed").hasRole("SELLER")
				.requestMatchers(HttpMethod.DELETE, "/planter", "/plant", "/seed").hasAnyRole("ADMIN", "SELLER")
				.anyRequest()
				.authenticated()
				.and()
				.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JwtTokenValidationFilter(), BasicAuthenticationFilter.class)
				.formLogin()
				.and()
				.httpBasic();
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
