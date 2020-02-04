package com.pharmacy.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.Transformer.ProductsTransformer;
import com.pharmacy.dao.ProductsDAO;
import com.pharmacy.dao.impl.ProductsDAOImpl;
import com.pharmacy.model.Products;
import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.service.ProductsService;
@Service
public class PorductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsDAO productsDAO=new ProductsDAOImpl();

	private ProductsTransformer transformer = new ProductsTransformer();

	public PorductsServiceImpl() {
		
	}

//	
//	public PorductsServiceImpl(ProductsDAO productsDAO) {
//		this.productsDAO = productsDAO;
//	}

	public ProductsDTO create(ProductsDTO o) throws Exception {
		Products productsToCreate = transformer.toEntity(o);

		Products createdProducts = productsDAO.create(productsToCreate);

		ProductsDTO createdProductsDTO = transformer.toDTO(createdProducts);

		return createdProductsDTO;
	}

	public ProductsDTO update(Long t, ProductsDTO o) {
		Products productToUpdate = transformer.toEntity(o);

		Products updatedProducts = productsDAO.udpate(t, productToUpdate);

		ProductsDTO updatedProductsDTO = transformer.toDTO(updatedProducts);

		return updatedProductsDTO;
	}

	public void delete(Long t) throws Exception {
		productsDAO.delete(t);

	}

	


	
	public List<ProductsDTO> getAll() {
		List<Products> productsList = productsDAO.getAll();

		List<ProductsDTO> productsDTO = transformer.toDTOList(productsList);

		return productsDTO;
	}

	public Optional<ProductsDTO> getByIdOptional(Long k) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductsDTO getById(Long id) throws Exception {
		
		Products products = productsDAO.getById(id);

		ProductsDTO productsFound = transformer.toDTO(products);

		return productsFound;
	}

	public List<ProductsDTO> getAllByQantity(int v1,int v2) {
		List<Products> productsList = productsDAO.getAllByQantity(v1,v2);

		List<ProductsDTO> productsDTO = transformer.toDTOList(productsList);

		return productsDTO;
	}


}
