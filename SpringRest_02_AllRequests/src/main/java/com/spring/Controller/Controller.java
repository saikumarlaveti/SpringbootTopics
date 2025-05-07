package com.spring.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Controller {

	@GetMapping("/getAllStudent")
	public ResponseEntity<String> getAllStudent(){
		System.out.println("Controller.getAllStudent()");
		return new  ResponseEntity<String>("Get Mapping -- getAll Employees",HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> savaStudent(){
		System.out.println("Controller.savaStudent()");
		return new ResponseEntity<String>("Post Mapping : save Student" ,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent(){
		System.out.println("Controller.deleteStudent()");
		return new ResponseEntity<String>("Delete Mapping : Delete Student ",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(){
		System.out.println("Controller.updateStudent()");
		return new ResponseEntity<String>("Update Mapping : update Student ",HttpStatus.OK);
	}
	
	@PatchMapping("/patchUpdate")
	public ResponseEntity<String> updateStudents(){
		System.out.println("Controller.updateStudent()");
		return new ResponseEntity<String>("Update Mapping : update Student ",HttpStatus.OK);
	}
	
	
}
