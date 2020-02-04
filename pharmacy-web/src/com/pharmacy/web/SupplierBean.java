package com.pharmacy.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.pharmacy.dto.ProductsDTO;
import com.pharmacy.dto.SupplierDTO;
import com.pharmacy.service.ProductsService;
import com.pharmacy.service.SupplierService;
import com.pharmacy.service.Impl.PorductsServiceImpl;
import com.pharmacy.service.Impl.SupplierSrviceImpl;

@Configuration
@ManagedBean(name = "supplierBean")
@SessionScoped
public class SupplierBean {

	private static SupplierService supplierService;
	private Date fromDate;
	private Date toDate;

	
	public static void main(String[] args) {
		// Annotation Configuration
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		supplierService = context.getBean(SupplierService.class);
		((AnnotationConfigApplicationContext) context).close();
	}
		
		private SupplierDTO supplierDTO=new SupplierDTO();;
		private List<SupplierDTO> listSupplier = new ArrayList<SupplierDTO>();

		
		public SupplierBean() {
		
		}

		public SupplierBean(SupplierDTO supplierDTO) {
			super();
			this.supplierDTO = supplierDTO;
		}
		
		public SupplierDTO getSupplierDTO() {
			return supplierDTO;
		}


		public void setSupplierDTO(SupplierDTO supplierDTO) {
			this.supplierDTO = supplierDTO;
		}


		public List<SupplierDTO> getListSupplier() {
			
			try {
				if(fromDate==null && toDate==null) {
					listSupplier = this.getAll();

				}else {
					listSupplier = this.getAllbyDate();

				}
				
			} catch (Exception e) {
				System.out.println("list supplier not done");
			}
			return listSupplier;
		}


		public void setListSupplier(List<SupplierDTO> listSupplier) {
			this.listSupplier = listSupplier;
		}
		
		public List<SupplierDTO> getAll() {
			SupplierSrviceImpl supplierSrviceImpl = new SupplierSrviceImpl();

			listSupplier = supplierSrviceImpl.getAll();

			return listSupplier;
		}
		
		public String SaveSupplier() throws Exception {

			SupplierSrviceImpl supplierSrviceImpl = new SupplierSrviceImpl();
			supplierSrviceImpl.create(supplierDTO);
			return redirectToAllSupplier();
		}
		public String RemoveSupplier(Long id) {

			try {
				SupplierSrviceImpl supplierSrviceImpl = new SupplierSrviceImpl();
				supplierSrviceImpl.delete(id);

			} catch (Exception e) {
				System.out.println("************delete not succes*********");
			}
			return redirectToAllSupplier();

		}
		
		public String UpdateSupplier(Long id) {

			try {

				SupplierSrviceImpl supplierSrviceImpl = new SupplierSrviceImpl();
				supplierSrviceImpl.update(id, supplierDTO);
				
			} catch (Exception e) {
				System.out.println("not updated succes");
			}
			return redirectToAllSupplier();
			

		}
		
		public String SetValues(int id) {
			Long i = (long) id;

			try {
				SupplierSrviceImpl supplierSrviceImpl = new SupplierSrviceImpl();
				SupplierDTO dto = supplierSrviceImpl.getById(i);
				
				supplierDTO.setId(dto.getId());
				supplierDTO.setName(dto.getName());
				supplierDTO.setPhoneNumber(dto.getPhoneNumber());
				supplierDTO.setAdresse(dto.getAdresse());
				supplierDTO.setDetails(dto.getDetails());
			
			} catch (Exception e) {
				System.out.println("not updated succes");
			}
			return redirectToEdit();

		}
		
		
		public String redirectToEdit() {
			
			return "EditSupplier.xhtml?faces-redirect=true";
			
		}
		
		public String redirectToAllSupplier() {
			
			return "AllSupplier.xhtml?faces-redirect=true";
			
		}
		
		public int TotalSuppliers() {
			int size = 0;
			try {
				 size =getAll().size();
				 System.out.println("list done" +size);

			} catch (Exception e) {
				 System.out.println("list not done");

			}
			return size;
		}
		
		
		
	

		public Date getFromDate() {
			return fromDate;
		}

		public void setFromDate(Date fromDate) {
			this.fromDate = fromDate;
		}

		public Date getToDate() {
			return toDate;
		}

		public void setToDate(Date toDate) {
			this.toDate = toDate;
		}

		public List<SupplierDTO> getAllbyDate() {
			SupplierSrviceImpl supplierSrviceImpl = new SupplierSrviceImpl();

			listSupplier = supplierSrviceImpl.getAllByDate(fromDate, toDate);

			return listSupplier;
		}

		public void CleanFilter() {
			fromDate=null;
			toDate=null;
		}
		
		public int TotalSupplier() {
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
