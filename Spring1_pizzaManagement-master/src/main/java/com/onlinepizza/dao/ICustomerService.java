package com.onlinepizza.dao;

import java.util.List;

import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.exception.ResourceNotFound;

public interface ICustomerService{
	
	
	CustomerDTO registerCustomer(CustomerDTO customer);

	CustomerDTO updateCustomer(CustomerDTO customer,Integer customerId)throws ResourceNotFound;

	CustomerDTO viewCustomerByPhone(Long phoneNo)throws ResourceNotFound;

	List<CustomerDTO> viewAllCustomer()throws ResourceNotFound;
	
	CustomerDTO viewCustomerById(Integer customerId)throws ResourceNotFound;
	
	String deleteCustomerById(Integer customerId)throws ResourceNotFound;

}
