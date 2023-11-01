package com.rishabhtech.CustomerService.repository;

import com.rishabhtech.CustomerService.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {


}
