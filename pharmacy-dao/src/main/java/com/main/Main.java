package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pharmacy.model.Products;

public class Main {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Products p = new Products();

		p.setNameProduct("product2");
		p.setSupplier("someone");
		p.setQuantity(120);
		p.setPricePerchase(30);

		session.save(p);

		t.commit();

	}

}
