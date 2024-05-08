package com.onlinepizza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dao.ICustomerService;
import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.entity.Customer;
import com.onlinepizza.exception.ResourceNotFound;
import com.onlinepizza.repository.CustomerRepository;


@Service
public class ICustomerServiceImpl implements ICustomerService {
@Autowired
CustomerRepository customerrepository;
   public CustomerDTO mapToDto(Customer customer)
   {
	   CustomerDTO customerDTO=new CustomerDTO();
	   customerDTO.setUserId(customer.getUserId());
	   customerDTO.setCustomerFirstName(customer.getCustomerFirstName());
	   customerDTO.setCustomerLastName(customer.getCustomerLastName());
	   customerDTO.setCustomerMobile(customer.getCustomerMobile());
	   customerDTO.setCustomerAddress(customer.getCustomerAddress());
	   customerDTO.setUserName(customer.getUserName());
	   customerDTO.setPassword(customer.getPassword());
	   customerDTO.setEmail(customer.getEmail());
	   customerDTO.setUserRole("Customer");
	   return customerDTO;
    }
	@Override
	public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerFirstName(customerDTO.getCustomerFirstName());
		customer.setCustomerLastName(customerDTO.getCustomerLastName());
		customer.setCustomerMobile(customerDTO.getCustomerMobile());
		customer.setCustomerAddress(customerDTO.getCustomerAddress());
		customer.setUserName(customerDTO.getUserName());
		customer.setPassword(customerDTO.getPassword());
		customer.setEmail(customerDTO.getEmail());
		customer.setUserRole("Customer");
		
		
		return mapToDto(customerrepository.save(customer));
		
	}
     
	
	
	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO,Integer customerId)throws ResourceNotFound{
		Optional<Customer> cust=customerrepository.findById(customerId);
		if(cust.isPresent())
		{
			Customer customer=cust.get();
			customer.setCustomerFirstName(customerDTO.getCustomerFirstName());
			customer.setCustomerLastName(customerDTO.getCustomerLastName());
			customer.setCustomerMobile(customerDTO.getCustomerMobile());
			customer.setCustomerAddress(customerDTO.getCustomerAddress());
			customer.setUserName(customerDTO.getUserName());
			customer.setPassword(customerDTO.getPassword());
			customer.setEmail(customerDTO.getEmail());
			customer.setUserRole("Customer");
			customerrepository.save(customer);
		}else {
			throw new ResourceNotFound("Customer id "+customerId+" not found");
		}
		
		
		return customerDTO;
		
		
	}

	@Override
	public CustomerDTO viewCustomerByPhone(Long phoneNo)throws ResourceNotFound {
		Optional<Customer> customerByPhone = customerrepository.findByCustomerMobile(phoneNo);
		if(customerByPhone.isEmpty()) {
			throw new ResourceNotFound("No records found with matching phone number");
		}
		
		return mapToDto(customerByPhone.get());
	}

	@Override
	
	public List<CustomerDTO> viewAllCustomer()throws ResourceNotFound {
		List<CustomerDTO> list=new ArrayList<>();
		List<Customer> customer = customerrepository.findAll();
		for(Customer cus:customer) {
			list.add(mapToDto(cus));
		}
		if(list.isEmpty()) {
			throw new ResourceNotFound("Customer list is empty");
		}
		return list;
	}

	@Override
	public CustomerDTO viewCustomerById(Integer customerId) throws ResourceNotFound{
		Optional<Customer> customerById = customerrepository.findById(customerId);
		
		if(customerById.isEmpty()) {
			throw new ResourceNotFound("Customer not found");
		}
		 
		return  mapToDto(customerById.get());
	}

	@Override
	public String deleteCustomerById(Integer customerId) throws ResourceNotFound{
	Optional<Customer> customerById = customerrepository.findById(customerId);
	if(customerById.isPresent()) {
	  customerrepository.deleteById(customerId);	
	}
	else {
		 throw new ResourceNotFound("Customer with id "+customerId+" not found");
	}
	return "Deleted Successfully";
	}
}
