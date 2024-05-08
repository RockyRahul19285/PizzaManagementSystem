package com.onlinepizza.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	private Integer userId;
	@NotBlank(message="Username should not be empty")
	@Size(max = 15, message = "Username should not exceed 15 characters")
	private String userName;
	@Size(min = 8, message = "Password should be at least 8 characters long")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
        message = "Password must contain at minimum 8 character and atleast one uppercase letter, one lowercase letter, one digit, and one special character"
    )
	private String password;
	private String userRole;
	@NotBlank(message="Email should not be empty")
	@Email(message = "Enter the Proper Email")
	private String email;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userIdDTO) {
		this.userId = userIdDTO;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userNameDTO) {
		this.userName = userNameDTO;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwordDTO) {
		this.password = passwordDTO;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRoleDTO) {
		this.userRole = userRoleDTO;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String emailDTO) {
		this.email = emailDTO;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userRole="
				+ userRole + ", email=" + email + "]";
	}
	
	
	
	

}
