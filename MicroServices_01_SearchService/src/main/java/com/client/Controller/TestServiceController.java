package com.client.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Test")
public class TestServiceController {

	@GetMapping("/show")
	public ResponseEntity<String> wish() {
		return new ResponseEntity<String>("Welcome to Spring Boot MicroService Project"
				+ " Saikumar Laveti",HttpStatus.OK);
	}
}
