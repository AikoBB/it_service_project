package com.itservice.service;

import java.util.List;

public interface BasicCRUDOperations<T> {
	
	T findById(long id);
	void save(T obj);
	void update(T obj);
	void delete(long id);
	List<T> list();
}
