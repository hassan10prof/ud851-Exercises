package com.pharmacy.Transformer;

import com.pharmacy.dto.CustomersDTO;
import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.model.Customers;
import com.pharmacy.model.Products;

public class CustomersTransformer extends AbstractTransformer<CustomersDTO, Customers>{

	@Override
	public CustomersDTO toDTO(Customers entity) {
		CustomersDTO dto=new CustomersDTO();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setEmail(entity.getEmail());

		return dto;
	}

	@Override
	public Customers toEntity(CustomersDTO dto) {
		Customers entity=new Customers();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setEmail(dto.getEmail());
		
		return entity;
	}



}