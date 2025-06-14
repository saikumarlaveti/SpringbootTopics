package com.consumer.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	private String info = "Checking Eureka Server Class";

	
	@GetMapping("/show")
	public ResponseEntity<String> studentDetails(){
	
		return new ResponseEntity<String>("-->" +info ,HttpStatus.OK);
	}
}
