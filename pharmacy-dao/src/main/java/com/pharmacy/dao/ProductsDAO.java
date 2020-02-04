package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.model.Products;

public interface ProductsDAO extends GenericDAO<Long,Products>{

	public List<Products> getAllByQantity(int v1,int v2);
}
