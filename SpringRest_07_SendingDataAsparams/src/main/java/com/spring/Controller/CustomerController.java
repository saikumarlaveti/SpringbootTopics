package com.spring.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@GetMapping("/report")
	public ResponseEntity<String> showResult(@RequestParam("sId") int stdId,
											@RequestParam String stdName){
		System.out.println(stdId + " " + stdName);
		
		return new ResponseEntity<String>(stdId + " " + stdName,HttpStatus.OK);
	}

}
