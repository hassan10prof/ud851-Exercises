package com.pharmacy.dto;

import java.util.List;

public class CustomersDTO {
	private Long id;
	private String name;
	private String phoneNumber;
	private String email;
	private List<CustomersDTO> CustomersDTOList;


	public CustomersDTO() {
		super();
	}

	public CustomersDTO(String name, String phoneNumber, String email) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CustomersDTO> getCustomersDTOList() {
		return CustomersDTOList;
	}

	public void setCustomersDTOList(List<CustomersDTO> customersDTOList) {
		CustomersDTOList = customersDTOList;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

}
