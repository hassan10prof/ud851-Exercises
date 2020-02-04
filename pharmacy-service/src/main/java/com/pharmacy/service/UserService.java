package com.pharmacy.service;

import java.util.List;

import com.pharmacy.dto.UserDTO;
import com.pharmacy.model.User;

public interface UserService {
	public List<User> login(String myusername, String mypassword);

}
