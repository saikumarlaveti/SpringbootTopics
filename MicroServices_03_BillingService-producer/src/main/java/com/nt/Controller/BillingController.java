package com.nt.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")
public class BillingController {
	
	@Value("${server.port}")
	private int port;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	@GetMapping("/bill")
	public ResponseEntity<String> fetchBillingDetails(){
		
		System.out.println(port);
		System.out.println(instanceId);
		return new ResponseEntity<String>("You paied 5000 At Port Number :" +port + " with instance Id" + instanceId,HttpStatus.OK);
	}

}
