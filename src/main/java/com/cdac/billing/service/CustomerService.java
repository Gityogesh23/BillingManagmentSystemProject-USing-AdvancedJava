package com.cdac.billing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.billing.exception.CustomerServiceException;
import com.cdac.billing.model.Customer;
import com.cdac.billing.model.ElectricityTransaction;
import com.cdac.billing.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	
	public int register(Customer customer) {
		Long count = customerRepository.findIfCustomerExists(customer.getEmail());
		if(count == 1)
			throw new CustomerServiceException("Customer already registered!");
		else {
			
			customerRepository.save(customer);
			return customer.getCust_id();
		}
	}
	
	public Customer login(String email, String password) {
		Optional<Customer> customer =  customerRepository.findCustomerByEmailAndPassword(email, password);
		if(customer.isPresent()) {
			return customer.get();
		}			
		throw new CustomerServiceException("Invalid Email/Password");
		

		
		
//		Long count = customerRepository.findIfCustomerIsPresent(email, password);
//		if(count == 0)
//			throw new CustomerServiceException("Invalid Email/Password");
//		else {
//			return customerRepository.findByEmail(email).get();
//		}
	}
}
