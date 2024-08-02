package com.cdac.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cdac.billing.model.MobileTransaction;
import com.cdac.billing.repository.MobileRepository;
@Service
public class MobileService {
	
	@Autowired
	private MobileRepository mobileRepository;
	
	public int register(String customerName, String mobileNo , double rechargeAmount) {
		MobileTransaction mobileTransaction = new MobileTransaction();
		mobileTransaction.setCustomerName(customerName);
		mobileTransaction.setRechargeAmount(rechargeAmount);
		mobileTransaction.setMobileNo(mobileNo);
		
		mobileRepository.save(mobileTransaction);
			return mobileTransaction.getTrx_id();
		}
}
	