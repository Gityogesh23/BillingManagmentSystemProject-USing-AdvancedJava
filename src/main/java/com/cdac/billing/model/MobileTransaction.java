package com.cdac.billing.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_customer_mobile2")
public class MobileTransaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trx_id;
	
	public String customerName;
    public String mobileNo;
    public double rechargeAmount;
    private String status;
    
 

	public int getTrx_id() {
		return trx_id;
	}
	public void setTrx_id(int trx_id) {
		this.trx_id = trx_id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public double getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
