package com.pharmacy.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<K,T> {
	
	public T create (T t) throws Exception;
	
	public List<T> getAll();
	
	public T udpate (K k, T t);
	
	public void delete (K k) throws Exception;
	
	public T getById(K k) throws Exception;
	
	public Optional<T> getByIdOptional(K k);


}

