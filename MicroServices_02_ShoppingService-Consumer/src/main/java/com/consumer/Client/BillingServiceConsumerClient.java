package com.consumer.Client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class BillingServiceConsumerClient {

	@Autowired
	private DiscoveryClient client;
	
	public String BillingInfo() {
		List<ServiceInstance> listInstance = client.getInstances("MicroServices_02_BillingService-producer");
		
		ServiceInstance instance = listInstance.get(0);
		
		URI uri = instance.getUri(); // get one instance
		
		String url = uri.toString()+"/billing/api/bill";
	
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class);
		//ResponseEntity<String> response = template.getForEntity(url, String.class); 
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode());
		String result = response.getBody();
		
		return result;
	}
}
