package com.spring.Model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

	private Integer id;
	
	private String name;
	
	private List<String> favColors;
	
	private Set<Long> phoneNumber;
	
	private Map<Integer,String> friends;
	
	private boolean isMarried;
	
	private Date DateOfBirth;
	
	private Company company;
	
	
}
