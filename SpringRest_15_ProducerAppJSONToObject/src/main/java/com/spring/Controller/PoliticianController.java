package com.spring.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Model.Politician;

@RestController
@RequestMapping("/politician/api")
public class PoliticianController {

	@GetMapping("/find/{id}")
	public ResponseEntity<Politician> fetchById(@PathVariable("id") int id){
		System.out.println("PoliticianController.fetchById()");
		return new ResponseEntity<Politician>(new Politician(id,"Saikumar Laveti","BJP","PM",24),HttpStatus.OK);
	}
	
	
	@GetMapping("/report")
	public ResponseEntity<List<Politician>> fetchAllPoliticians(){
		System.out.println("PoliticianController.fetchAllPoliticians()");
		List<Politician> list= List.of(new Politician(134,"Saikumar Laveti","BJP","PM",24),
				new Politician(456,"Santosh Laveti","YCP","CM",28),
				new Politician(567,"Appalanaidu","TDP","AM",30));
		return new ResponseEntity<List<Politician>>(list,HttpStatus.CREATED); 

}
	@GetMapping("/report1")
	public ResponseEntity<Map<String,Object>> fetchAlLMap(){
		System.out.println("PoliticianController.fetchById()");
		Map<String,Object> map= Map.of("id",1,"aadharNo",69656464,"phone",799566);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.CREATED); 

}
}
