package com.onlinepizza.entity;

import jakarta.persistence.Entity;

@Entity
public class Customer extends User{
	
	private String customerFirstName;
	private String customerLastName;
	private Long customerMobile;
	private String customerAddress;
	
		
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerName) {
		this.customerFirstName = customerName;
	}
	public Long getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(Long customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	@Override
	public String toString() {
		return "Customer [customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
				+ ", customerMobile=" + customerMobile + ", customerAddress=" + customerAddress + "]";
	}
	
	
	

}
