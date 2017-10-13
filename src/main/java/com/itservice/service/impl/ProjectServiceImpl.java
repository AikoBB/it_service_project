package com.itservice.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itservice.constant.CompanyRole;
import com.itservice.constant.PersonRole;
import com.itservice.dao.ProjectDAO;
import com.itservice.form.ProjectForm;
import com.itservice.model.Company;
import com.itservice.model.CompanyProject;
import com.itservice.model.PersonProject;
import com.itservice.model.Project;
import com.itservice.service.CompanyService;
import com.itservice.service.PersonService;
import com.itservice.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectDAO dao;

	@Autowired 
	PersonService personService;
	@Autowired 
	CompanyService companyService;
	
	@Override
	public Project findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void save(Project obj) {
		dao.save(obj);
	}

	@Override
	public void update(Project obj) {
		Project entity =(Project) findById(obj.getId());
		if(entity!=null){
			
		}
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

	@Override
	public List<Project> list() {
		return dao.listProjects();
	}
	
	@Override
	public void save(ProjectForm form) {
		form.getProject().setCompanies(getCompanies(form));
		form.getProject().setPerformers(getPerformers(form));
		save(form.getProject());
		
	}

	@Override
	public void update(ProjectForm form) {
		Project updated = form.getProject();
		Project entity =(Project) findById(updated.getId());
		if(entity!=null){
			entity.setTitle(updated.getTitle());
			entity.setPriority(updated.getPriority());
			entity.setEndDate(updated.getEndDate());
			entity.setStartDate(updated.getStartDate());
			entity.setComment(updated.getComment());
			entity.setCompanies(getCompanies(form));
			entity.setPerformers(getPerformers(form));
		}
	}

	private Set<CompanyProject> getCompanies(ProjectForm form){
		CompanyProject executer = new CompanyProject();
		Set<CompanyProject> companies = new HashSet<CompanyProject>();
		
		if(form.getNewExecuter().length()>0){
			Company company =new Company();
			company.setTitle(form.getNewExecuter());
			companyService.save(company);
			executer.setCompany(company);
		}
		else{
			executer.setCompany(companyService.findById(form.getExecuter()));
		}

		executer.setRole(CompanyRole.EXECUTER);
		executer.setProject(form.getProject());
		companies.add(executer);
		
		CompanyProject customer = new CompanyProject();
		if(form.getNewCustomer().length()>0){
			Company company =new Company();
			company.setTitle(form.getNewCustomer());
			companyService.save(company);
			customer.setCompany(company);
		}
		else{
			customer.setCompany(companyService.findById(form.getCustomer()));
		}
		customer.setRole(CompanyRole.CUSTOMER);
		customer.setProject(form.getProject());
		companies.add(customer);
		return companies;
	}
	
	private Set<PersonProject> getPerformers(ProjectForm form){
		Set<PersonProject> performers = new HashSet<PersonProject>();
		if(form.getLeader()>0){
			long leaderId = form.getLeader();
			form.getPerformers().remove(leaderId);
			System.out.println(leaderId+"leader id");
			PersonProject leader = new PersonProject();
			leader.setPerson(personService.findById(leaderId));
			leader.setRole(PersonRole.LEADER);
			leader.setProject(form.getProject());
			performers.add(leader);
		}
		
		for(Long id : form.getPerformers()){
			PersonProject pp =new PersonProject();
			pp.setProject(form.getProject());
			pp.setPerson(personService.findById(id));
			pp.setRole(PersonRole.EMPLOYEE);
			performers.add(pp);
		}
		
		return performers;
	}
}
