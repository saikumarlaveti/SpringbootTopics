package com.consumer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.Client.BillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingServiceOperationsController {

	@Autowired
	private BillingServiceConsumerClient info;
	
	@GetMapping("/cart")
	public ResponseEntity<String> doShopping(){
		String result = info.fetchBillingInfo().getBody();
		
		return new ResponseEntity<String>("Shopping items (shirt,trouser) ::: " + result,HttpStatus.ACCEPTED);
	}

}
