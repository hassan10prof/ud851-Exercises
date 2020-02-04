package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.model.User;

public interface UserDAO {

	public List<User> login(String myusername, String mypassword);
	

}
