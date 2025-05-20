package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRest15ConsumerAppJsonToObjectApplication {

	@Bean("template")
	public RestTemplate temlate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringRest15ConsumerAppJsonToObjectApplication.class, args);
	}

}
