package com.itservice.service;

import com.itservice.form.ProjectForm;
import com.itservice.model.Project;

public interface ProjectService extends BasicCRUDOperations<Project>{
	void save(ProjectForm form);
	void update(ProjectForm form);

}
