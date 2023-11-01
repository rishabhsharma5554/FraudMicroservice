package com.rishabhtech.FraudService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishabhtech.FraudService.entity.FraudCheckHistory;

public interface FraudRepository extends JpaRepository<FraudCheckHistory, Integer> {

}
