package com.rishabhtech.CustomerService.service;

import java.util.List;
import com.rishabhtech.CustomerService.dao.Customer;
public interface CustomerService {
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
}
