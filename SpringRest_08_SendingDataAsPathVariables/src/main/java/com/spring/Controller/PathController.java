package com.spring.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PathController {

//	@GetMapping("/report/{sno}/{sname}")
//	public ResponseEntity<String> showData(@PathVariable("sno") int sno,
//											@PathVariable String sname)
//	{
//		System.out.println("PathController.showData()");
//		System.out.println(sno + " " + sname);
//		return new ResponseEntity<String>(sno + " : "+ sname,HttpStatus.OK);
//	}
	
	
	
	@GetMapping("/report/{sno}/{sname}")
	public ResponseEntity<String> showData1(@PathVariable(name="sno",required=false) Integer sno,
											@PathVariable(required=false) String sname)
	{
		return new  ResponseEntity<String>("showData - 1",HttpStatus.OK);
	}
	
	@GetMapping("/report/sno/{sname}")
	public ResponseEntity<String> showData2(@PathVariable(name="sno",required=false) Integer sno,
											@PathVariable(required=false) String sname)
	{
		return new  ResponseEntity<String>("showData - 2",HttpStatus.OK);
	}
	
	@GetMapping("/report/{sno}/sname")
	public ResponseEntity<String> showData3(@PathVariable(name="sno",required=false) Integer sno,
											@PathVariable(required=false) String sname)
	{
		return new  ResponseEntity<String>("show - 3",HttpStatus.OK);
	}
	
	@GetMapping("/report/sno/sname")
	public ResponseEntity<String> showData4(@PathVariable(name="sno",required=false) Integer sno,
											@PathVariable(required=false) String sname)
	{
		return new  ResponseEntity<String>("show - 4",HttpStatus.OK);
	}
}
