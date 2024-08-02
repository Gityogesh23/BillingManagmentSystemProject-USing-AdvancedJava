package com.cdac.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.billing.model.MobileRecharge;
import com.cdac.billing.repository.MobOrderRepository;
import com.cdac.billing.repository.MobileRepository;
import com.razorpay.Order;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MobileRechargeService {
	
	@Autowired MobOrderRepository mobOrderRepo;
	
	  public void details(Order order) {
		  
		MobileRecharge myorder = new MobileRecharge();
		myorder.setAmount(order.get("amount")+"");
		myorder.setOrderId(order.get("id")+"");
		myorder.setReceipt(order.get("receipt"));
		myorder.setStatus(order.get("status"));
		
		mobOrderRepo.save(myorder);
		
}
}
