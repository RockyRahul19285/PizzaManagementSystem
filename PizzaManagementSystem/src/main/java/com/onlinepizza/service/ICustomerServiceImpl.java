package com.onlinepizza.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.Repository.CustomerRepository;
import com.onlinepizza.dao.ICustomerService;
import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.entity.Customer;


@Service
public class ICustomerServiceImpl implements ICustomerService {
@Autowired
CustomerRepository customerrepository;


@Autowired
private ModelMapper modelMapper;

public CustomerDTO mapToDto(Customer c)
{
	return modelMapper.map(c, CustomerDTO.class);
}

public Customer mapToEntity(CustomerDTO cd)
{
	return modelMapper.map(cd, Customer.class);
}
	@Override
	public CustomerDTO registerCustomer(CustomerDTO customer) {
		Customer cus= new Customer();
		
		cus.setCustomerName(customer.getCustomerName());
		cus.setCustomerEmail(customer.getCustomerEmail());
		cus.setCustomerMobile(customer.getCustomerMobile());
		cus.setCustomerAddress(customer.getCustomerAddress());
		cus.setUserId(customer.getUserId());
		cus.setUserName(customer.getUserName());
		cus.setPassword(customer.getPassword());
	    cus.setCity(customer.getCity());
		cus.setUserRole("customer");
		customerrepository.save(cus);
		return customer;
	}
     
	
	@Override
	public CustomerDTO updateCustomer(CustomerDTO customer,Integer customerId) {
		Optional<Customer> cust=customerrepository.findById(customerId);
		if(cust.isPresent())
		{
			Customer cus=cust.get();
			cus.setCustomerName(customer.getCustomerName());
			cus.setCustomerEmail(customer.getCustomerEmail());
			cus.setCustomerMobile(customer.getCustomerMobile());
			cus.setCustomerAddress(customer.getCustomerAddress());
			cus.setUserName(customer.getUserName());
			cus.setPassword(customer.getPassword());
			
			cus.setCity(customer.getCity());
			cus.setUserRole("customer");
			customerrepository.save(cus);
		}
		
		
		return customer;
		
		
	}

	@Override
	public CustomerDTO viewCustomerByPhone(Long phoneNo) {
		return mapToDto(customerrepository.findByCustomerMobile(phoneNo));
	}

	@Override
	public List<CustomerDTO> viewAllCustomer() {
		List<CustomerDTO> list=new ArrayList();
		List<Customer> customer = customerrepository.findAll();
		for(Customer cus:customer) {
			list.add(mapToDto(cus));
		}
		return list;
	}

	@Override
	public CustomerDTO viewCustomerById(Integer customerId) {
		
		return mapToDto(customerrepository.findById(customerId).get());
	}

	@Override
	public String deleteCustomerById(Integer customerId) {
		customerrepository.deleteById(customerId);
		
		return "Deleted Successfully";
	}

}
