package com.spring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
	
	private int id;
	
	private String Name;
	
	private String Location;
	
	private int Size;
	
	private double turnOver;
	
	private String category;
	

}
