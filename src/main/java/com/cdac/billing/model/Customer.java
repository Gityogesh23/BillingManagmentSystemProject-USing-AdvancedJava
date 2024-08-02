package com.cdac.billing.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_customer2")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cust_id;
	String fname;
	String lname;
	String gender;
	long adhar;
	String address;
	long mob;
	String email;
	String pass;
			
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL )
	private List<ElectricityTransaction> electricityTransactions;
		
	
	public int getCust_id() {
		return cust_id;
	}
	
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public List<ElectricityTransaction> getElectricityTransactions() {
		return electricityTransactions;
	}

	public void setElectricityTransactions(List<ElectricityTransaction> electricityTransactions) {
		this.electricityTransactions = electricityTransactions;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public long getAdhar() {
		return adhar;
	}
	public void setAdhar(long adharNo) {
		this.adhar = adharNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
