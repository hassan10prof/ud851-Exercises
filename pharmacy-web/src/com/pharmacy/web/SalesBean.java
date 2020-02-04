package com.pharmacy.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.dto.SalesDTO;
import com.pharmacy.service.ProductsService;
import com.pharmacy.service.SalesService;
import com.pharmacy.service.Impl.PorductsServiceImpl;
import com.pharmacy.service.Impl.SalesServiceImpl;

@Configuration
@ManagedBean(name = "salesBean")
@SessionScoped
public class SalesBean {

	private static SalesService salesService;

	public static void main(String[] args) {
		// Annotation Configuration
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		salesService = context.getBean(SalesService.class);
		((AnnotationConfigApplicationContext) context).close();
	}

	private SalesDTO salesDTO = new SalesDTO();;
	private List<SalesDTO> listsales = new ArrayList<SalesDTO>();

	public SalesBean() {

	}

	public SalesBean(SalesDTO salesDTO) {
		super();
		this.salesDTO = salesDTO;
	}

	public SalesDTO getSalesDTO() {
		return salesDTO;
	}

	public void setSalesDTO(SalesDTO salesDTO) {
		this.salesDTO = salesDTO;
	}

	public List<SalesDTO> getListsales() {
		
		try {
			
				listsales = this.getAll();

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("out from list");
		}
		return listsales;
	}

	public void setListsales(List<SalesDTO> listsales) {
		this.listsales = listsales;
	}

	public List<SalesDTO> getAll() {
		SalesServiceImpl salesServiceImpl = new SalesServiceImpl();

		listsales = salesServiceImpl.getAll();

		return listsales;
	}

	
	public String SaveSales() throws Exception {

		SalesServiceImpl salesServiceImpl = new SalesServiceImpl();
		salesServiceImpl.create(salesDTO);
		return redirectToAllSales();
	}
	
	public String RemoveSales(Long id) {

		try {
			SalesServiceImpl salesServiceImpl = new SalesServiceImpl();
			salesServiceImpl.delete(id);

		} catch (Exception e) {
			System.out.println("************delete not succes*********");
		}
		return redirectToAllSales();

	}

	public String UpdateSales(Long id) {

		try {

			SalesServiceImpl salesServiceImpl = new SalesServiceImpl();
			salesServiceImpl.update(id, salesDTO);
			
		} catch (Exception e) {
			System.out.println("not updated succes");
		}
		return redirectToAllSales();

	}

	public String SetmyValues(int id) {
		Long i = (long) id;

		try {
			SalesServiceImpl salesServiceImpl = new SalesServiceImpl();
			SalesDTO dto = salesServiceImpl.getById(i);

			salesDTO.setIdSale(dto.getIdSale());
			salesDTO.setNameProduct(dto.getNameProduct());
			salesDTO.setQuantity(dto.getQuantity());
			salesDTO.setPricePerchase(dto.getPricePerchase());

		} catch (Exception e) {
			System.out.println("not updated succes");
		}
		return redirectToEdit();

	}

	
	public String redirectToEdit() {

		return "EditSales.xhtml?faces-redirect=true";

	}

	public String redirectToAllSales() {

		return "AllSales.xhtml?faces-redirect=true";

	}
	
	public int TotalSales() {
		int size = 0;
		try {
			size = getAll().size();
			System.out.println("list done" + size);

		} catch (Exception e) {
			System.out.println("list not done");

		}
		return size;
	}
}
