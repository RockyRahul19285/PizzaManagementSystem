package com.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dao.ICustomerService;
import com.onlinepizza.dto.CustomerDTO;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService icustomerservice;
	
	@PostMapping("/save")
	public CustomerDTO addCustomer(@RequestBody CustomerDTO customer) {
		CustomerDTO cusDTO = icustomerservice.registerCustomer(customer);
		return customer;
	}
	
	
	@GetMapping
	public List<CustomerDTO> showCustomer(@RequestBody CustomerDTO customer){
		return icustomerservice.viewAllCustomer();
		
	}
	
	@GetMapping("/{id}")
	public CustomerDTO CustomerById(@PathVariable("id")  Integer customerId) {
		return icustomerservice.viewCustomerById(customerId);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomerById(@PathVariable("id")  Integer customerId) {
		return icustomerservice.deleteCustomerById(customerId);
	}
	
	@PutMapping("/put/{id}")
	public CustomerDTO updateCustomer( @RequestBody CustomerDTO customer, @PathVariable("id") Integer customerId) {
		return icustomerservice.updateCustomer(customer, customerId);
	}
	
	@GetMapping("/number/{num}")
	public CustomerDTO getByPhone(@PathVariable("num") Long num)
	{
		return icustomerservice.viewCustomerByPhone(num);
	}
}
