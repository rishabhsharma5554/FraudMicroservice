package com.rishabhtech.CustomerService.service;

import org.slf4j.*;
import com.rishabhtech.CustomerService.dao.Customer;
import com.rishabhtech.CustomerService.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<Customer> getAllCustomers()
    {
        logger.info("Retriving Data from DB.");
        return this.customerRepo.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        logger.info("Saving Customer with id "+customer.getCustEmail());
        this.customerRepo.save(customer);
        logger.info("Done Saving");
    }

}
