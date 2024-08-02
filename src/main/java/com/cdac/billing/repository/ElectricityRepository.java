package com.cdac.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.billing.model.ElectricityTransaction;

public interface ElectricityRepository extends JpaRepository<ElectricityTransaction,Integer>{
	
}
