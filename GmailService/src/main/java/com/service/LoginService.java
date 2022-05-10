package com.service;

import java.util.HashMap;

import com.dto.UserDTO;

public class LoginService {
	
	//username, Full Name
	HashMap<String, String> usersTable = new HashMap<>();
	
	public LoginService() {
		usersTable.put("sithumi", "Sithumi Sulakshana");
		usersTable.put("nimal", "Nimal Perera");
		usersTable.put("Kasuni", "Kasuni Mendis");
	}
	
	//Login authentication method - username and password
	//Model - Boolean
	public boolean authenticateUserLogin(String username, String password) {
		//Implement JDBC Connection with Util and Test with Database
		
		if(username.equals("nimal") && password.equals("12345")) {
			return true;
		}else {
			return false;
		}
	}
	
	//Model - String
	public String getFullNameByUserName(String username) {
		return usersTable.get(username);
	}
	
	//Model - DTO/Object
	public UserDTO getFullDetailsOfUser(String userName) {
		UserDTO user = new UserDTO();
		user.setUserId(1);
		user.setName(usersTable.get(userName));
		user.setContactNo("0112515050");
		user.setAddress("120 HL Road Kirulapone");
		
		return user;
	}
}
