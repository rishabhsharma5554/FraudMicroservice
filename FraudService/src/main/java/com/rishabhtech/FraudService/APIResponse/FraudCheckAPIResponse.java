package com.rishabhtech.FraudService.APIResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckAPIResponse {
	private Boolean isFraudster;
}
