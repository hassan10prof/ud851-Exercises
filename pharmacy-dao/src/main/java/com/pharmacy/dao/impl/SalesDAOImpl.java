package com.pharmacy.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pharmacy.dao.SalesDAO;
import com.pharmacy.model.Products;
import com.pharmacy.model.Sales;

public class SalesDAOImpl implements SalesDAO {

	private SessionFactory sessionFactory;

	private Session session;
//	private Products product;

	@SuppressWarnings("unchecked")
	public SalesDAOImpl() {
		this.sessionFactory = getsessionFactory();

	}

	private SessionFactory getsessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}

	@Override
	public Sales create(Sales t) throws Exception {
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
	public List<Sales> getAll() {
		List<Sales> result = null;
		// open session
		session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		result = session.createQuery("from Sales").list();

		// end of transaction
		session.getTransaction().commit();
		// close session
		session.close();
		return result;
	}

	@Override
	public Sales udpate(Long id, Sales t) {
		// open session
		session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		// T result = (T) session.update((T) session.get(type, (Long)k));
		// T result = (T) session.get(t.getClass(),(Long)k);
		session.update(t);
		// end of transaction
		session.getTransaction().commit();
		// close session
		session.close();
		return t;
	}

	@Override
	public void delete(Long id) throws Exception {
		session = sessionFactory.openSession();

		// begin transaction
		session.beginTransaction();
		
		session.delete((Sales) session.get(Sales.class, (Long) id));
		
		// end transaction
		session.getTransaction().commit();

		// close session
		session.close();

	}

	@Override
	public Sales getById(Long k) throws Exception {
		session = sessionFactory.openSession();

		// begin transaction
		session.beginTransaction();
		
		Sales tFromDB = (Sales) session.get(Sales.class, (Long) k);
		
		// end transaction
		session.getTransaction().commit();

		// close session
		session.close();
		return tFromDB;
	}

	@Override
	public Optional<Sales> getByIdOptional(Long k) {
		// TODO Auto-generated method stub
		return null;
	}

}
