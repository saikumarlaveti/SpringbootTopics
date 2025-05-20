package com.spring.Runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishMessageRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		RestTemplate rt = new RestTemplate();
		String serviceUrl = "http://localhost:8080/SpringRest_12_ProviderApp/wish/api/message/{id}/{name}";
		// serviceUrl is changed project to project because of each runs their server.
		//This url same as 12project because i can't change project name in application.properties 
		ResponseEntity<String> response = rt.getForEntity(serviceUrl,String.class,
				Map.of("name","Saikumar Laveti","id",40));
		System.out.println("response Body/payload(output) : " + response.getBody());
		System.out.println("Response Status code Value  : " + response.getStatusCodeValue());
		System.out.println("response Code : " + response.getStatusCode());
		System.out.println("response Header : " + response.getHeaders());
		
		System.out.println("ConsumerRunner.run()");
		String response1 = rt.getForObject(serviceUrl,String.class,28,"Santosh Kumar" );
		System.out.println("Response Content is :" + response1);
	}

	
}
