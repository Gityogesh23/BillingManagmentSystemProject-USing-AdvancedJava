package com.cdac.billing.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.billing.dto.RegistrationStatus;
import com.cdac.billing.dto.Status;
import com.cdac.billing.exception.CustomerServiceException;
import com.cdac.billing.model.MobileRecharge;
import com.cdac.billing.model.MobileTransaction;
import com.cdac.billing.repository.MobOrderRepository;
import com.cdac.billing.repository.MobileRepository;
import com.cdac.billing.service.MobileRechargeService;
import com.cdac.billing.service.MobileService;
import com.razorpay.Invoice;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@CrossOrigin("http://localhost:3000")
public class MobileBillCalculatorController {

	@Autowired MobileService mobileService;
	
	@Autowired  MobileRechargeService mobileRecService;
	
	@Value("${rzp_key_id}")
    private String keyId;

    @Value("${rzp_key_secret}")
    private String secret;
	
	
	@PostMapping("/topup")
	public Status initiateTopUp(@RequestBody MobileTransaction transactionDetails) {
		try {		
		mobileService.register(transactionDetails.customerName,transactionDetails.mobileNo,transactionDetails.rechargeAmount);
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
	
	@GetMapping("/newinvoice/{amount}")
	public String generateNewinvoice(@PathVariable String amount) throws RazorpayException {
		RazorpayClient razorpayClient = new RazorpayClient(keyId, secret);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "order_receipt_11");

        Order order = razorpayClient.orders.create(orderRequest);
        String orderId = order.get("id");
        
        mobileRecService.details(order);

        return orderId;
		
	}
}
	