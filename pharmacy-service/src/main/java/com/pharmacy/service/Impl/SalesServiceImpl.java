package com.pharmacy.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.Transformer.ProductsTransformer;
import com.pharmacy.Transformer.SalesTransformer;
import com.pharmacy.dao.ProductsDAO;
import com.pharmacy.dao.SalesDAO;
import com.pharmacy.dao.impl.ProductsDAOImpl;
import com.pharmacy.dao.impl.SalesDAOImpl;
import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.dto.SalesDTO;
import com.pharmacy.model.Products;
import com.pharmacy.model.Sales;
import com.pharmacy.service.SalesService;
@Service
public class SalesServiceImpl implements SalesService {


	@Autowired
	private SalesDAO salesDAO=new SalesDAOImpl();

	private SalesTransformer transformer = new SalesTransformer();

	public SalesServiceImpl() {
		
	}

	
	public SalesDTO create(SalesDTO o) throws Exception {
		Sales salesToCreate = transformer.toEntity(o);

		Sales createdSales = salesDAO.create(salesToCreate);

		SalesDTO createdSalesDTO = transformer.toDTO(createdSales);

		return createdSalesDTO;
	}

	public SalesDTO update(Long k, SalesDTO o) {
		Sales salesToUpdate = transformer.toEntity(o);

		Sales updatedSales = salesDAO.udpate(k, salesToUpdate);

		SalesDTO updatedSalesdto = transformer.toDTO(updatedSales);

		return updatedSalesdto;
	}

	public void delete(Long v) throws Exception {
		salesDAO.delete(v);
		
	}

	public Optional<SalesDTO> getByIdOptional(Long k) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SalesDTO> getAll() {
		List<Sales> salessList = salesDAO.getAll();

		List<SalesDTO> salesDTO = transformer.toDTOList(salessList);

		return salesDTO;
	}

	public SalesDTO getById(Long id) throws Exception {
		Sales sales = salesDAO.getById(id);

		SalesDTO salesFound = transformer.toDTO(sales);

		return salesFound;
	}

}
