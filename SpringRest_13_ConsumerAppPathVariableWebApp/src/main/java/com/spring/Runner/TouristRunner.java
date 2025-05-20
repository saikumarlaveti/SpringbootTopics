package com.spring.Runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TouristRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		RestTemplate template = new RestTemplate();
		
		String serviceUrl = "http://localhost:8080/SpringRest_12_ProviderApp/wish/api/register";
		
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonBody = "{\"tid\":401,\"tname\":\"saikumar\",\"startVillage\":\"Guravam\",\"endVillage\":\"Hyderabad\"}";
		//we can pass the value different ways
		
		HttpEntity<String> request = new HttpEntity<String>(jsonBody,headers);
		
		ResponseEntity<String> response = template.postForEntity(serviceUrl, request, String.class);
		
		System.out.println("response Body/payload(output) : " + response.getBody());
		System.out.println("Response Status code Value  : " + response.getStatusCodeValue());
		System.out.println("response Code : " + response.getStatusCode());
		System.out.println("response Header : " + response.getHeaders());
		
		
		String response1 = template.postForObject(serviceUrl, request, String.class);
		System.out.println("response contect /body :: " + response1);

		
		
	}

}
