package com.springScheduling;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Concept02SpringBootSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Concept02SpringBootSchedulingApplication.class, args);
		System.out.println("Concept02SpringBootSchedulingApplication.main()");
		System.out.println("App started At ::" +new Date());
		
	}

}
