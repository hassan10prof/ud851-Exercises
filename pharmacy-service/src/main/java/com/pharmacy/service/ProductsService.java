package com.pharmacy.service;

import java.util.List;

import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.model.Products;

public interface ProductsService extends GenericService<Long,ProductsDTO>{

	public List<ProductsDTO> getAllByQantity(int v1,int v2);

}
