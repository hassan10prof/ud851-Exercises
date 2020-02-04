package com.pharmacy.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.service.ProductsService;
import com.pharmacy.service.Impl.PorductsServiceImpl;

@Configuration
@ManagedBean(name = "productsBean")
@SessionScoped
public class ProductsBean {

	private static ProductsService productsService;
	private int v1;
	private int v2;

	public static void main(String[] args) {
		// Annotation Configuration
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		productsService = context.getBean(ProductsService.class);
		((AnnotationConfigApplicationContext) context).close();
	}

	private ProductsDTO productsDTO = new ProductsDTO();;
	private List<ProductsDTO> listproducts = new ArrayList<ProductsDTO>();

	public ProductsBean() {

	}

//	@PostConstruct
//	public void init() {
//		productsDTO = new ProductsDTO();
//	}

	public ProductsBean(ProductsDTO productsDTO) {
		super();
		this.productsDTO = productsDTO;
	}

	public ProductsDTO getProductsDTO() {
		return productsDTO;
	}

	public void setProductsDTO(ProductsDTO productsDTO) {
		this.productsDTO = productsDTO;
	}

	public List<ProductsDTO> getListproducts() {
		try {
			if (v1 == 0 && v2 == 0) {
				listproducts = this.getAll();

			} else {
				listproducts = this.getAllbyquantity();

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("out from list");
		}

		return listproducts;
	}

	public void setListproducts(List<ProductsDTO> listproducts) {
		this.listproducts = listproducts;
	}

	public List<ProductsDTO> getAll() {
		PorductsServiceImpl porductsServiceImpl = new PorductsServiceImpl();

		listproducts = porductsServiceImpl.getAll();

		return listproducts;
	}

	public String SaveProducts() throws Exception {

		PorductsServiceImpl porductsServiceImpl = new PorductsServiceImpl();
		porductsServiceImpl.create(productsDTO);
		return redirectToAllProducts();
	}

	public String RemoveProduct(Long id) {

		try {
			PorductsServiceImpl porductsServiceImpl = new PorductsServiceImpl();
			porductsServiceImpl.delete(id);
			System.out.println("***********Deleted Succes************");

		} catch (Exception e) {
			System.out.println("************delete not succes*********");
		}
		return redirectToAllProducts();

	}

	public String UpdateProduct(Long id) {

		try {
//			ProductsDTO	p=new ProductsDTO();
//			p = new ProductsDTO(p.getNameProduct(), p.getSupplier(),
//					p.getQuantity(), p.getPricePerchase());

			PorductsServiceImpl porductsServiceImpl = new PorductsServiceImpl();
			porductsServiceImpl.update(id, productsDTO);
			productsDTO.setId(null);
			productsDTO.setNameProduct("");
			productsDTO.setSupplier("");
			productsDTO.setQuantity(0);
			productsDTO.setPricePerchase(0.0);
			System.out.println("***********updated Succes************");
		} catch (Exception e) {
			System.out.println("not updated succes");
		}
		return redirectToAllProducts();

	}

	public String SetValues(int id) {
		Long i = (long) id;

		try {
			PorductsServiceImpl porductsServiceImpl = new PorductsServiceImpl();
			ProductsDTO dto = porductsServiceImpl.getById(i);

			productsDTO.setId(dto.getId());
			productsDTO.setNameProduct(dto.getNameProduct());
			productsDTO.setSupplier(dto.getSupplier());
			productsDTO.setQuantity(dto.getQuantity());
			productsDTO.setPricePerchase(dto.getPricePerchase());

			System.out.println("***********updated Succes************");
		} catch (Exception e) {
			System.out.println("not updated succes");
		}
		return redirectToEdit();

	}

	public String redirectToEdit() {

		return "EditProducts.xhtml?faces-redirect=true";

	}

	public String redirectToAllProducts() {

		return "AllProducts.xhtml?faces-redirect=true";

	}

//	public int TotalCustomers() {
//		int size = 0;
//		try {
//			size = getAll().size();
//			System.out.println("list done" + size);
//
//		} catch (Exception e) {
//			System.out.println("list not done");
//
//		}
//		return size;
//	}

	public int getV1() {
		return v1;
	}

	public void setV1(int v1) {
		this.v1 = v1;
	}

	public int getV2() {
		return v2;
	}

	public void setV2(int v2) {
		this.v2 = v2;
	}

	public List<ProductsDTO> getAllbyquantity() {
		PorductsServiceImpl porductsServiceImpl = new PorductsServiceImpl();

		listproducts = porductsServiceImpl.getAllByQantity(v1, v2);

		return listproducts;
	}

	public void CleanFilter() {
		v1 = 0;
		v2 = 0;
	}
}
