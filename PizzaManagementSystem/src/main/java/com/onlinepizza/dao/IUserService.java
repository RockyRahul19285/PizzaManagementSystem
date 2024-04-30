package com.onlinepizza.dao;

import com.onlinepizza.dto.UserDTO;

public interface IUserService {
	
	
	UserDTO registerUser(UserDTO user);

	UserDTO signIn(String userName, String password);

	// use session management accordingly
	public String signOut();

}
