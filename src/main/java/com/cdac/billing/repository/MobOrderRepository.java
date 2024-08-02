package com.cdac.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.billing.model.MobileRecharge;
import com.cdac.billing.model.MobileTransaction;

public interface MobOrderRepository extends JpaRepository<MobileRecharge, Integer>{


}
