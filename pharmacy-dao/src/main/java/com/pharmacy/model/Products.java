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
import javax.persistence.Table;

@Entity(name = "Products")
@Table(name = "Products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nameProduct")
	private String nameProduct;
	
	@Column(name = "supplier")
	private String supplier;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "pricePerchase")
	private double pricePerchase;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "Suppliers")
//	private List<Supplier> supplierList;
//	
//	

	public Products() {

	}

	public Products(String nameProduct, String supplier, int quantity, double pricePerchase) {
		super();
		this.nameProduct = nameProduct;
		this.supplier = supplier;
		this.quantity = quantity;
		this.pricePerchase = pricePerchase;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

	@Override
	public String toString() {
		return "Products [id=" + id + ", nameProduct=" + nameProduct + ", supplier=" + supplier + ", quantity="
				+ quantity + ", pricePerchase=" + pricePerchase + "]";
	}

}
