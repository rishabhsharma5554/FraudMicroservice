package com.rishabhtech.FraudService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabhtech.FraudService.APIResponse.FraudCheckAPIResponse;
import com.rishabhtech.FraudService.service.FraudCheckService;
import com.rishabhtech.FraudService.entity.FraudCheckHistory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/fraud")
public class FraudController {
	
	private final Logger logger = LoggerFactory.getLogger(FraudController.class);	
	
	@Autowired
	private FraudCheckService fraudCheckService;
	
//	@GetMapping("/")
//	public String getHomePage()
//	{
//		logger.info("Hoem page Called");
//		return "Welcome to my Homepage.";
//	}
	
	
	//CustomerService wil call this api using feign client
	@GetMapping("/{customerId}")
	public FraudCheckAPIResponse isFraudster(@PathVariable(name = "customerId") Integer custId)
	{
		boolean isFraudster = fraudCheckService.isFraudster(custId);
		logger.info(":fraudCheck request for customer {}",custId);
		return new FraudCheckAPIResponse(isFraudster);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<FraudCheckHistory>> getAllFraudsterSummary()
	{
		List<FraudCheckHistory> allSummary = fraudCheckService.getAllSummary();
		return new ResponseEntity<>(allSummary,HttpStatus.OK);
	}
}
