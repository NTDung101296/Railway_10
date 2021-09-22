package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IManagerRepository;
import com.vti.backend.datalayer.ManagerRepository;
import com.vti.entity.Manager;

public class ManagerService implements IManagerService {

	private IManagerRepository managerRepository;

	public ManagerService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		managerRepository = new ManagerRepository();
	}

	public Manager loginManager(String email, String password) throws Exception {
		return managerRepository.loginManager(email, password);
	}

	public boolean isManagerExistByEmail(String email) throws ClassNotFoundException, SQLException {
		return managerRepository.isManagerExistByEmail(email);
	}
	
	public boolean isManagerExistById(String managerId) throws ClassNotFoundException, SQLException {
		return managerRepository.isManagerExistById(managerId);
	}

	public boolean isCorrectPassword(String password) throws ClassNotFoundException, SQLException {
		return managerRepository.isCorrectPassword(password);
	}

	public Manager getManagerById(String managerId) throws Exception {
		return managerRepository.getManagerById(managerId);
	}

	public List<Manager> getManagerOfAllProject() throws ClassNotFoundException, SQLException {
		return managerRepository.getManagerOfAllProject();
	}

}
