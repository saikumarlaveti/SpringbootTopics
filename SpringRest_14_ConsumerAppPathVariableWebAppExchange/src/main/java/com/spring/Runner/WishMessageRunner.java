package com.spring.Runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishMessageRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		//get method -- report
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:8080/SpringRest_14_ProviderAppPathVariableJSONDataExchange/wish/api/report";
		// serviceUrl is changed project to project because of each runs their server.
		//This url same as 12project because i can't change project name in application.properties 
	
		ResponseEntity<String> response = template.exchange(serviceUrl,
													HttpMethod.GET, 
													null, 
													String.class);
		System.out.println("response Body/payload(output) : " + response.getBody());
		System.out.println("Response Status code Value  : " + response.getStatusCodeValue());
		System.out.println("response Code : " + response.getStatusCode());
		System.out.println("response Header : " + response.getHeaders());
		
		
		
		
		 serviceUrl = "http://localhost:8080/SpringRest_14_ProviderAppPathVariableJSONDataExchange/wish/api/message/{id}/{name}";
		// serviceUrl is changed project to project because of each runs their server.
		//This url same as 12project because i can't change project name in application.properties 
	
		ResponseEntity<String> response1 = template.exchange(serviceUrl,
													HttpMethod.GET, 
													null, 
													String.class,
													Map.of("id",2001,"name","Saikumar"));
		System.out.println("response Body/payload(output) : " + response1.getBody());
		System.out.println("Response Status code Value  : " + response1.getStatusCodeValue());
		System.out.println("response Code : " + response1.getStatusCode());
		System.out.println("response Header : " + response1.getHeaders());
		
		
		
		
	}

	
}
