package com.onlinepizza.dao;

import java.util.List;

import com.onlinepizza.dto.CustomerDTO;

public interface ICustomerService{
	
	
	CustomerDTO registerCustomer(CustomerDTO customer);

	CustomerDTO updateCustomer(CustomerDTO customer,Integer customerId);

	CustomerDTO viewCustomerByPhone(Long phoneNo);

	List<CustomerDTO> viewAllCustomer();
	
	CustomerDTO viewCustomerById(Integer customerId);
	
	String deleteCustomerById(Integer customerId);
	
	
	
	

}
