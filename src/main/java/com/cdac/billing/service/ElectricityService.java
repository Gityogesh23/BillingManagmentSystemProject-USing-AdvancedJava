package com.cdac.billing.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.billing.model.ElectricityTransaction;
import com.cdac.billing.repository.ElectricityRepository;


import jakarta.transaction.Transactional;
@Service
@Transactional
public class ElectricityService {

	@Autowired
	private ElectricityRepository electricityRepository;
	private ElectricityTransaction electricityTransaction;
	
	public int register( String custName, int meter , double amount ) {
		ElectricityTransaction electricityTransaction = new ElectricityTransaction();
		electricityTransaction.setCustName(custName);
		electricityTransaction.setAmount(amount);
		electricityTransaction.setMeter(meter);		
		electricityRepository.save(electricityTransaction);
			return electricityTransaction.getTransaction_id();
		}
}




