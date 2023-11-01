package com.rishabhtech.FraudService.service;

import com.rishabhtech.FraudService.entity.FraudCheckHistory;
import java.util.List;

public interface FraudCheckService {
	public boolean isFraudster(Integer customerId);
	public List<FraudCheckHistory> getAllSummary();
	
}
