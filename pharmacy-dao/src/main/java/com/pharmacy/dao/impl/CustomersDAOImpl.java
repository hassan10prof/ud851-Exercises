package com.pharmacy.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pharmacy.dao.CustomersDAO;
import com.pharmacy.model.Customers;
import com.pharmacy.model.Products;

public class CustomersDAOImpl  implements CustomersDAO{

	private SessionFactory sessionFactory;

	private Session session;
//	private Products product;
	
	@SuppressWarnings("unchecked")
	public CustomersDAOImpl() {
		this.sessionFactory = getsessionFactory();
		 
	}
	

	private SessionFactory getsessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}

	
	@Override
	public Customers create(Customers t) throws Exception {
		// open session
		session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		// save object
		session.save(t);
		// end of transaction
		session.getTransaction().commit();
		// close session
		session.close();
		return t;
	}

	@Override
	public List<Customers> getAll() {
		List<Customers> result = null;
		//open session
		session = sessionFactory.openSession();
		//begin transaction
        session.beginTransaction();
        result = session.createQuery("from Customers").list();
        
        //end of transaction
		session.getTransaction().commit();
		//close session
		session.close();
		return result;
	}

	@Override
	public Customers udpate(Long k, Customers t) {
		//open session
				session = sessionFactory.openSession();
				//begin transaction
				session.beginTransaction();
				//T result = (T) session.update((T) session.get(type, (Long)k));
				//T result = (T) session.get(t.getClass(),(Long)k);
				session.update(t);
				//end of transaction
				session.getTransaction().commit();
				//close session
				session.close();
				return t;
	}

	@Override
	public void delete(Long id) throws Exception {
		session = sessionFactory.openSession();

		// begin transaction
		session.beginTransaction();
		
		session.delete((Customers) session.get(Customers.class, (Long) id));
		
		// end transaction
		session.getTransaction().commit();

		// close session
		session.close();		
	}

	@Override
	public Customers getById(Long k) throws Exception {
		session = sessionFactory.openSession();

		// begin transaction
		session.beginTransaction();
		
		Customers tFromDB = (Customers) session.get(Customers.class, (Long) k);
		
		// end transaction
		session.getTransaction().commit();

		// close session
		session.close();
		return tFromDB;
	}

	@Override
	public Optional<Customers> getByIdOptional(Long k) {
		// TODO Auto-generated method stub
		return null;
	}

}
