package com.onlinepizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.onlinepizza.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

	Admin findByEmail(String email);
	
	
//	public Admin findByAdminMobile(Long phoneNum);
	


}
