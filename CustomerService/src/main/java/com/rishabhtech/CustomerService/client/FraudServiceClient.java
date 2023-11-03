package com.rishabhtech.CustomerService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rishabhtech.CustomerService.customResponse.FraudCheckAPIResponse;

@FeignClient(name="FRAUD-SERVICE")
public interface FraudServiceClient {
	
	//http://localhost:8081/api/v1/fraud/23
	@GetMapping("/api/v1/fraud/{customerId}")
	public FraudCheckAPIResponse isFraudster(@PathVariable("customerId") Integer custId);

}
 