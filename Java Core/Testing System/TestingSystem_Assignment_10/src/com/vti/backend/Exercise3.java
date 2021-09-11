package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.vti.utils.JdbcUtils;

public class Exercise3 {
	private CallableStatement callableStatement;
	private DepartmentDao departmentDao;
	private JdbcUtils jdbcUtils;

	public Exercise3() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		departmentDao = new DepartmentDao();
		jdbcUtils = new JdbcUtils();
	}

	public void deleteDepartmentUsingProcedure(byte id) throws Exception {
		// get connection
		jdbcUtils.connect();

		if (!departmentDao.isDepartmentIdExists(id)) {
			throw new Exception("Cannot find department which has id= " + id);
		} else {
			String sql = "CALL sp_delete_department(?)";
			callableStatement = jdbcUtils.createCallableStatement(sql);
			callableStatement.setByte(1, id);

			int effectedRecords = callableStatement.executeUpdate();
			if (effectedRecords > 0) {
				System.out.println("Delete " + effectedRecords + " department complete");
			}
		}

		// close connection
		jdbcUtils.disconnect();
	}

	public void getDepartmentAndPositionNameUsingProcedure(short accountId)
			throws ClassNotFoundException, SQLException {
		jdbcUtils.connect();

		// Preparing a CallableStatement to call a procedure
		String sql = "CALL sp_get_department_name_position_name_by_account_id(?,?,?)";
		callableStatement = jdbcUtils.createCallableStatement(sql);

		// Setting the value for the TN parameter
		callableStatement.setShort(1, accountId);

		// Registering the type of the OUT parameters
		callableStatement.registerOutParameter(2, Types.VARCHAR);
		callableStatement.registerOutParameter(3, Types.VARCHAR);

		// Executing the CallableStatement
		callableStatement.executeUpdate();

		String departmentName = callableStatement.getString(2); // out_department_name
		String positionName = callableStatement.getString(3); // out_position_name

		System.out.println("Department Name: " + departmentName);
		System.out.println("Positon Name: " + positionName);

		jdbcUtils.disconnect();
	}

	public void getDeparmentUsingFunction(byte id) throws ClassNotFoundException, SQLException {
		jdbcUtils.connect();

		String sql = "{? = CALL f_get_department_name_by_department_id(?)}";
		callableStatement = jdbcUtils.createCallableStatement(sql);

		// Registering the out parameter of the function (return type)
		callableStatement.registerOutParameter(1, Types.VARCHAR);

		// Setting input parameters of the function
		callableStatement.setByte(2, id);

		// Executing the statement
		callableStatement.execute();

		String departmentName = callableStatement.getString(1);
		System.out.println("Department Name: " + departmentName);
		
		jdbcUtils.disconnect();
	}
}
