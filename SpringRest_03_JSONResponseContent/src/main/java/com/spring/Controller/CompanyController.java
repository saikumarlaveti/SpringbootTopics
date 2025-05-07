package com.spring.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Model.Company;
import com.spring.Model.Employee;

@RestController
@RequestMapping("/company/api")
public class CompanyController {
	
//	@GetMapping("/show")
//	public ResponseEntity<Company> showCompanyDetails(){
//		
//		Company company = new Company(1,"TCS","Hyderabad", 10000, 500000.0,"IT");
//		return new ResponseEntity<Company>(company,HttpStatus.OK);
//	}

	@GetMapping("/show")
	public Company showCompanyDetails(){
		
		Company company = new Company(1,"TCS","Hyderabad", 10000, 500000.0,"IT");
		return company;
	}
	
	
	@GetMapping("/showAll")
	public Employee showEmployeeDetails(){
		Company company = new Company(1,"TCS","Hyderabad", 10000, 500000.0,"IT");
		Employee emp = new Employee(1, 
				                    "Saikumar Laveti", 
				                    List.of("Green","Black","Red"), 
				                    Set.of(7995663051L,8501905061L), 
				                    Map.of(1,"Santosh Kumar",2,"Saikumar"), 
				                    false, 
				                    new Date(2000, 07, 10),
				                    company);
		return emp;
	}
}
