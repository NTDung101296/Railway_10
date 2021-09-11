package com.vti.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vti.utils.JdbcUtils;

public class Exercise4 {
	private Connection connection;
	private JdbcUtils jdbcUtils;
	
	public void deleteDepartmentById(int id) throws ClassNotFoundException, SQLException {
		//get connection
		jdbcUtils.connect();
		
		//turn off auto commit
		connection.setAutoCommit(false);
		
		//delete employees
		String sql1 = "DELETE FROM `account` " + "WHERE department_id = ?";
		PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
		
		//set parameter
		preparedStatement1.setInt(1, id);
		
		//delete department
		String sql2 = "DELETE FROM department " + "WHERE department_id = ?";
		PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
		
		//set parameter
		preparedStatement2.setInt(1, id);
		
		//excute query
		try {
			preparedStatement1.executeUpdate();
			System.out.println("Delete account success!");
			
			preparedStatement2.executeUpdate();
			System.out.println("Delete department success!");
			
			//commit transaction
			connection.commit();
			System.out.println("Transaction Commit!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			connection.rollback();
			System.out.println("Transaction Rollback!");
		}
		
		//turn on auto commit
		connection.setAutoCommit(true);
		
		//close connection
		jdbcUtils.disconnect();
	}
}
