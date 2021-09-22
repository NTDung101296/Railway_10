package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.UserService;
import com.vti.backend.businesslayer.IUserService;
import com.vti.entity.User;

public class UserController {

	private IUserService userService;

	public UserController() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		userService = new UserService();
	}

	public List<User> getListUsers() throws SQLException, ClassNotFoundException {
		return userService.getListUsers();
	}

	public User getUserById(short id) throws SQLException, ClassNotFoundException {
		return userService.getUserById(id);
	}

	public boolean isUserExistsById(short id) throws SQLException, ClassNotFoundException {
		return userService.isUserExistsById(id);
	}

	public boolean isUserExistsByEmail(String email) throws SQLException, ClassNotFoundException {
		return userService.isUserExistsByEmail(email);
	}
	
	public boolean isCorrectPassword(String password) throws SQLException, ClassNotFoundException {
		return userService.isCorrectPassword(password);
	}

	public boolean deleteUser(short id) throws Exception {
		return userService.deleteUser(id);
	}

	public User login(String email, String password) throws Exception {
		return userService.login(email, password);
	}

	public boolean createUser(String fullName, String email, String password, byte exp, String skill) throws Exception {
		return userService.createUser(fullName, email, password, exp, skill);

	}
}
