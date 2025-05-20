package com.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Model.Actor;
import com.spring.Service.ActorServiceImpl;

@RestController
@RequestMapping("/api")
public class ActorController {
	
	@Autowired
	private ActorServiceImpl actorservice;

	@PostMapping("/save")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		try {
		String msg = actorservice.registerActor(actor);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
		catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}

/*
	@GetMapping("/details")
	public ResponseEntity<Iterable<Actor>> getAllActor(){
		try { 
			Iterable<Actor> list= actorservice.getAll();
			return new ResponseEntity<Iterable<Actor>>(list,HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			return new ResponseEntity<Iterable<Actor>>( HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	*/
	
	@GetMapping("/details")
	public ResponseEntity<?> getAllActor(){
		try { 
			Iterable<Actor> list= actorservice.getAll();
			return new ResponseEntity<Iterable<Actor>>(list,HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
	@GetMapping("/detailsById/{id}")
	public ResponseEntity<?> FetchById(@PathVariable Integer id){
		try {
			Actor actor = actorservice.getById(id);
			return new ResponseEntity<Actor>(actor,HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateActor")
	public ResponseEntity<String> updateActor(@RequestBody Actor actor){
		try {
			String msg = actorservice.updateActor(actor);
			return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
		
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
		}
	}
	
	@GetMapping("/actorInfo/{category1}/{category2}")
	public ResponseEntity<?> fetchByCategory(@PathVariable String category1,@PathVariable String category2){
		try {
			List<Actor> list = actorservice.fetchBycategory(category1, category2);
			return new ResponseEntity<List<Actor>>(list,HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
	
		try {
			String result = actorservice.deleteById(id);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	
	@PatchMapping("/updateMobile/{id}/{mobileNo}")
	public ResponseEntity<String> updateMoblie(@PathVariable("id") Integer id,@PathVariable("mobileNo") long moblieNo){
	
		try {
			String result = actorservice.updateActorMoblie(id, moblieNo);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}	
	}
}
