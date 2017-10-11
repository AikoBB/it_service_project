package com.itservice.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.itservice.dao.AbstractDAO;
import com.itservice.dao.CompanyDAO;
import com.itservice.model.Company;

@Repository("companyDao")
public class CompanyDAOImpl extends AbstractDAO<Company> implements CompanyDAO {

	public CompanyDAOImpl() {
		super(Company.class);
	}

	@Override
	public Company findById(long id) {
		return getByKey(id);
	}

	@Override
	public void save(Company company) {
		persist(company);
	}

	@Override
	public void delete(long id) {
		Query query = getSession().createSQLQuery("DELETE FROM company WHERE id=:id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public List<Company> listCompany() {
		Criteria criteria = createEntityCriteria();
		return criteria.list();
	}

}
