package com.onlinepizza.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.onlinepizza.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	
	public Optional<Customer> findByCustomerMobile(Long phoneNo);
	


}


