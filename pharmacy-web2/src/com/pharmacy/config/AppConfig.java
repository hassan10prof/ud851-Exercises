package com.pharmacy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pharmacy.dao.ProductsDAO;
import com.pharmacy.dao.impl.ProductsDAOImpl;
import com.pharmacy.service.ProductsService;
import com.pharmacy.service.Impl.PorductsServiceImpl;

@Configuration
@ComponentScan("com.pharmacy")
public class AppConfig {

	@Bean
	public ProductsDAO productsDAO(){
		return new ProductsDAOImpl();
	}
	

	@Bean
	public ProductsService productsService(){
		return new PorductsServiceImpl(productsDAO());
	}
}
