package com.spring.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

	
	private LocalDateTime time;
	
	private String message;
	
	private String status;
	
	
}
