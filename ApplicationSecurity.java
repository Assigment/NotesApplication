package org.gotprint.authentication.security;

import org.gotprint.authentication.security.authentication.RestAuthenticationEntryPoint;
import org.gotprint.authentication.security.authentication.RestAuthenticationFailureHandler;
import org.gotprint.authentication.security.authentication.RestAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author dheeraj
 *
 */

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private RestAuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private RestAuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("dheeraj25in@gmail.com").password("abc@1234").roles("USER").and().withUser("dheeraj237357in@gmail.com")
				.password("xyz@1234").roles("USER").and().withUser("vinayak@gmail.com")
				.password("vinayak@123").roles("USER").and().withUser("Sudheer@gmail.com")
				.password("sudheer@123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/note/**").authenticated();
		http.csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		http.formLogin().successHandler(authenticationSuccessHandler);
		http.formLogin().failureHandler(authenticationFailureHandler);
	}

}
