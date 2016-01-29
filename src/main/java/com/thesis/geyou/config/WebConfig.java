package com.thesis.geyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.thesis.geyou.controller" })
public class WebConfig {

	@Bean
	public MappingJackson2HttpMessageConverter converter() {
		ObjectMapper mapper = new ObjectMapper();

		return new MappingJackson2HttpMessageConverter(mapper);
	}

}
