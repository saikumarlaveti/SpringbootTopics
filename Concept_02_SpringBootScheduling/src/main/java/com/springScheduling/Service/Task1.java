package com.springScheduling.Service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("task1")
public class Task1 {
	
	//@Scheduled(initialDelay = 10000,fixedDelay=3000)
	//@Scheduled(initialDelay = 10000,fixedRate=3000)
	@Scheduled(cron = "5 5 5 5 4 6 ")
	public void doTask() {
		System.out.println("Task1.doTask()" + new Date());
	}

	//@Scheduled(fixedDelay=35000)
	public void greet() {
		System.out.println("Hello Saikumar" );
	}
}

/*
 * First Star - seconds -->   "5 * * * * *"
 * Second Star -  minutes --> "5 5 * * * *"
 * Third Star -  05:05:05  --> "5 5 5 * * *"
 * Fourth Star -  05:05:05 at 7 days --> "5 5 5 7 * *"
 * Fifth Star - at 05:05:05 at 5 day at April month --> 5 5 5 5 4 *
 * six Star - at 05:05:05 at 5 day at April month Saturday day --> 5 5 5 5 5 4 6 
 */
