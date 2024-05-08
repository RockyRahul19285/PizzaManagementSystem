package com.onlinepizza.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

// @MappedSuperclass is used to define common properties for other entities
@MappedSuperclass
public class User {
	
    // @Id denotes the primary key of the entity
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	
	private String userName;

	
	private String password;

	
	private String email;

	// Role of the user (e.g., Admin, Customer)
	private String userRole;

	// Getter and Setter methods for each property

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	// toString method for debugging and logging

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", userRole=" + userRole + "]";
	}
}
