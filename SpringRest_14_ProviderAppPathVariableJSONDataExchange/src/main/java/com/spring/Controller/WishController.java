package com.spring.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Model.Tourist;

@RestController
@RequestMapping("/wish/api")
public class WishController {
	
	@GetMapping("/report")
	public ResponseEntity<String> message(){
		System.out.println("WishController.message()");
		return new ResponseEntity<String>("Good Night",HttpStatus.OK);
	}

	@GetMapping("/message/{id}/{name}")
	public ResponseEntity<String> wishMessage(@PathVariable("id") int id,@PathVariable("name") String name){
		System.out.println(id +" : " + name);
		System.out.println("WishController.wishMessage()");
		return new ResponseEntity<String>("Good Night Sweet Dreams " +id+
				" " + name ,HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		System.out.println("WishController.registerTourist()" + tourist);
		
		return new ResponseEntity<String>("Tourist is Created :" + tourist.toString(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable("id") int id){
		System.out.println("WishController.deleteTourist()");
		
		return new ResponseEntity<String>(id +  "  Deleted ",HttpStatus.OK);
	}
}
