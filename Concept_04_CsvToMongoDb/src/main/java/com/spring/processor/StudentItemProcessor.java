package com.spring.processor;


import org.springframework.batch.item.ItemProcessor;

import com.spring.model.Student;

import org.springframework.batch.item.ItemProcessor;

public class StudentItemProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        // You can apply any transformation here if needed
        student.setName(student.getName().toUpperCase());  // Example: convert name to uppercase
        return student;
    }
}


