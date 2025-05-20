package com.spring.Advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.Exception.ActorNotFoundException;
import com.spring.Model.ErrorDetails;

//@ControllerAdvice
@RestControllerAdvice
public class ActorControllerAdvice {
	//for specific exceptions
	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleActorNotFoundException(ActorNotFoundException anfe){
		System.out.println("ActorControllerAdvice.handleActorNotFoundException()");
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(),"500 - Error Raised",anfe.getMessage());
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//for all exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> allExceptions(Exception e){
		System.out.println("ActorControllerAdvice.handleActorNotFoundException()");
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(),"From ActorControllerAdvice : class",e.getMessage());
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
