package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
public class MicroServices04ShoppingServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices04ShoppingServiceConsumerApplication.class, args);
	}

}
