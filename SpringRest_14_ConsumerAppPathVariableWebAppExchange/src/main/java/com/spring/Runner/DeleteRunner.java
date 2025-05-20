package com.spring.Runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
			
	RestTemplate template = new RestTemplate();
	
	String serviceUrl ="http://localhost:8080/SpringRest_14_ProviderAppPathVariableJSONDataExchange/wish/api/delete/{id}";
	ResponseEntity<String> response = template.exchange(serviceUrl,
			HttpMethod.DELETE, 
			null, 
			String.class,
			858);
System.out.println("response Body/payload(output) : " + response.getBody());
System.out.println("Response Status code Value  : " + response.getStatusCodeValue());
System.out.println("response Code : " + response.getStatusCode());
System.out.println("response Header : " + response.getHeaders());

	
	
	System.out.println("Deleter operation Done");
	
	}
}
