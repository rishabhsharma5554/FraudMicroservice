package com.rishabhtech.CustomerService.customResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckAPIResponse {
	private Boolean isFraudster;
}

