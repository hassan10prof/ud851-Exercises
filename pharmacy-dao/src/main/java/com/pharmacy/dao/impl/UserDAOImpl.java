package com.pharmacy.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pharmacy.dao.UserDAO;
import com.pharmacy.model.User;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	private Session session;
//	private Products product;

	@SuppressWarnings("unchecked")
	public UserDAOImpl() {
		this.sessionFactory = getsessionFactory();

	}

	private SessionFactory getsessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}

	@Override
	public List<User> login(String myusername, String mypassword) {
		List<User> resultUsers = null;

		session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		// save object
		Query query = session.createQuery("from User where userName=:myusername and password=:mypassword");
		query.setParameter("myusername", myusername);
		query.setParameter("mypassword", mypassword);
		resultUsers=query.getResultList();
		
		// end of transaction
		System.out.println(resultUsers);
		session.getTransaction().commit();
		// close session
		session.close();
//		if (resultUsers.size() == 1) {
//			return true;
//		} else {
//			return false;
//
//		}
		return resultUsers;

	}
}
