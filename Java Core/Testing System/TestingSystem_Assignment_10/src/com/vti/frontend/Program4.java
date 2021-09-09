package com.vti.frontend;

import java.sql.SQLException;

import com.vti.backend.Exercise4;

public class Program4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Exercise4 ex4 = new Exercise4();
		ex4.deleteDepartmentById(3);
	}
}
