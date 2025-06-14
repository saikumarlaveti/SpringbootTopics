package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroServices07ConfigServerRefreshScopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices07ConfigServerRefreshScopeApplication.class, args);
	}

}
