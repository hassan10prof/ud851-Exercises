package com.pharmacy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "Supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "details")
	private String details;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dateRegestration;
	
	public Supplier() {
		super();
	}


	public Supplier(String name, String phoneNumber, String adresse, String details, Date dateRegestration) {
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
		return "Supplier [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", adresse=" + adresse
				+ ", details=" + details + ", dateRegestration=" + dateRegestration + "]";
	}


}
