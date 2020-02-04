package com.pharmacy.dto;

public class ProductsDTO {
	private Long id;
	private String nameProduct;
	private String supplier;
	private int quantity;
	private double pricePerchase;

	public ProductsDTO() {

	}

	public ProductsDTO(String nameProduct, String supplier, int quantity, double pricePerchase) {
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
