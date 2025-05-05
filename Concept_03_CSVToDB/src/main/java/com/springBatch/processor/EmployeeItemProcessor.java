package com.springBatch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.springBatch.Model.Employee;

@Component
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee > {

	@Override
	public Employee process(Employee emp) throws Exception {

		
		return emp;
	}

}
