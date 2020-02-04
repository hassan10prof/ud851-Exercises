package com.pharmacy.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.Transformer.CustomersTransformer;
import com.pharmacy.Transformer.ProductsTransformer;
import com.pharmacy.dao.CustomersDAO;
import com.pharmacy.dao.ProductsDAO;
import com.pharmacy.dao.impl.CustomersDAOImpl;
import com.pharmacy.dao.impl.ProductsDAOImpl;
import com.pharmacy.dto.CustomersDTO;
import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.model.Customers;
import com.pharmacy.model.Products;
import com.pharmacy.service.CustomersService;
import com.pharmacy.service.ProductsService;

@Service
public class CustomerServiceImpl implements CustomersService {

	@Autowired
	private CustomersDAO customersDAO=new CustomersDAOImpl();

	private CustomersTransformer transformer = new CustomersTransformer();

	public CustomerServiceImpl() {
		
	}

	public CustomersDTO create(CustomersDTO t) throws Exception {
		Customers customersToCreate = transformer.toEntity(t);

		Customers createdCustomers = customersDAO.create(customersToCreate);

		CustomersDTO createdCustomersDTO = transformer.toDTO(createdCustomers);

		return createdCustomersDTO;
	}

	public CustomersDTO update(Long t, CustomersDTO o) {
		Customers customerToUpdate = transformer.toEntity(o);

		Customers updatedcustomer = customersDAO.udpate(t, customerToUpdate);
		
		CustomersDTO updatedCustomersDTO = transformer.toDTO(updatedcustomer);

		return updatedCustomersDTO;
	}

	public void delete(Long t) throws Exception {
		customersDAO.delete(t);

		
	}



	public List<CustomersDTO> getAll() {
		List<Customers> CustomersList = customersDAO.getAll();

		List<CustomersDTO> customersDTOList = transformer.toDTOList(CustomersList);

		return customersDTOList;
	}

	public Optional<CustomersDTO> getByIdOptional(Long k) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomersDTO getById(Long id) throws Exception {
		
		Customers customers = customersDAO.getById(id);

		CustomersDTO CustomersDTOFound = transformer.toDTO(customers);

		return CustomersDTOFound;
	}

}
