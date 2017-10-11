package com.itservice.dao;

import java.util.List;

import com.itservice.model.Company;

public interface CompanyDAO {
	 Company findById(long id);
	 void save(Company company);
	 void delete(long id);
	 List<Company> listCompany();
}
