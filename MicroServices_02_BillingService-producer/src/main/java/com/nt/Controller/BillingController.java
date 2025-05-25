package com.nt.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")
public class BillingController {
	
	
	@GetMapping("/bill")
	public ResponseEntity<String> fetchBillingDetails(){
		
		return new ResponseEntity<String>("You paied 5000",HttpStatus.OK);
	}

}
