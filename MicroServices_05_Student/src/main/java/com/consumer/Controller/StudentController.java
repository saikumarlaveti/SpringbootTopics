package com.consumer.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

	@Value("${name}")
	private String name;
	
	@Value("${gmail}")
	private String gmail;
	
	@GetMapping("/details")
	public ResponseEntity<String> showdetails(){
		
	 return new ResponseEntity<String>("Student name :" + name + " Student gmail :  " + gmail,HttpStatus.OK); 
	}
}
