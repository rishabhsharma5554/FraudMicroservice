package com.rishabhtech.CustomerService.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabhtech.CustomerService.client.FraudServiceClient;
import com.rishabhtech.CustomerService.customResponse.APIResponse;
import com.rishabhtech.CustomerService.dao.Customer;
import com.rishabhtech.CustomerService.service.CustomerService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private FraudServiceClient fraudServiceClient;
    
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

//    @GetMapping("/")
//    public String helloWorld()
//    {
//        logger.info("customerGetMethod called.");
//        return "Hello World, Welcome to home page";
//    }


    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        List<Customer> allCustomers = this.customerService.getAllCustomers();
        logger.info("Data Retrieved using getAllCustomers() method.");
        return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<APIResponse> saveCustomer(@RequestBody Customer customer)
    {
        this.customerService.saveCustomer(customer);
        logger.info("Customer Saved with Name"+customer.getCustFirstName());
        this.fraudServiceClient.isFraudster(customer.getCustId());
        return new ResponseEntity<APIResponse>(new APIResponse()
                .builder()
                .message("Customer Saved Successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .date(new Date())
                .build(), HttpStatus.CREATED);
    }
}
