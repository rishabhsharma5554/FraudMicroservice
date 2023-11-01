package com.rishabhtech.FraudService.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rishabhtech.FraudService.entity.FraudCheckHistory;
import com.rishabhtech.FraudService.repo.FraudRepository;

@Service
public class FraudCheckServiceImpl implements FraudCheckService {

	@Autowired
	private FraudRepository fraudRepo;
	
	@Override
	public boolean isFraudster(Integer customerId) 
	{
		fraudRepo.save(
				FraudCheckHistory
				.builder()
				.customerId(customerId)
				.isFraudster(false)
				.dateTime(LocalDateTime.now())
				.build());
		return false;
	}

	@Override
	public List<FraudCheckHistory> getAllSummary() {		
		return fraudRepo.findAll();
	}

}
