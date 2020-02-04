package com.pharmacy.Transformer;

import java.text.SimpleDateFormat;

import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.dto.SupplierDTO;
import com.pharmacy.model.Products;
import com.pharmacy.model.Supplier;

public class SupplierTransformer extends AbstractTransformer<SupplierDTO, Supplier> {

	@Override
	public SupplierDTO toDTO(Supplier entity) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		SupplierDTO dto=new SupplierDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setAdresse(entity.getAdresse());
		dto.setDetails(entity.getDetails());
		dto.setDateRegestration(entity.getDateRegestration());

		return dto;
	}

	@Override
	public Supplier toEntity(SupplierDTO dto) {
		Supplier entity=new Supplier();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setAdresse(dto.getAdresse());
		entity.setDetails(dto.getDetails());
		entity.setDateRegestration(dto.getDateRegestration());

		return entity;
	}


	/*
	 * @Override public SupplierDTO toDTO(Supplier entity) throws ParseException {
	 * SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	 * 
	 * SupplierDTO dto=new SupplierDTO(); dto.setId(entity.getId());
	 * dto.setName(entity.getName()); dto.setPhoneNumber(entity.getPhoneNumber());
	 * dto.setAdresse(entity.getAdresse()); dto.setDetails(entity.getDetails());
	 * dto.setDateRegestration(format.parse(entity.getDateRegestration().toString())
	 * );
	 * 
	 * return dto; }
	 */
}
