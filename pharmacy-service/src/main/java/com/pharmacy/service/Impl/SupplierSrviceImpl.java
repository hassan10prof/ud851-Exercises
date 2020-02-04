package com.pharmacy.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.Transformer.ProductsTransformer;
import com.pharmacy.Transformer.SupplierTransformer;
import com.pharmacy.dao.ProductsDAO;
import com.pharmacy.dao.SupplierDAO;
import com.pharmacy.dao.impl.ProductsDAOImpl;
import com.pharmacy.dao.impl.SupplierDAOImpl;
import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.dto.SupplierDTO;
import com.pharmacy.model.Products;
import com.pharmacy.model.Supplier;
import com.pharmacy.service.SupplierService;

@Service
public class SupplierSrviceImpl implements SupplierService {

	@Autowired
	private SupplierDAO supplierDAO=new SupplierDAOImpl();

	private SupplierTransformer transformer = new SupplierTransformer();

	public SupplierSrviceImpl() {
		
	}
	
	public SupplierDTO create(SupplierDTO o) throws Exception {
		Supplier supplierToCreate = transformer.toEntity(o);

		Supplier createdSupplier = supplierDAO.create(supplierToCreate);

		SupplierDTO createdSupplierDTO = transformer.toDTO(createdSupplier);

		return createdSupplierDTO;
	}

	public SupplierDTO update(Long t, SupplierDTO o) {
		Supplier supplierToUpdate = transformer.toEntity(o);

		Supplier updatedsupplier = supplierDAO.udpate(t, supplierToUpdate);

		SupplierDTO updatedSupplierDTO = transformer.toDTO(updatedsupplier);

		return updatedSupplierDTO;
	}

	public void delete(Long v) throws Exception {
		supplierDAO.delete(v);
		
	}

	public Optional<SupplierDTO> getByIdOptional(Long k) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SupplierDTO> getAll() {
		List<Supplier> supplierList = supplierDAO.getAll();

		List<SupplierDTO> supplierDTO = transformer.toDTOList(supplierList);

		return supplierDTO;
	}

	public SupplierDTO getById(Long id) throws Exception {
		Supplier supplier = supplierDAO.getById(id);

		SupplierDTO supplierFound = transformer.toDTO(supplier);

		return supplierFound;
	}

	public List<SupplierDTO> getAllByDate(Date fromdate, Date toDate) {
		List<Supplier> suppliersList = supplierDAO.getAllByDate(fromdate, toDate);

		List<SupplierDTO> listSupplierDTO = transformer.toDTOList(suppliersList);

		return listSupplierDTO;
	}

}
