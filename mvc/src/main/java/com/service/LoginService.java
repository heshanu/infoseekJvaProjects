package com.service;

import java.util.HashMap;

import com.dto.UserDTO;

public class LoginService {
//login method username and password
	HashMap<String, String> usertable = new HashMap<>();

	public LoginService() {
		usertable.put("heshan", "HeshanUmaa");
		usertable.put("nimal", "Umayanmial");
		usertable.put("vimla", "hheehhe");
	}

	public boolean authenticateUserLogin(String username, String password) {
		if (username.equals("heshan") && password.equals("12345")) {
			return true;
		}
		return false;

	}

	// model String
	public String getFullNameByUserName(String username) {
		return usertable.get(username);
	}

	public UserDTO getFullDetailsOfUser(String userName) {
		UserDTO user = new UserDTO();
		user.setUserId(1L);
		user.setName(usertable.get(userName));
		user.setContactNo("0123456789");
		user.setAddress("hikkaduwa");

		return user;

	}
}
