package com.spring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="Actor")
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

	@Id
	@GeneratedValue
	private Integer actorId;
	
	@Column(length=20)
	private String actorName;
	
	@Column(length=20)
	private String category;
	
	private Long moblieNo;
}
