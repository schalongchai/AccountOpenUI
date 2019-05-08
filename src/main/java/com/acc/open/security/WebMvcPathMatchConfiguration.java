package com.acc.open.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
public class WebMvcPathMatchConfiguration implements WebMvcConfigurer {

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// trailing slash at the end of URI will not allow
		configurer.setUseTrailingSlashMatch(false);
	}
	
	@Bean 
	public SpringSecurityDialect SecurityDialect() {
		return new SpringSecurityDialect();
	}

}
