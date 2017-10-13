package com.itservice.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.itservice.dao.AbstractDAO;
import com.itservice.dao.ProjectDAO;
import com.itservice.model.Project;

@Repository("projectDao")
public class ProjectDAOImpl extends AbstractDAO<Project> implements ProjectDAO{

	public ProjectDAOImpl() {
		super(Project.class);
	}

	@Override
	public Project findById(long id) {
		return getByKey(id);
	}

	@Override
	public void save(Project project) {
		persist(project);
		
	}

	@Override
	public void delete(long id) {
		Query deleteCompanies = getSession().createSQLQuery("DELETE FROM company_project WHERE PROJECT_ID=:id");
		deleteCompanies.setLong("id", id);
		deleteCompanies.executeUpdate();
		
		Query deletePerformers = getSession().createSQLQuery("DELETE FROM person_project WHERE PROJECT_ID=:id");
		deletePerformers.setLong("id", id);
		deletePerformers.executeUpdate();
		
		Query query = getSession().createSQLQuery("DELETE FROM project WHERE id=:id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public List<Project> listProjects() {
		Criteria criteria = createEntityCriteria();
		return criteria.list();
	}

}
