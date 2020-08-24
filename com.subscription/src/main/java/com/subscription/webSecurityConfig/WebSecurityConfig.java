package com.subscription.webSecurityConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
	 * configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(allowedOrigins());
	 * configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	 * configuration.setAllowCredentials(true); List<String> headers =
	 * Arrays.asList("Authorization","Cache-Control","Content-Type",
	 * "X-Message-Id"); configuration.setAllowedHeaders(headers);
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * configuration); return source; }
	 * 
	 * public List<String> allowedOrigins(){ return new ArrayList<>(); }
	 */
	
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	}

	@Bean
	public FilterRegistrationBean processCorsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);

		final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
