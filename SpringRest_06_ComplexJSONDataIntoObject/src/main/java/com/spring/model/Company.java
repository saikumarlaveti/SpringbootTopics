package com.spring.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Company {
	
	private Long companyId;
	
	private String companyName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dos;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dtos;
	
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime tos;
	
	private List<Project> proInfo;
}
