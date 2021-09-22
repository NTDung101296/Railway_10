package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IManagerService;
import com.vti.backend.businesslayer.ManagerService;
import com.vti.entity.Manager;

public class ManagerController {

	private IManagerService managerService;

	public ManagerController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		managerService = new ManagerService();
	}

	public Manager loginManager(String email, String password) throws Exception {
		return managerService.loginManager(email, password);
	}

	public boolean isManagerExistByEmail(String email) throws ClassNotFoundException, SQLException {
		return managerService.isManagerExistByEmail(email);
	}
	
	public boolean isManagerExistById(String managerId) throws ClassNotFoundException, SQLException {
		return managerService.isManagerExistById(managerId);
	}

	public boolean isCorrectPassword(String password) throws ClassNotFoundException, SQLException {
		return managerService.isCorrectPassword(password);
	}

	public Manager getManagerById(String managerId) throws Exception {
		return managerService.getManagerById(managerId);
	}

	public List<Manager> getManagerOfAllProject() throws ClassNotFoundException, SQLException {
		return managerService.getManagerOfAllProject();
	}

}
