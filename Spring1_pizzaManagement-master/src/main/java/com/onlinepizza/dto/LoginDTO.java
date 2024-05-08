package com.onlinepizza.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginDTO {
@NotBlank(message="Email should not be empty")
@Email(message = "Enter the Proper Email")
private String email;
@Size(min = 8, message = "Password should be at least 8 characters long")
@Pattern(
    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
    message = "Password must contain at minimum 8 character and atleast one uppercase letter, one lowercase letter, one digit, and one special character"
)
private String password;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
