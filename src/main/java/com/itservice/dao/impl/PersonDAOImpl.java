package com.itservice.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.itservice.dao.AbstractDAO;
import com.itservice.dao.PersonDAO;
import com.itservice.model.Person;

@Repository("personDao")
public class PersonDAOImpl extends AbstractDAO<Person> implements PersonDAO{

	public PersonDAOImpl() {
		super(Person.class);
	}

	@Override
	public Person findById(long id) {
		return getByKey(id);
	}

	@Override
	public void save(Person person) {
		persist(person);
		
	}

	@Override
	public void delete(long id) {
		Query query = getSession().createSQLQuery("DELETE FROM person WHERE id=:id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public List<Person> listPeople() {
		Criteria criteria = createEntityCriteria();
		return criteria.list();
	}

}
