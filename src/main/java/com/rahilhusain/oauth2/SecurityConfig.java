package com.rahilhusain.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomOAuth2UserService userService;

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.disable()
			.authorizeRequests()
				.anyRequest().authenticated().and()
			.oauth2Login()
				.redirectionEndpoint()
					.baseUri("/oauth2/callback/**").and()
				.userInfoEndpoint()
					.userService(userService).and()
				.permitAll();
	}
	// @formatter:on
}
