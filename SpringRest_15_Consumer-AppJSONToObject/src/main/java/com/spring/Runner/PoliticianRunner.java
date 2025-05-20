package com.spring.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.Model.Politician;

@Component
public class PoliticianRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		String serviceUrl = "http://localhost:8080/SpringRest_15_ProducerAppJSONToObject/politician/api/find/{id}";
		
		ResponseEntity<String> result = template.exchange(serviceUrl,
																HttpMethod.GET, 
																null, 
																String.class,
																101);
		
		System.out.println(result.getStatusCode());
		System.out.println(result.getBody());
		System.out.println(result.hashCode());
		System.out.println(result.getStatusCodeValue());
		
		
		ObjectMapper mapper = new ObjectMapper();
		Politician politician = mapper.readValue(result.getBody(), Politician.class);
		System.out.println("json to Object convert data ::" + politician);
		
		
	}

	
}
