package com.consumer.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("BillingService")
public interface BillingServiceConsumerClient {


	@GetMapping("/billing/api/bill")
	public ResponseEntity<String> fetchBillingInfo();
	}