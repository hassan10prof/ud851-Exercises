package com.pharmacy.dao;

import java.util.Date;
import java.util.List;

import com.pharmacy.model.Products;
import com.pharmacy.model.Supplier;

public interface SupplierDAO extends GenericDAO<Long,Supplier>{
	public List<Supplier> getAllByDate(Date fromdate ,Date toDate);

}
