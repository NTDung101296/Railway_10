package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Manager;

public interface IManagerService {

	Manager loginManager(String email, String password) throws Exception;

	boolean isManagerExistByEmail(String email) throws ClassNotFoundException, SQLException;
	
	boolean isManagerExistById(String managerId) throws ClassNotFoundException, SQLException;

	boolean isCorrectPassword(String password) throws ClassNotFoundException, SQLException;

	Manager getManagerById(String managerId) throws ClassNotFoundException, SQLException, Exception;

	List<Manager> getManagerOfAllProject() throws ClassNotFoundException, SQLException;
}
