package com.spring.Runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		

	
	RestTemplate template = new RestTemplate();
	
	String serviceUrl ="http://localhost:8080/SpringRest_12_ProviderApp/wish/api/delete/{id}";

	
//	ResponseEntity<String> result = template.getForEntity(serviceUrl, String.class);
	
	template.delete(serviceUrl,Map.of("id",101));
	
	
	System.out.println("Deleter operation Done");
	
	}
}
