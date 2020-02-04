package com.pharmacy.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.managedbean.model.Products;
import com.pharmacy.service.ProductsService;

@Component
@ManagedBean(name = "productManagedBean")
@SessionScoped
public class ProductManagedBean {

	@Autowired
	public ProductsService productsService;
	
	
	private Products products;
	private List<ProductsDTO> listProducts;
	
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public List<ProductsDTO> getListProducts() {
		return listProducts;
	}
	public void setListProducts(List<ProductsDTO> listProducts) {
		this.listProducts = listProducts;
	}
	
	public void onload() {
		this.listProducts=this.productsService.getAll();
	}
}
