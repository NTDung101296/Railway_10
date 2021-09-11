package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exercise1 {

	private Scanner scanner;
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public Exercise1() {
		scanner = new Scanner(System.in);
	}

	public void question1() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "2021P@ss";

		Class.forName("com.mysql.cj.jdbc.Driver");

		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect success!");
	}

	public void question2() throws ClassNotFoundException, SQLException {
		statement = connection.createStatement();

		String sql = "SELECT * FROM `position`";
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			System.out.println(resultSet.getByte("position_id"));
			System.out.println(resultSet.getString("position_name"));
		}
	}

	public void question3() throws SQLException {

		System.out.print("Nhap vao ten: ");
		String positionName = scanner.nextLine();

		String sql = "INSERT INTO `position` (position_name) VALUES (?);";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, positionName);
		preparedStatement.executeUpdate();

		System.out.println("Insert success");
	}

	public void question4() throws SQLException {

		String sql = "UPDATE position SET position_name = 'De' WHERE position_id = 5;";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("Update success");
	}

	public void question5() throws SQLException {
		System.out.print("Nhap vao ID muon xoa: ");
		byte id = scanner.nextByte();

		String sql = "DELETE FROM `position` WHERE position_id = ?;";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setByte(1, id);
		preparedStatement.executeUpdate();
		System.out.println("Delete success");
	}

}
