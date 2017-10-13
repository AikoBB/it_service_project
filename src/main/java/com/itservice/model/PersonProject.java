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

import com.itservice.constant.PersonRole;

@Entity
@Table(name="person_project", schema="public")
@AssociationOverrides({@AssociationOverride(name="pk.person", joinColumns = @JoinColumn(name = "PERSON_ID")),
					  @AssociationOverride(name="pk.project",joinColumns = @JoinColumn(name = "PROJECT_ID"))})
public class PersonProject implements Serializable{

	private static final long serialVersionUID = -1554319703235576568L;
	
	private PersonProjectId pk = new PersonProjectId();
	private PersonRole role;
	
	@EmbeddedId
	public PersonProjectId getPk() {
		return pk;
	}
	public void setPk(PersonProjectId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Person getPerson(){
		return getPk().getPerson();
	}
	public void setPerson(Person person){
		getPk().setPerson(person);
	}
	
	@Transient
	public Project getProject(){
		return getPk().getProject();
	}
	public void setProject(Project project){
		getPk().setProject(project);
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "person_role")
	public PersonRole getRole() {
		return role;
	}
	public void setRole(PersonRole role) {
		this.role = role;
	} 
	
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PersonProject arg = (PersonProject) o;

		if (getPk() != null ? !getPk().equals(arg.getPk())
				: arg.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

}
