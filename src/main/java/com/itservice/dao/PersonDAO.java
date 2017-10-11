package com.itservice.dao;

import java.util.List;

import com.itservice.model.Person;

public interface PersonDAO {
	
	 Person findById(long id);
	 void save(Person person);
	 void delete(long id);
	 List<Person> listPeople();
	 
}
