package com.Test.Controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket")
public class TicketBookingController {

	@GetMapping("/booking")
	@HystrixCommand(fallbackMethod ="doomBookTicket")
	public String ticketBooking() {
		System.out.println("TicketBookingController.ticketBooking()");
		if(new Random().nextInt(10)<5)	
				throw new RuntimeException("Problem in business logic");
		
		return "output from b.logic";
	}
	
	public String doomBookTicket() {
		System.out.println("TicketBookingController.doomBookTicket()");
		return "please tryagain after some time";
	}
}
