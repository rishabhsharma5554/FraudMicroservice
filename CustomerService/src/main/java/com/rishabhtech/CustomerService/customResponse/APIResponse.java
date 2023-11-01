package com.rishabhtech.CustomerService.customResponse;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponse {
	private String message;
	private boolean success;
	private HttpStatus httpStatus;
	private Date date;
}
