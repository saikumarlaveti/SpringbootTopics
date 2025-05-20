package com.spring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Politician {
	
	private int pid;
	
	private String pname;
	
	private String party;
	
	private String position;
	
	private int age;

}
