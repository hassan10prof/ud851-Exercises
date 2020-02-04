package com.pharmacy.Transformer;

import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.dto.UserDTO;
import com.pharmacy.model.Products;
import com.pharmacy.model.User;

public class UserTransformer extends AbstractTransformer<UserDTO, User> {

	@Override
	public UserDTO toDTO(User e) {
		UserDTO dto=new UserDTO();
		dto.setId(e.getId());
		dto.setUserName(e.getUserName());
		dto.setPassword(e.getPassword());
		return dto;
	}

	@Override
	public User toEntity(UserDTO d) {
		User entity=new User();
		
		entity.setId(d.getId());
		entity.setUserName(d.getUserName());
		entity.setPassword(d.getPassword());
	
		return entity;
	}

}
