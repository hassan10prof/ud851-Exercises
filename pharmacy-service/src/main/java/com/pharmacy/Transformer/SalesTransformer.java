package com.pharmacy.Transformer;

import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.dto.SalesDTO;
import com.pharmacy.model.Products;
import com.pharmacy.model.Sales;

public class SalesTransformer extends AbstractTransformer<SalesDTO, Sales>{

	@Override
	public SalesDTO toDTO(Sales entity) {
		SalesDTO dto=new SalesDTO();
		dto.setIdSale(entity.getIdSale());
		dto.setNameProduct(entity.getNameProduct());
		dto.setQuantity(entity.getQuantity());
		dto.setPricePerchase(entity.getPricePerchase());
	
		return dto;
	}

	@Override
	public Sales toEntity(SalesDTO dto) {
		Sales entity=new Sales();
		entity.setIdSale(dto.getIdSale());
		entity.setNameProduct(dto.getNameProduct());
		entity.setQuantity(dto.getQuantity());
		entity.setPricePerchase(dto.getPricePerchase());
	
		return entity;
	}

}
