package com.onlinepizza.dto;

import com.onlinepizza.entity.User;

import jakarta.persistence.Entity;


public class AdminDTO extends UserDTO{
	private String AdminName;
	private Long AdminMobile;
	private String AdminEmail;
	private String AdminAddress;
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public Long getAdminMobile() {
		return AdminMobile;
	}
	public void setAdminMobile(Long adminMobile) {
		AdminMobile = adminMobile;
	}
	public String getAdminEmail() {
		return AdminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		AdminEmail = adminEmail;
	}
	public String getAdminAddress() {
		return AdminAddress;
	}
	public void setAdminAddress(String adminAddress) {
		AdminAddress = adminAddress;
	}
		
}

