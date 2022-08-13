package hqd.com.ultil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private Properties properties;
	private Connection connection;

	public JDBCUtils() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream("src/main/resource/database.properties"));
	}

// tạo menthor kết nối dataBase
	public Connection getConnect() throws ClassNotFoundException, SQLException {

		String url = properties.getProperty("url");
		String userName = properties.getProperty("username");
		String passWord = properties.getProperty("password");
		String driver = properties.getProperty("driver");

		Class.forName(driver);
		connection = DriverManager.getConnection(url, userName, passWord);

		return connection;
	}

//methor đóng kết nối
	public void disConnect() throws SQLException {
		connection.close();
	}
// methor tạo dùng statement tạo đối tượng ResultSet:

	public ResultSet getResultSet(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		return resultSet;
	}

// methor dùng prepareStatement toạ đối tượng ResultSet:
	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement;

	}
}
