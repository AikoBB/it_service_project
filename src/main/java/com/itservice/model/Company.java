package com.itservice.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "company")
public class Company implements Serializable{

	private static final long serialVersionUID = -9194972967002265680L;

	private long id;
	private String title;
	private Set<CompanyProject>projects = new HashSet<CompanyProject>();
	
	public Company(){}
	
	public Company(long id, String title) {
		this.id = id;
		this.title = title;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition="bigint")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Size(min = 3, max = 50)
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.company")
	public Set<CompanyProject> getProjects() {
		return projects;
	}
	public void setProjects(Set<CompanyProject> projects) {
		this.projects = projects;
	}
	
	public String toString(){
		return this.getTitle();
	}

}
