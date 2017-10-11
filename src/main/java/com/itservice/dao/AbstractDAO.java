package com.itservice.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<T> {
    private final Class<T> persistentClass;

    public AbstractDAO(Class<T> persistentClass) {
	this.persistentClass = persistentClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    protected Criteria createEntityCriteria() {
	return getSession().createCriteria(persistentClass,"this");
    }

    @SuppressWarnings("unchecked")
    public <T, PK> T getByKey(PK key) {
	return (T) getSession().get(persistentClass, (Serializable) key);
    }

    public <T> void persist(T entity) {
	getSession().persist(entity);
    }

    public <T> void delete(T entity) {
	getSession().delete(entity);
    }
}
