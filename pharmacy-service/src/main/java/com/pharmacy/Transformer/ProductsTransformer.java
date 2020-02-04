package com.pharmacy.Transformer;

import com.pharmacy.model.Products;
import com.pharmacy.dto.ProductsDTO;

public class ProductsTransformer extends AbstractTransformer<ProductsDTO, Products>{

	@Override
	public ProductsDTO toDTO(Products entity) {
		ProductsDTO dto=new ProductsDTO();
		dto.setId(entity.getId());
		dto.setNameProduct(entity.getNameProduct());
		dto.setSupplier(entity.getSupplier());
		dto.setQuantity(entity.getQuantity());
		dto.setPricePerchase(entity.getPricePerchase());
		return dto;
		
	}

	@Override
	public Products toEntity(ProductsDTO dto) {
		Products entity=new Products();
		entity.setId(dto.getId());
		entity.setNameProduct(dto.getNameProduct());
		entity.setSupplier(dto.getSupplier());
		entity.setQuantity(dto.getQuantity());
		entity.setPricePerchase(dto.getPricePerchase());
		return entity;
	}

}
