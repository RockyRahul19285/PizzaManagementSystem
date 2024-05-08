package com.onlinepizza.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AdminDTO extends UserDTO{
	
	@NotBlank(message="Admin first name should not be empty")
	@Size(max = 10, message = "Admin first name should not exceed 10 characters")
	private String adminFirstName;
	
	@NotBlank(message="Admin Last name should not be empty")
	@Size(max = 10, message = "Admin last name should not exceed 10 characters")
	private String adminLastName;
	private Long adminMobile;
	@NotBlank(message="Address should not be empty")
	private String adminAddress;
	@NotBlank(message="Qualification should not be empty")
	private String qualification;
	@NotBlank(message="Experience should not be empty")
	private String experience;
	@NotBlank(message="Skills should not be empty")
	private String skills;
	
	
	public AdminDTO(String adminFirstName, String adminLastName, Long adminMobile, String adminAddress,
			String qualification, String experience, String skills) {
		super();
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminMobile = adminMobile;
		this.adminAddress = adminAddress;
		this.qualification = qualification;
		this.experience = experience;
		this.skills = skills;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public Long getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(Long adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public AdminDTO() {}
}

