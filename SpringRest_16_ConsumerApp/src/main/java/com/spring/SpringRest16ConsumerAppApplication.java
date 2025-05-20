package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRest16ConsumerAppApplication {

	@Bean("Template")
	public RestTemplate template() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringRest16ConsumerAppApplication.class, args);
	}

}
