package com.itservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itservice.dao.CompanyDAO;
import com.itservice.model.Company;
import com.itservice.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDAO dao;

	@Override
	public Company findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void save(Company obj) {
		dao.save(obj);
	}

	@Override
	public void update(Company obj) {
		Company entity =(Company) findById(obj.getId());
		if(entity!=null){
			entity.setTitle(obj.getTitle());
		}
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

	@Override
	public List<Company> list() {
		return dao.listCompany();
	}

}
