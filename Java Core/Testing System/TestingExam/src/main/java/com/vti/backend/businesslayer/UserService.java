package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.UserRepository;
import com.vti.backend.datalayer.IUserRepository;
import com.vti.entity.User;

public class UserService implements IUserService {

	private IUserRepository userRepository;

	public UserService() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		userRepository = new UserRepository();
	}

	public List<User> getListUsers() throws SQLException, ClassNotFoundException {
		return userRepository.getListUsers();
	}

	public User getUserById(short id) throws SQLException, ClassNotFoundException {
		return userRepository.getUserById(id);
	}

	public boolean isUserExistsById(short id) throws SQLException, ClassNotFoundException {
		return userRepository.isUserExistsById(id);
	}

	public boolean isUserExistsByEmail(String email) throws SQLException, ClassNotFoundException {
		return userRepository.isUserExistsByEmail(email);
	}
	
	public boolean isCorrectPassword(String password) throws SQLException, ClassNotFoundException {
		return userRepository.isCorrectPassword(password);
	}

	public boolean deleteUser(short id) throws Exception {
		return userRepository.deleteUser(id);
	}

	public User login(String email, String password) throws Exception {
		return userRepository.login(email, password);
	}

	public boolean createUser(String fullName, String email, String password, byte exp, String skill) throws Exception {
		return userRepository.createUser(fullName, email, password, exp, skill);
	}

}
