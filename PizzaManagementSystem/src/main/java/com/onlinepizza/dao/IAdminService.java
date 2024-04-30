package com.onlinepizza.dao;

import java.util.List;

import com.onlinepizza.dto.AdminDTO;
import com.onlinepizza.dto.CustomerDTO;

public interface IAdminService {
	
	AdminDTO registerAdmin(AdminDTO admin);
	AdminDTO updateAdmin(AdminDTO admin);
	AdminDTO viewAdminByPhone(Long Phone);
	List<AdminDTO> viewAllCustomer();
	AdminDTO viewCustomerById(AdminDTO admin);
	
}
