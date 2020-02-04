package com.pharmacy.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pharmacy.dao.ProductsDAO;
import com.pharmacy.model.Products;

public class ProductsDAOImpl implements ProductsDAO {

	private SessionFactory sessionFactory;

	private Session session;
//	private Products product;
	
	@SuppressWarnings("unchecked")
	public ProductsDAOImpl() {
		this.sessionFactory = getsessionFactory();
		 
	}
	

	private SessionFactory getsessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}

	
	@Override
	public Products create(Products p) throws Exception {
		// open session
		session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		// save object
		session.save(p);
		// end of transaction
		session.getTransaction().commit();
		// close session
		session.close();
		return p;
	}

	@Override
	public List<Products> getAll() {
		List<Products> result = null;
		//open session
		session = sessionFactory.openSession();
		//begin transaction
        session.beginTransaction();
        result = session.createQuery("from Products").list();
        
        //end of transaction
		session.getTransaction().commit();
		//close session
		session.close();
		return result;
	}

	

	@Override
	public Products udpate(Long id, Products p) {
		//open session
		session = sessionFactory.openSession();
		//begin transaction
		session.beginTransaction();
		//T result = (T) session.update((T) session.get(type, (Long)k));
		//T result = (T) session.get(t.getClass(),(Long)k);
		session.update(p);
		//end of transaction
		session.getTransaction().commit();
		//close session
		session.close();
		return p;
	}

	@Override
	public void delete(Long id) throws Exception {
		session = sessionFactory.openSession();

		// begin transaction
		session.beginTransaction();
		
		session.delete((Products) session.get(Products.class, (Long) id));
		
		// end transaction
		session.getTransaction().commit();

		// close session
		session.close();
		
	}

	@Override
	public Products getById(Long k) throws Exception {
		session = sessionFactory.openSession();

		// begin transaction
		session.beginTransaction();
		
		Products tFromDB = (Products) session.get(Products.class, (Long) k);
		
		// end transaction
		session.getTransaction().commit();

		// close session
		session.close();
		return tFromDB;
	}


	@Override
	public Optional<Products> getByIdOptional(Long k) {
		session = sessionFactory.openSession();

		// begin transaction
		session.beginTransaction();
		
		Products tFromDB = (Products) session.get(Products.class, (Long) k);
		
		// end transaction
		session.getTransaction().commit();

		// close session
		session.close();
		return (Optional<Products>) Optional.of(tFromDB);
	}


	@Override
	public List<Products> getAllByQantity(int v1,int v2) {
		List<Products> result = null;
		//open session
		session = sessionFactory.openSession();
		//begin transaction
        session.beginTransaction();
        result = session.createQuery("from Products where quantity BETWEEN "+v1+" AND "+v2).list();
        System.out.println(result);
        //end of transaction
		session.getTransaction().commit();
		//close session
		session.close();
		return result;
	}

	
}
