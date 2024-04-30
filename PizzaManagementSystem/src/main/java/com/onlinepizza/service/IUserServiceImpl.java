package com.onlinepizza.service;

import org.springframework.stereotype.Service;

import com.onlinepizza.dao.IUserService;
import com.onlinepizza.dto.UserDTO;

@Service
public class IUserServiceImpl implements IUserService {

	@Override
	public UserDTO registerUser(UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO signIn(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signOut() {
		// TODO Auto-generated method stub
		return null;
	}

}
