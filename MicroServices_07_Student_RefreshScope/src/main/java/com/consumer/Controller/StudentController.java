package com.consumer.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RefreshScope
public class StudentController {

	@Value("${Name}")
	private String name;
	
	@Value("${PhoneNo}")
	private String phoneNo;
	
	@Value("${Email}")
	private String email;
	
	private String info = "Student Class";

	
	@GetMapping("/show")
	public ResponseEntity<String> studentDetails(){
	
		return new ResponseEntity<String>(name + " is phone no :" + phoneNo +" : "+ email +"-->" +info ,HttpStatus.OK);
	}
}
