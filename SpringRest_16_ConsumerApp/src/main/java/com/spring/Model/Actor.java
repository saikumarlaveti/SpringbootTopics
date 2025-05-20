package com.spring.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class Actor {

	
	private Integer actorId;
	
	private String actorName;
	
	private String category;
	
	private Long moblieNo =123456789L;
}
