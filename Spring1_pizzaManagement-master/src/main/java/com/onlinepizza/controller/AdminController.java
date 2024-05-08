package com.onlinepizza.controller;

import java.util.List;

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

import com.onlinepizza.dao.IAdminService;
import com.onlinepizza.dao.ICustomerService;
import com.onlinepizza.dto.AdminDTO;
import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.dto.LoginDTO;
import com.onlinepizza.exception.ResourceNotFound;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService iAdminservice;

	@Autowired
	ICustomerService iCustomerService;

	// http://localhost:8000/admin/register
	@PostMapping("/register")
	public ResponseEntity<AdminDTO> registerAdmin(@Valid @RequestBody AdminDTO admin) {
		AdminDTO adminDTO = iAdminservice.registerAdmin(admin);
		return new ResponseEntity<>(adminDTO, HttpStatus.CREATED);
	}

	// http://localhost:8000/admin/login
	@PostMapping("/login")
	public ResponseEntity<String> signIn(@Valid @RequestBody LoginDTO admin) {
		String login = iAdminservice.loginAdmin(admin);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}

	// http://localhost:8000/admin
	@GetMapping
	public ResponseEntity<List<AdminDTO>> showAdmin(@RequestBody AdminDTO admin) throws ResourceNotFound {
		List<AdminDTO> adminList = iAdminservice.viewAllAdmin();
		return new ResponseEntity<>(adminList, HttpStatus.OK);
	}

	// http://localhost:8000/admin/{id}
	@GetMapping("/{id}")
	public ResponseEntity<AdminDTO> adminById(@PathVariable("id") Integer adminId) throws ResourceNotFound {
		AdminDTO adminDTO = iAdminservice.viewAdminById(adminId);
		return new ResponseEntity<>(adminDTO, HttpStatus.OK);
	}

	// http://localhost:8000/admin/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAdminById(@PathVariable("id") Integer adminId) throws ResourceNotFound {
		String response = iAdminservice.deleteAdminById(adminId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// http://localhost:8000/admin/{id}
	@PutMapping("/{id}")
	public ResponseEntity<AdminDTO> updateAdmin(@Valid @RequestBody AdminDTO admin, @PathVariable("id") Integer adminId)
			throws ResourceNotFound {
		AdminDTO updatedAdmin = iAdminservice.updateAdmin(admin, adminId);
		return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
	}

	// http://localhost:8000/admin/allcustomers
	@GetMapping("/allcustomers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() throws ResourceNotFound {
		List<CustomerDTO> customerList = iCustomerService.viewAllCustomer();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	// http://localhost:8000/admin/customernum/{num}
	@GetMapping("/customernum/{num}")
	public ResponseEntity<CustomerDTO> getByCustomerPhone(@PathVariable("num") Long num) throws ResourceNotFound {
		CustomerDTO customerDTO = iCustomerService.viewCustomerByPhone(num);
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}

	// http://localhost:8000/admin/customer/{id}
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") Integer customerId) throws ResourceNotFound {
		String response = iCustomerService.deleteCustomerById(customerId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
