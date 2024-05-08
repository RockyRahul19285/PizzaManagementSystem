package com.onlinepizza.dao;

import java.util.List;

import com.onlinepizza.dto.AdminDTO;
import com.onlinepizza.dto.LoginDTO;
import com.onlinepizza.exception.ResourceNotFound;


public interface IAdminService{
	
	
	AdminDTO registerAdmin(AdminDTO admin);
	
	String loginAdmin(LoginDTO admin);

	AdminDTO updateAdmin(AdminDTO admin,Integer adminId)throws ResourceNotFound;

	List<AdminDTO> viewAllAdmin()throws ResourceNotFound;
	
	AdminDTO viewAdminById(Integer AdminId)throws ResourceNotFound;
	
	String deleteAdminById(Integer AdminId)throws ResourceNotFound;

}
