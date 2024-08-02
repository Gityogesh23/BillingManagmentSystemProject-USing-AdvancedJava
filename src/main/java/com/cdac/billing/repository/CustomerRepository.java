package com.cdac.billing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac.billing.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select count(c) from Customer c where c.email = ?1")
	public Long findIfCustomerExists(String email);



	@Query("select c from Customer c where c.email = ?1 and c.pass = ?2")
	public Optional<Customer> findCustomerByEmailAndPassword(String email, String pass);

	public Optional<Customer> findByEmail(String email);
}
