package com.pharmacy.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.Transformer.ProductsTransformer;
import com.pharmacy.Transformer.UserTransformer;
import com.pharmacy.dao.ProductsDAO;
import com.pharmacy.dao.UserDAO;
import com.pharmacy.dao.impl.ProductsDAOImpl;
import com.pharmacy.dao.impl.UserDAOImpl;
import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.dto.UserDTO;
import com.pharmacy.model.Products;
import com.pharmacy.model.User;
import com.pharmacy.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO=new UserDAOImpl();

	private UserTransformer transformer = new UserTransformer();

	public UserServiceImpl() {
		
	}

	public List<User> login(String username, String password) {
		List<User> userssList = userDAO.login(username, password);

		//List<User> usersDTO = transformer.toDTOList(userssList);

		return userssList;
	}


}
