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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(schema = "public", name = "person")
public class Person implements Serializable{

	private static final long serialVersionUID = 7298896455103216692L;
	
	private long id;
	private String name;
	private String lastname;
	private String surname;
	private String email;
	private Set<PersonProject> projects = new HashSet<PersonProject>(0);
	
	
	public Person(long id, String name, String surname, String lastname, String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.lastname = lastname;
		this.email = email;
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
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Size(min = 3, max = 50)
	@Column(name = "surname", nullable = false)
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Size(min = 3, max = 50)
	@Column(name = "lastname", nullable = false)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Email
	@NotNull
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.person")
	public Set<PersonProject> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<PersonProject> projects) {
		this.projects = projects;
	}

}
