package com.cdac.billing.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.billing.dto.LoginStatus;
import com.cdac.billing.dto.RegistrationStatus;
import com.cdac.billing.exception.CustomerServiceException;
import com.cdac.billing.model.Customer;
import com.cdac.billing.repository.CustomerRepository;
import com.cdac.billing.service.CustomerService;
import com.cdac.billing.dto.Status;
@RestController

@CrossOrigin("http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired	
	private CustomerService customerService;

	@PostMapping("/customer")
	public Status register(@RequestBody Customer customer) {
		try {
		int id = customerService.register(customer);
		RegistrationStatus status = new RegistrationStatus();
		status.setStatus(true);
		status.setMessageIfAny("Registration successful!");
		status.setCustomerId(id);
		return status;
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
//		Customer newCustomer(@RequestBody Customer newCustomer) {
//			return customerRepository.save(newCustomer);
//	}
	}
	@GetMapping("/customers")
	List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	@PostMapping("/customer/login")
	public Status login(@RequestBody Customer loginDetails) {
		try {
			Customer customer = customerService.login(loginDetails.getEmail(), loginDetails.getPass());
			LoginStatus status = new LoginStatus();
			status.setStatus(true);
			status.setMessageIfAny("Login successful!");
//			status.setCustomerId(customer.getCust_id());
//			status.setName(customer.getFname());
			//status.setCustomer(customer);
			return status;
		}
		catch (CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
	
	 @PutMapping("/customer/{cust_id}")
	public Customer updateUser(@RequestBody Customer newCustomer, @PathVariable Integer cust_id) {
	        return customerRepository.findById(cust_id)
	                .map(customer -> {
	                    customer.setFname(newCustomer.getFname());
	                    customer.setLname(newCustomer.getLname());
	                    customer.setGender(newCustomer.getGender());
	                    customer.setAdhar(newCustomer.getAdhar());
	                     customer.setAddress(newCustomer.getAddress());
	                    customer.setMob(newCustomer.getMob());
	                    customer.setEmail(newCustomer.getEmail());
	                    customer.setPass(newCustomer.getPass());
	                    return customerRepository.save(customer);
	                }).orElseThrow(() -> new CustomerServiceException(cust_id));	
	    }
	 
	 @GetMapping("/customer/{cust_id}")
	  Customer getCustById(@PathVariable Integer cust_id) {
		 return customerRepository.findById(cust_id)
	                .orElseThrow(() -> new CustomerServiceException(cust_id));
	 }
	 
	
	@DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Integer id){
        if(!customerRepository.existsById(id)){
            throw new CustomerServiceException(id);
        }
        customerRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
                  
	

	   
	}

