package com.cdac.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.billing.dto.LoginStatus;
import com.cdac.billing.dto.Status;
import com.cdac.billing.exception.CustomerServiceException;
import com.cdac.billing.model.Admin;
import com.cdac.billing.model.Customer;
import com.cdac.billing.service.AdminService;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminControl {
	
	@Autowired
	private AdminService adminService;
	

@PostMapping("/admin/login")
public Status login(@RequestBody Admin loginDetails) {
	try {
		Admin admin = adminService.login(loginDetails.getEmail(), loginDetails.getPassword());
		LoginStatus status = new LoginStatus();
		status.setStatus(true);
		status.setMessageIfAny("Login successful!");

		return status;
	}
	catch (CustomerServiceException e) {
		Status status = new Status();
		status.setStatus(false);
		status.setMessageIfAny(e.getMessage());
		return status;
	}
}
}