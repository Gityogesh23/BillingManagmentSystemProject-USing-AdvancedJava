package com.cdac.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.billing.exception.CustomerServiceException;
import com.cdac.billing.model.Customer;
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
}
