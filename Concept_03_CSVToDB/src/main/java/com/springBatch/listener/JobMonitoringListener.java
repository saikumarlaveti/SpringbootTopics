package com.springBatch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener {

	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job Status" + jobExecution.getStatus());
		System.out.println("Job Status Time" + jobExecution.getStartTime());

	}

	public void afterJob(JobExecution jobExecution) {
		System.out.println("Job Status" + jobExecution.getStatus());
		System.out.println("Job end Time" + jobExecution.getStartTime());
		System.out.println("Job Exit  Status " + jobExecution.getExitStatus());
	}
}
