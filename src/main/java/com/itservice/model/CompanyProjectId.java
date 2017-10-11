package com.itservice.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CompanyProjectId implements Serializable{

	private static final long serialVersionUID = -4871496702176849837L;
	
	private Company company;
	private Project project;
	
	@ManyToOne
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	@ManyToOne
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		CompanyProjectId arg = (CompanyProjectId) o;
		if(company !=null ? !company.equals(arg.company): arg.company !=null) return false;
		if(project != null ? project.equals(arg.project) : arg.project != null) return false;
		
		return true;
	}
	
	public int hashCode(){
		int result = 17;
		result = (company != null ? company.hashCode() : 0);
		result = 31 * result + (project != null ? project.hashCode() :0);
		return result;
	}

}
