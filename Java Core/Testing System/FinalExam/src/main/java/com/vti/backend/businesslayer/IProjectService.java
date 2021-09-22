package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Project;

public interface IProjectService {
	
	Project getProjectById(int id) throws SQLException, ClassNotFoundException, Exception;
	
	List<Project> getProjectsByEmployeeId(String employeeId) throws Exception;
	
	boolean isProjectExistById(int id) throws ClassNotFoundException, SQLException;
}
