package org.com.cay;

import org.com.cay.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrossDomainServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrossDomainServerApplication.class, args);
	}

	//@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean();

		bean.setFilter(new CorsFilter());
		bean.addUrlPatterns("/*");

		return bean;
	}
}
