package com.itservice.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itservice.dao.PersonDAO;
import com.itservice.model.Person;
import com.itservice.model.PersonProject;
import com.itservice.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDAO dao;

	@Override
	public Person findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void save(Person obj) {
		dao.save(obj);
	}

	@Override
	public void update(Person obj) {
		Person entity =(Person) findById(obj.getId());
		if(entity!=null){
			entity.setName(obj.getName());
			entity.setSurname(obj.getSurname());
			entity.setLastname(obj.getLastname());
			entity.setEmail(obj.getEmail());
		}
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Person> list() {
		return dao.listPeople();
	}

	

}
