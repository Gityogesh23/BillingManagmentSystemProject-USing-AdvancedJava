package com.cdac.billing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.billing.exception.CustomerServiceException;
import com.cdac.billing.model.Admin;
import com.cdac.billing.model.Customer;
import com.cdac.billing.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	public Admin login(String email, String password) {
		Optional<Admin> admin =  adminRepository.findAdminByEmailAndPassword(email, password);
		if(admin.isPresent()) {
			return admin.get();
		}
		throw new CustomerServiceException("Invalid Email/Password");

}
}
