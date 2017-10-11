package com.itservice.service;

import java.util.List;

public interface BasicCRUDOperations<T> {
	
	T findById(int id);
	void save(T obj);
	void update(T obj);
	void delete(int id);
	List<T> list();
}
