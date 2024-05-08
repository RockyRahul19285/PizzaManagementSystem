package com.onlinepizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.onlinepizza.exception.ResourceNotFound;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService icustomerservice;

	// http://localhost:8000/customer
	@PostMapping
	public ResponseEntity<CustomerDTO> registerCustomer(@Valid @RequestBody CustomerDTO customer) {
		CustomerDTO cusDTO = icustomerservice.registerCustomer(customer);
		return new ResponseEntity<>(cusDTO, HttpStatus.CREATED);
	}

	// http://localhost:8000/customer/{id}
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> customerById(@PathVariable("id") Integer customerId) throws ResourceNotFound {
		return new ResponseEntity<>(icustomerservice.viewCustomerById(customerId), HttpStatus.OK);
	}

	// http://localhost:8000/customer/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") Integer customerId) throws ResourceNotFound {
		return new ResponseEntity<>(icustomerservice.deleteCustomerById(customerId), HttpStatus.OK);

	}

	// http://localhost:8000/customer/{id}
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@Valid @RequestBody CustomerDTO customer,
			@PathVariable("id") Integer customerId) throws ResourceNotFound {
		return new ResponseEntity<>(icustomerservice.updateCustomer(customer, customerId), HttpStatus.OK);

	}
}
