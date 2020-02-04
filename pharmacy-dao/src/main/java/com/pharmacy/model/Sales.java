package com.pharmacy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "Sales")
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSale;

	@Column(name = "nameProduct")
	private String nameProduct;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "pricePerchase")
	private double pricePerchase;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "Customers")
//	private List<Customers> customersList;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "products")
//	private List<Products> productsList;

	public Sales() {
		super();
	}

	public Sales(String nameProduct, int quantity, double pricePerchase) {
		super();
		this.nameProduct = nameProduct;
		this.quantity = quantity;
		this.pricePerchase = pricePerchase;
	}

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerchase() {
		return pricePerchase;
	}

	public void setPricePerchase(double pricePerchase) {
		this.pricePerchase = pricePerchase;
	}

//	public List<Customers> getCustomersList() {
//		return customersList;
//	}
//
//	public void setCustomersList(List<Customers> customersList) {
//		this.customersList = customersList;
//	}

//	public List<Products> getProductsList() {
//		return productsList;
//	}
//
//	public void setProductsList(List<Products> productsList) {
//		this.productsList = productsList;
//	}

}
