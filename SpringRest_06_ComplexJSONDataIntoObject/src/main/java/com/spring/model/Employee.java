package com.spring.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Employee {

	private Integer empno;
	
	private String empname;
	
	private Address empAddress;
	
	private String[] favColors;
	
	private List<String> friends;
	
	private Set<Long> phoneNumber;
	
	private Map<String,Long> idDetails;
}
