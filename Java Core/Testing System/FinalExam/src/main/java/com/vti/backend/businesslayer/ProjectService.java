package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IProjectRepository;
import com.vti.backend.datalayer.ProjectRepository;
import com.vti.entity.Project;

public class ProjectService implements IProjectService {

	private IProjectRepository projectRepository;

	public ProjectService() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		projectRepository = new ProjectRepository();
	}

	public Project getProjectById(int id) throws Exception {
		return projectRepository.getProjectById(id);
	}

	public List<Project> getProjectsByEmployeeId(String employeeId) throws Exception {
		return projectRepository.getProjectsByEmployeeId(employeeId);
	}

	public boolean isProjectExistById(int id) throws ClassNotFoundException, SQLException {
		return projectRepository.isProjectExistById(id);
	}

}
