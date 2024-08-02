package com.cdac.billing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.billing.model.Admin;
import com.cdac.billing.model.Customer;

public interface  AdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query("select c from Admin c where c.email = ?1 and c.password = ?2")
	public Optional<Admin> findAdminByEmailAndPassword(String email, String pass);
}
