package com.itservice.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PersonProjectId implements Serializable{

	private static final long serialVersionUID = 2492334359132492351L;
	
	private Person person;
	private Project project;
	
	@ManyToOne
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
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
		
		PersonProjectId arg = (PersonProjectId) o;
		if(person !=null ? !person.equals(arg.person): arg.person !=null) return false;
		if(project != null ? project.equals(arg.project) : arg.project != null) return false;
		
		return true;
	}
	
	public int hashCode(){
		int result = 17;
		result = (person != null ? person.hashCode() : 0);
		result = 31 * result + (project != null ? project.hashCode() :0);
		return result;
	}

}
