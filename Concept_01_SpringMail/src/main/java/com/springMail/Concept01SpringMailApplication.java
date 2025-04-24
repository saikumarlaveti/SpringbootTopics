package com.springMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springMail.service.IShopping;

@SpringBootApplication
public class Concept01SpringMailApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Concept01SpringMailApplication.class, args);
		
		IShopping service = ctx.getBean("shopping",IShopping.class);
		
		try {
			String result = service.purchase(
					new String[] {"tshirt","trouser","belt"},
					new float[] {1600.0f,4300.0f,43.0f},
					new String[] {"saikumarlaveti5061@gmail.com","saikumarlaveti1431@gmail.com"});
			
			System.out.println(result);
			}
		catch(Exception e) {
			System.out.println(e);
					
		}
	
	}

}
