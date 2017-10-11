package com.itservice.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "project")
public class Project {

	private long id;
	private String title;
	private Set<CompanyProject> companies = new HashSet<CompanyProject>(0);
	private Set<PersonProject> performers = new HashSet<PersonProject>(0);
	private Date startDate;
	private Date endDate;
	private int priority;
	private String comment;
	
	public Project(long id, Set<CompanyProject> companies, Set<PersonProject> performers,
			Date startDate, Date endDate, int priority, String comment) {
		this.id = id;
		this.companies = companies;
		this.performers = performers;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.comment = comment;
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
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "start_date", columnDefinition = "DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "end_date", columnDefinition = "DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@NotNull
	@Column(name = "priority", columnDefinition = "int default 0", nullable = false)
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@NotNull
	@Column(name = "comment", columnDefinition = "text")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.project")
	public Set<PersonProject> getPerformers() {
		return performers;
	}
	public void setPerformers(Set<PersonProject> performers) {
		this.performers = performers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.project")
	public Set<CompanyProject> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<CompanyProject> companies) {
		this.companies = companies;
	}

}
