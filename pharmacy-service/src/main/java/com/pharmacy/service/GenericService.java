package com.pharmacy.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<K,T> {
	
	T create(T t) throws Exception ;
	
	T update(K k, T t);
	
	void delete(K v) throws Exception ;
		
	Optional<T> getByIdOptional(K k);
	
	List<T> getAll();
	
	 T getById(K k) throws Exception;

}
