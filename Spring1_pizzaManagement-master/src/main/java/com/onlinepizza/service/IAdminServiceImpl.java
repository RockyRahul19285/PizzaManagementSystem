package com.onlinepizza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dao.IAdminService;
import com.onlinepizza.dto.AdminDTO;
import com.onlinepizza.dto.LoginDTO;
import com.onlinepizza.entity.Admin;
import com.onlinepizza.exception.ResourceNotFound;
import com.onlinepizza.repository.AdminRepository;

@Service
public class IAdminServiceImpl implements IAdminService {
	@Autowired
	AdminRepository adminrepository;

	public AdminDTO mapToDto(Admin admin) {
		AdminDTO adminDTO = new AdminDTO();

		adminDTO.setUserId(admin.getUserId());
		adminDTO.setAdminFirstName(admin.getAdminFirstName());
		adminDTO.setAdminLastName(admin.getAdminLastName());
		adminDTO.setAdminMobile(admin.getAdminMobile());
		adminDTO.setAdminAddress(admin.getAdminAddress());
		adminDTO.setQualification(admin.getQualification());
		adminDTO.setExperience(admin.getExperience());
		adminDTO.setSkills(admin.getSkills());
		adminDTO.setUserName(admin.getUserName());
		adminDTO.setPassword(admin.getPassword());
		adminDTO.setEmail(admin.getEmail());
		adminDTO.setUserRole("Admin");
		return adminDTO;
	}

	@Override
	public AdminDTO registerAdmin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setAdminFirstName(adminDTO.getAdminFirstName());
		admin.setAdminLastName(adminDTO.getAdminLastName());
		admin.setAdminMobile(adminDTO.getAdminMobile());
		admin.setAdminAddress(adminDTO.getAdminAddress());
		admin.setQualification(adminDTO.getQualification());
		admin.setExperience(adminDTO.getExperience());
		admin.setSkills(adminDTO.getSkills());
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(adminDTO.getPassword());
		admin.setEmail(adminDTO.getEmail());
		admin.setUserRole("Admin");

		return mapToDto(adminrepository.save(admin));
	}
	@Override
	public String loginAdmin(LoginDTO admin) {
		Admin user = adminrepository.findByEmail(admin.getEmail());
		if (user != null) {
			String passwrd = admin.getPassword();
			String userPasswrd = user.getPassword();
			boolean flag = passwrd.matches(userPasswrd);
			if (flag) {
				return "Admin Logged In Successfully";
			} else {
				return "Password Incorrect";
			}
		} else {
			return "No user found";
		}
	}
	

	@Override
	public AdminDTO updateAdmin(AdminDTO adminDTO, Integer adminId) throws ResourceNotFound {
		Optional<Admin> adminResponse = adminrepository.findById(adminId);
		AdminDTO updatedAdmin = new AdminDTO();
		if (adminResponse.isPresent()) {
			Admin adminRes = adminResponse.get();
			adminRes.setAdminFirstName(adminDTO.getAdminFirstName());
			adminRes.setAdminLastName(adminDTO.getAdminLastName());
			adminRes.setAdminMobile(adminDTO.getAdminMobile());
			adminRes.setAdminAddress(adminDTO.getAdminAddress());
			adminRes.setQualification(adminDTO.getQualification());
			adminRes.setExperience(adminDTO.getExperience());
			adminRes.setSkills(adminDTO.getSkills());
			adminRes.setUserName(adminDTO.getUserName());
			adminRes.setPassword(adminDTO.getPassword());
			adminRes.setEmail(adminDTO.getEmail());
			adminRes.setUserRole("Admin");
			updatedAdmin = mapToDto(adminrepository.save(adminRes));
		} else {
			throw new ResourceNotFound("Admin with id " + adminId + " not found");
		}
		return updatedAdmin;
	}

	@Override
	public List<AdminDTO> viewAllAdmin() throws ResourceNotFound {
		List<AdminDTO> list = new ArrayList<>();
		List<Admin> admin = adminrepository.findAll();
		for (Admin admn : admin) {
			list.add(mapToDto(admn));
		}
		if (list.isEmpty()) {
			throw new ResourceNotFound("Admin Data Is Empty");
		}
		return list;
	}

	@Override
	public AdminDTO viewAdminById(Integer adminId) throws ResourceNotFound {
		Optional<Admin> adminById = adminrepository.findById(adminId);
		if (adminById.isEmpty()) {
			throw new ResourceNotFound("Admin Details With Id: " + adminId + " Not Found");
		}
		return mapToDto(adminById.get());
	}

	@Override
	public String deleteAdminById(Integer adminId) throws ResourceNotFound {
		Optional<Admin> adminById = adminrepository.findById(adminId);
		if (adminById.isPresent()) {
			adminrepository.deleteById(adminId);
		} else {
			throw new ResourceNotFound("Admin Details With Id: " + adminId + " Not Found");
		}
		return "Deleted Successfully";
	}


}
