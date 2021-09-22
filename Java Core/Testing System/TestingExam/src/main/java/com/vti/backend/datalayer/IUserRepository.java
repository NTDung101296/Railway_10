package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserRepository {
	List<User> getListUsers() throws SQLException, ClassNotFoundException;

	User getUserById(short id) throws SQLException, ClassNotFoundException;

	boolean isUserExistsById(short id) throws SQLException, ClassNotFoundException;

	boolean isUserExistsByEmail(String email) throws SQLException, ClassNotFoundException;
	
	boolean isCorrectPassword(String password) throws SQLException, ClassNotFoundException;

	boolean deleteUser(short id) throws Exception;

	User login(String email, String password) throws Exception;

	boolean createUser(String fullName, String email, String password, byte exp, String skill) throws Exception;
}
