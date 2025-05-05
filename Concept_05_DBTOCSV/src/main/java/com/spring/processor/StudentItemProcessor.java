package com.spring.processor;

import org.springframework.batch.item.ItemProcessor;

import com.spring.model.Student;

public class StudentItemProcessor implements ItemProcessor<Student, Student> {
    @Override
    public Student process(Student student) {
        // Example: uppercase name
        student.setName(student.getName().toUpperCase());
        return student;
    }
}
