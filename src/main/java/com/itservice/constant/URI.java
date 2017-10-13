package com.itservice.constant;

public final class URI {
	/***main urls ***/
	public static final String MAIN = "/";
	public static final String HOME ="/home";
	
	/** person urls ***/
	public static final String PERSON_LIST = "/employees";
	public static final String PERSON_SHOW = "/employees/{id}";
	public static final String PERSON_DELETE = "/employees/{id}/delete";
	public static final String PERSON_UPDATE = "/employees/{id}/update";
	public static final String PERSON_INSERT = "/employees/new";

	
	/*** projects urls ***/
	public static final String PROJECT_LIST = "/projects";
	public static final String PROJECT_SHOW = "/projects/{id}";
	public static final String PROJECT_DELETE = "/projects/{id}/delete";
	public static final String PROJECT_UPDATE = "/projects/{id}/update";
	public static final String PROJECT_INSERT = "/projects/new";

}
