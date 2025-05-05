package com.spring.runner;


import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobRunner implements CommandLineRunner {

    @Autowired private JobLauncher jobLauncher;
    @Autowired private Job importStudentJob;

    @Override
    public void run(String... args) throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addDate("time", new Date())
                .toJobParameters();

        JobExecution execution = jobLauncher.run(importStudentJob, params);
        System.out.println("Job Exit Status: " + execution.getExitStatus());
    }
}
