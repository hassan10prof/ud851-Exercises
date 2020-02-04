package com.pharmacy.dto;

public class SalesDTO {

	private int idSale;
	private String nameProduct;
	private int quantity;
	private double pricePerchase;

	public SalesDTO() {
		super();
	}

	public SalesDTO(String nameProduct, int quantity, double pricePerchase) {
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



}
