package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroServices05TestingConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices05TestingConfigServerApplication.class, args);
	}

}
