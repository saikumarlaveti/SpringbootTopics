package com.consumer.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Value("${name}")
	private String name;
	
	@Value("${gmail}")
	private String email;
	
	@Value("${password}")
	private String password;
	
	@GetMapping("/details")
	public ResponseEntity<String> showDetails(){
		return new ResponseEntity<String>("Employee Details -->" + name + " : " + email + " : "+ password,HttpStatus.OK);
	}
}
