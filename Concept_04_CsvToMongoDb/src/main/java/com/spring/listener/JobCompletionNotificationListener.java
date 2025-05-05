package com.spring.listener;


import org.springframework.batch.core.*;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Job Started: " + jobExecution.getStartTime());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Job Ended: " + jobExecution.getEndTime());
        System.out.println("Status: " + jobExecution.getStatus());
    }
}
