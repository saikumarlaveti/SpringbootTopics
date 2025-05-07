package com.spring.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Model.Company;

@RestController
@RequestMapping("/company/api")
public class CompanyController {
	
	
	@GetMapping("/show")
	public ResponseEntity<Company> showCompanyDetails(){
		
		Company company = new Company(1,"TCS","Hyderabad", 10000, 500000.0,"IT");
		return new ResponseEntity<Company>(company,HttpStatus.OK);
	}

	
	
	
}
