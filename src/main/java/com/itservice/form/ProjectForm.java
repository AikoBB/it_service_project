package com.itservice.form;

import java.util.HashSet;
import java.util.Set;

import com.itservice.model.Project;

public class ProjectForm {

	private int created;
	private Project project;
	private long leader;
	private Set<Long>performers = new HashSet<Long>();
	private long executer;
	private long customer;
	
	private String newExecuter;
	private String newCustomer;
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public long getLeader() {
		return leader;
	}
	public void setLeader(long leader) {
		this.leader = leader;
	}
	public Set<Long> getPerformers() {
		return performers;
	}
	public void setPerformers(Set<Long> performers) {
		this.performers = performers;
	}
	public long getExecuter() {
		return executer;
	}
	public void setExecuter(long executer) {
		this.executer = executer;
	}
	public long getCustomer() {
		return customer;
	}
	public void setCustomer(long customer) {
		this.customer = customer;
	}
	public int getCreated() {
		return created;
	}
	public void setCreated(int created) {
		this.created = created;
	}
	public String getNewExecuter() {
		return newExecuter;
	}
	public void setNewExecuter(String newExecuter) {
		this.newExecuter = newExecuter;
	}
	public String getNewCustomer() {
		return newCustomer;
	}
	public void setNewCustomer(String newCustomer) {
		this.newCustomer = newCustomer;
	}
	
}
