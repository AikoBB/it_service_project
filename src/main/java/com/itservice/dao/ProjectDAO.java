package com.itservice.dao;

import java.util.List;
import com.itservice.model.Project;

public interface ProjectDAO {
	 Project findById(long id);
	 void save(Project project);
	 void delete(long id);
	 List<Project> listProjects();

}
