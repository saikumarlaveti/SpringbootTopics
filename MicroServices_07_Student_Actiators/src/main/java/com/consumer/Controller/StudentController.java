package com.consumer.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	public static Logger logger = LogManager.getLogger(StudentController.class);
	@GetMapping("/show")
	public ResponseEntity<String> studentDetails(){
        logger.info("This is StudentDetails method in StudentController");
		
		return new ResponseEntity<String>("Student Actiators",HttpStatus.OK);
	}
}
