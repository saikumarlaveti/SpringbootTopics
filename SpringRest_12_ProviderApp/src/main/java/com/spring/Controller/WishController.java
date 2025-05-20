package com.spring.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish/api")
public class WishController {

	@GetMapping("/message")
	public ResponseEntity<String> wishMessage(){
		return new ResponseEntity<String>("Good Morining",HttpStatus.OK);
	}
}
