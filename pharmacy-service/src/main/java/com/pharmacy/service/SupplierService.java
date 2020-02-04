package com.pharmacy.service;

import java.util.Date;
import java.util.List;

import com.pharmacy.dto.SupplierDTO;
import com.pharmacy.model.Supplier;

public interface SupplierService extends GenericService<Long, SupplierDTO>{

	public List<SupplierDTO> getAllByDate(Date fromdate ,Date toDate);

}
