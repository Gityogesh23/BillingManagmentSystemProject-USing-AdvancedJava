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

import com.cdac.billing.exception.CustomerServiceException;
import com.cdac.billing.model.Customer;
import com.cdac.billing.repository.CustomerRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/customer")
	Customer newCustomer(@RequestBody Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}
	
	@GetMapping("/customers")
	List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
//	 @PutMapping("/customer/{cust_id}")
//	    Customer updateUser(@RequestBody Customer newUser, @PathVariable Integer cust_id) {
//	        return customerRepository.findBy(cust_id)
//	                .map(user -> {
//	                    user.setUsername(newUser.getUsername());
//	                    user.setName(newUser.getName());
//	                    user.setEmail(newUser.getEmail());
//	                    return userRepository.save(user);
//	                }).orElseThrow(() -> new UserNotFoundException(id));
//	    }
	
	@DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Integer id){
        if(!customerRepository.existsById(id)){
            throw new CustomerServiceException(id);
        }
        customerRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
                  
	

	    @GetMapping("/calculate-bill")
	    public double calculateBill(@RequestParam int unit, @RequestParam double unitPerCharges) {
	        // Calculate total bill amount
	        double total = unit * unitPerCharges;
	        return total;
	    }
	}

