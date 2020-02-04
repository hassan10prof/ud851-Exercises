package com.pharmacy.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.pharmacy.dto.CustomersDTO;
import com.pharmacy.service.CustomersService;
import com.pharmacy.service.Impl.CustomerServiceImpl;
import com.pharmacy.service.Impl.PorductsServiceImpl;

@Configuration
@ManagedBean(name = "customersBean")
@SessionScoped
public class CustomersBean {

	private static CustomersService customersService;
	private CustomersDTO customersDTO = new CustomersDTO();;
	private List<CustomersDTO> listCustomers = new ArrayList<CustomersDTO>();

	public static void main(String[] args) {
		// Annotation Configuration
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		customersService = context.getBean(CustomersService.class);
		((AnnotationConfigApplicationContext) context).close();
	}

	public CustomersBean() {

	}

	public CustomersBean(CustomersDTO customersDTO) {
		super();
		this.customersDTO = customersDTO;
	}

	public CustomersDTO getCustomersDTO() {
		return customersDTO;
	}

	public void setCustomersDTO(CustomersDTO customersDTO) {
		this.customersDTO = customersDTO;
	}

	public List<CustomersDTO> getListCustomers() {
		try {

			listCustomers = this.getAll();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("out from list");
		}

		return listCustomers;
	}

	public void setListCustomers(List<CustomersDTO> listCustomers) {
		this.listCustomers = listCustomers;
	}

	public List<CustomersDTO> getAll() {
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		listCustomers = customerServiceImpl.getAll();

		return listCustomers;
	}

	public String SaveCustomer() throws Exception {
		CustomerServiceImpl customerServiceImpl=new CustomerServiceImpl();
		customerServiceImpl.create(customersDTO);
		return redirectToAllCustomers();
	}
	
	public String RemoveCustomer(Long id) {

		try {
			CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
			customerServiceImpl.delete(id);

		} catch (Exception e) {
			System.out.println("************delete not succes*********");
		}
		return redirectToAllCustomers();

	}

	public String SetValues(int id) {
		Long i = (long) id;

		try {
	
			
			CustomerServiceImpl customerServiceImpl =new CustomerServiceImpl();
			CustomersDTO dto=customerServiceImpl.getById(i);
			
			customersDTO.setId(dto.getId());
			customersDTO.setName(dto.getName());
			customersDTO.setPhoneNumber(dto.getPhoneNumber());
			customersDTO.setEmail(dto.getEmail());

		} catch (Exception e) {
			System.out.println("not updated succes");
		}
		return redirectToEdit();

	}
	
	public String UpdateProduct(Long id) {

		try {
			CustomerServiceImpl customerServiceImpl =new CustomerServiceImpl();

			customerServiceImpl.update(id, customersDTO);
			customersDTO.setId(null);
			customersDTO.setName("");
			customersDTO.setPhoneNumber("");
			customersDTO.setEmail("");
		} catch (Exception e) {
			System.out.println("not updated succes");
		}
		return redirectToAllCustomers();
		

	}
	public String redirectToEdit() {

		return "EditCustomer.xhtml?faces-redirect=true";

	}

	public String redirectToAllCustomers() {

		return "AllCustomers.xhtml?faces-redirect=true";

	}

	public int TotalCustomers() {
		int size = 0;
		try {
			 size =getAll().size();
			 System.out.println("list done" +size);

		} catch (Exception e) {
			 System.out.println("list not done");

		}
		return size;
	}
}
