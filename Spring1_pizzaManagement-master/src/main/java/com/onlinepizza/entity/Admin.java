package com.onlinepizza.entity;



import jakarta.persistence.Entity;

@Entity
public class Admin extends User{
	private String adminFirstName;
	private String adminLastName;
	private Long adminMobile;
	private String adminAddress;
	private String qualification;
	private String experience;
	private String skills;
	
	public Admin(String adminFirstName, String adminLastName, Long adminMobile, String adminAddress,
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
	
	
	public Admin() {
		
	}
	
	
	
		
}
