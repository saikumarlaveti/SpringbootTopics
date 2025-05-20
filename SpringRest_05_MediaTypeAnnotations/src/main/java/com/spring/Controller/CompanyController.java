package com.spring.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Model.Student;

@RestController
@RequestMapping("/student/api")
public class CompanyController {
	
	
	@PostMapping("/register")
	public ResponseEntity<Student> registerEntity(@RequestBody Student std){
		
		System.out.println("CompanyController.registerEntity()");
		return new ResponseEntity<Student>(std,HttpStatus.CREATED);
		
	}	
}
