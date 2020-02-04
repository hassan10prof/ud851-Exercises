package com.pharmacy.dto;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SupplierDTO {
	private Long id;
	private String name;
	private String phoneNumber;
	private String adresse;
	private String details;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dateRegestration;

	public SupplierDTO() {
		super();
	}







	public SupplierDTO(String name, String phoneNumber, String adresse, String details, Date dateRegestration) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.adresse = adresse;
		this.details = details;
		this.dateRegestration = dateRegestration;
	}







	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}








	public Date getDateRegestration() {
		return dateRegestration;
	}







	public void setDateRegestration(Date dateRegestration) {
		this.dateRegestration = dateRegestration;
	}







	@Override
	public String toString() {
		return "SupplierDTO [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", adresse=" + adresse
				+ ", details=" + details + ", dateRegestration=" + dateRegestration + "]";
	}



	
}
