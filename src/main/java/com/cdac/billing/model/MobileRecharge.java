package com.cdac.billing.model;

//import com.razorpay.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_mobrechargeorder")
public class MobileRecharge {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trx_id;
	
    private String orderId;

    private String amount;

    private String receipt;

    private String status;

	public int getTrx_id() {
		return trx_id;
	}

	public void setTrx_id(int trx_id) {
		this.trx_id = trx_id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

   
    
}
