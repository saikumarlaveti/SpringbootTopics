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
    @Autowired private Job job;

    @Override
    public void run(String... args) throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addDate("runTime", new Date())
                .toJobParameters();
        jobLauncher.run(job, params);
    }
}
