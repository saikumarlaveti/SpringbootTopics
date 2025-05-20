package com.spring.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class StandloneRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Value("${service.url}")
	private String serviceUrl;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		RestTemplate rt = new RestTemplate();
		String serviceUrl = "http://localhost:8080/SpringRest_12_ProviderApp/wish/api/message";
		
		ResponseEntity<String> response = rt.getForEntity(serviceUrl,String.class);
		System.out.println("response Body/payload(output) : " + response.getBody());
		System.out.println("Response Status code Value  : " + response.getStatusCodeValue());
		System.out.println("response Code : " + response.getStatusCode());
		System.out.println("response Header : " + response.getHeaders());
	}

}
