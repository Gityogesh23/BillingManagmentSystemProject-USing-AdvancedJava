package com.cdac.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.billing.dto.RegistrationStatus;
import com.cdac.billing.dto.Status;
import com.cdac.billing.exception.CustomerServiceException;

import com.cdac.billing.model.ElectricityTransaction;
import com.cdac.billing.service.ElectricityService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ElectricityCalculatorController {

	@Autowired
	ElectricityService electricityService;
	

	@PostMapping("/calculate-bill")
	public Status calculateBill(@RequestBody ElectricityTransaction custDetails ) {
		try {
		electricityService.register(custDetails.custName,custDetails.meter,custDetails.amount);
//		double amount = electricityService.calculator(unit);
//		return amount;
		RegistrationStatus status = new RegistrationStatus();
		status.setStatus(true);
		status.setMessageIfAny("Registration successful!");		
		return status;
		}
		catch(CustomerServiceException e){
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
}
