package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServices03ForLoadBalacerClientEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices03ForLoadBalacerClientEurekaServerApplication.class, args);
	}

}
