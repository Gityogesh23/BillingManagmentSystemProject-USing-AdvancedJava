package com.cdac.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.billing.model.MobileTransaction;

public interface MobileRepository extends JpaRepository<MobileTransaction, Integer>{ 

}

