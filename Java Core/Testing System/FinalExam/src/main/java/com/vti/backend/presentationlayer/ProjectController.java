package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.ProjectService;
import com.vti.backend.businesslayer.IProjectService;
import com.vti.entity.Project;

public class ProjectController {

	private IProjectService projectService;

	public ProjectController() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		projectService = new ProjectService();
	}
	
	public Project getProjectById(int id) throws Exception {
		return projectService.getProjectById(id);
	}

	public List<Project> getProjectsByEmployeeId(String employeeId) throws Exception {
		return projectService.getProjectsByEmployeeId(employeeId);
	}

	public boolean isProjectExistById(int id) throws ClassNotFoundException, SQLException {
		return projectService.isProjectExistById(id);
	}

	
}
