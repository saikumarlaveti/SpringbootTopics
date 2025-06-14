package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroServices07RefreshScopeEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices07RefreshScopeEurekaServerApplication.class, args);
	}

}
