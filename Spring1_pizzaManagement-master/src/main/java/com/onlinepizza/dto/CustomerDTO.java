package com.onlinepizza.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerDTO extends UserDTO{

	@NotBlank(message="Customer first name should not be empty")
	@Size(max = 10, message = "Customer first name should not exceed 10 characters")
	private String customerFirstName;

	@NotBlank(message="Customer last name should not be empty")
	@Size(max = 10, message = "Customer last name should not exceed 10 characters")
	private String customerLastName;
	
	private Long customerMobile;
	@NotBlank(message="Address should not be empty")
	private String customerAddress;
	
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public Long getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(Long customerMobileDTO) {
		this.customerMobile = customerMobileDTO;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddressDTO) {
		this.customerAddress = customerAddressDTO;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
				+ ", customerMobile=" + customerMobile + ", customerAddress=" + customerAddress + "]";
	}
	
	
	

}
