package com.onlinepizza.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	
	public Customer findByCustomerMobile(Long phoneNo);
	


}


