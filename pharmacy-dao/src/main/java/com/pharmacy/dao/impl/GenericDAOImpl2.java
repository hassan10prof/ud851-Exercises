package com.pharmacy.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pharmacy.dao.GenericDAO;
import com.pharmacy.model.Products;

public class GenericDAOImpl2<K, T> implements GenericDAO<K, T> {

	private SessionFactory sessionFactory;

	private Session session;

	private Class<T> type;

	
	public Class<T> getType() {
		return this.type;
		
	}


	@SuppressWarnings("unchecked")
	public GenericDAOImpl2() {
		this.sessionFactory = getsessionFactory();
		 Type t = getClass().getGenericSuperclass(); 
		  ParameterizedType pt =(ParameterizedType) t; 
		  type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	private SessionFactory getsessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}

	@Override
	public T create(T t) throws Exception {
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
	Products p;
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		List<T> result = new ArrayList<T>();
		//open session
		session = sessionFactory.openSession();
		//begin transaction
        session.beginTransaction();
        result = session.createQuery("from " + type.getSimpleName()).list();
        
        //end of transaction
		session.getTransaction().commit();
		//close session
		session.close();
		return result;
	}
	@Override
	public T udpate(K k, T t) {
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
	public void delete(K k) throws Exception {
		
//		session = sessionFactory.openSession();
//		// begin transaction
//		session.beginTransaction();
////		Query query =session.createQuery("from Product where id = :id");
////		query.setParameter("id", k);
//		session.delete((T) session.get(type, (Long) k));
//		// end of transaction
//		session.getTransaction().commit();
//		// close session
//		session.close();

	}
	@Override
	public T getById(K k) throws Exception {
		// open session
		session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		T result = session.find(type, k);
		// end of transaction
		session.getTransaction().commit();
		// close session
		session.close();
		return result;
	}


	@Override
	public Optional<T> getByIdOptional(K k) {
		// TODO Auto-generated method stub
		return null;
	}

}
