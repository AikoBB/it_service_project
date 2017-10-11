package com.itservice.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itservice.constant.CompanyRole;

@Entity
@Table(name="company_project", schema="public")
@AssociationOverrides({@AssociationOverride(name="pk.company", joinColumns = @JoinColumn(name = "COMPANY_ID")),
					   @AssociationOverride(name="pk.project", joinColumns = @JoinColumn(name = "PROJECT_ID"))})
public class CompanyProject implements Serializable{

	private static final long serialVersionUID = 1L;

	private CompanyProjectId pk = new CompanyProjectId();
	private CompanyRole role;
	
	@EmbeddedId
	public CompanyProjectId getPk() {
		return pk;
	}
	public void setPk(CompanyProjectId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Company getCompany(){
		return getPk().getCompany();
	}
	public void setCompany(Company company){
		getPk().setCompany(company);
	}
	
	@Transient
	public Project getProject(){
		return getPk().getProject();
	}
	public void setProject(Project project){
		getPk().setProject(project);
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "company_role")
	public CompanyRole getRole() {
		return role;
	}
	public void setRole(CompanyRole role) {
		this.role = role;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CompanyProject arg = (CompanyProject) o;

		if (getPk() != null ? !getPk().equals(arg.getPk())
				: arg.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	
}
