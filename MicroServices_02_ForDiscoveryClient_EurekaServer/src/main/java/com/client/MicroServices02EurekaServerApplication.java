package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServices02EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices02EurekaServerApplication.class, args);
	}

}
