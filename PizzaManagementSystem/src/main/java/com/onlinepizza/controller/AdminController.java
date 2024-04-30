//package com.onlinepizza.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.onlinepizza.dto.CustomerDTO;
//
//public class AdminController {
//	
//	
//	@PostMapping("/add")
//	public CustomerDTO addCustomer(@RequestBody CustomerDTO customer) {
//		CustomerDTO cusDTO = icustomerservice.registerCustomer(customer);
//		return customer;
//	}
//	
//	
//	@GetMapping("/get")
//	public List<CustomerDTO> showCustomer(@RequestBody CustomerDTO customer){
//		return icustomerservice.viewAllCustomer();
//		
//	}
//	
//	@GetMapping("/get/{id}")
//	public CustomerDTO CustomerById(@PathVariable("id")  Integer customerId) {
//		return icustomerservice.viewCustomerById(customerId);
//		
//	}
//
//}
