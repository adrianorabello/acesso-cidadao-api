package com.bi.biproxyapi.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-11
*/


@Configuration
@EnableSwagger2
public class OAuthSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
    public void configure(WebSecurity web) throws Exception {
       web.ignoring().antMatchers("/v2/api-docs",
       		"/configuration/ui", 
       		"/swagger-resources",
       		"/configuration/security",
        		"/swagger-ui.html",
       		"/swagger-resources/configuration/ui", 
       		"/swagger-resources/configuration/security",
        		"/webjars/**");

    }
	
}