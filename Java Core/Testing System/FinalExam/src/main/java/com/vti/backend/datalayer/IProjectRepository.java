package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Project;

public interface IProjectRepository {
	
	Project getProjectById(int id) throws SQLException, ClassNotFoundException, Exception;
	
	List<Project> getProjectsByEmployeeId(String employeeId) throws Exception;
	
	boolean isProjectExistById(int id) throws ClassNotFoundException, SQLException;

}
