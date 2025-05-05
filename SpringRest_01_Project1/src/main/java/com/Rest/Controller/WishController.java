package com.Rest.Controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class WishController {

	@GetMapping("/wish")
	public ResponseEntity<String> wishMessage(){
		LocalDateTime ldt =  LocalDateTime.now();
		int hour = ldt.getHour();
		String greet = null;
		if(hour<12)
			greet = "Good Morning";
		else if(hour<16)
			greet = "Good Afternoon";
		else if(hour<20)
			greet = "Good Evening";
		else 
			greet = "Good Night";
		
		ResponseEntity<String> entity= new ResponseEntity<String>(greet, HttpStatus.ACCEPTED);
		
		return entity;
	}
}
