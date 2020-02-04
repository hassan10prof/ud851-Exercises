package com.pharmacy.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pharmacy.dao.SupplierDAO;
import com.pharmacy.model.Products;
import com.pharmacy.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO{


	private SessionFactory sessionFactory;

	private Session session;
//	private Products product;
	
	@SuppressWarnings("unchecked")
	public SupplierDAOImpl() {
		this.sessionFactory = getsessionFactory();
		 
	}
	

	private SessionFactory getsessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}

	
	
	@Override
	public Supplier create(Supplier t) throws Exception {
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
	public List<Supplier> getAll() {
		List<Supplier> result = null;
		//open session
		session = sessionFactory.openSession();
		//begin transaction
        session.beginTransaction();
        result = session.createQuery("from Supplier").list();
        
        //end of transaction
		session.getTransaction().commit();
		//close session
		session.close();
		return result;
	}

	@Override
	public Supplier udpate(Long id, Supplier t) {
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
		
		session.delete((Supplier) session.get(Supplier.class, (Long) id));
		
		// end transaction
		session.getTransaction().commit();

		// close session
		session.close();		
	}

	@Override
	public Supplier getById(Long k) throws Exception {
		session = sessionFactory.openSession();

		// begin transaction
		session.beginTransaction();
		
		Supplier tFromDB = (Supplier) session.get(Supplier.class, (Long) k);
		
		// end transaction
		session.getTransaction().commit();

		// close session
		session.close();
		return tFromDB;
	}

	@Override
	public Optional<Supplier> getByIdOptional(Long k) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Supplier> getAllByDate(Date fromdate, Date toDate) {
		List<Supplier> result = null;
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yy");

		//open session
		session = sessionFactory.openSession();
		//begin transaction
        session.beginTransaction();
        result = session.createQuery("FROM Supplier where dateRegestration between "+fromdate+" and "+toDate).list();
        System.out.println("my requet" +result);
        //end of transaction
		session.getTransaction().commit();
		//close session
		session.close();
		return result;
	}

}
