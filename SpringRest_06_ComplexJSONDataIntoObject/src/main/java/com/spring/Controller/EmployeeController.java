package com.spring.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Company;
import com.spring.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@PostMapping("/register")
	public ResponseEntity<Employee> showDetails(@RequestBody Employee emp){
		System.out.println("EmployeeController.showDetails()");
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@PostMapping("/resCom")
	public ResponseEntity<Company> registerCompany(@RequestBody Company com){
		System.out.println("EmployeeController.registerCompany()");
		return new ResponseEntity<Company>(com,HttpStatus.OK);
	}
}
