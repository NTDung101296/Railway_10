package hqd.com.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hqd.com.entity.Car;
import hqd.com.entity.CarColor;
import hqd.com.entity.CarCompany;
import hqd.com.ultil.JDBCUtils;

public class CarRepository implements ICarRepository {
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private List<Car> cars;
	private Car car;
	private JDBCUtils jdbcUtils;

	public CarRepository() throws FileNotFoundException, IOException {
		cars = new ArrayList<Car>();
		jdbcUtils = new JDBCUtils();
	}

// ------------------------------------------- GET LIST CAR ------------------------------------------------------------------------------------

	public List<Car> GetListCar() throws ClassNotFoundException, SQLException {
		// kết nối Database
		jdbcUtils.getConnect();

		// tạo sql:
		String sql = "select *  from Car;";
		// tạo đối tượng resultSet
		resultSet = jdbcUtils.getResultSet(sql);
		while (resultSet.next() == true) {
			int id = resultSet.getInt("carID");
			String name = resultSet.getString("carName");
			CarColor color = CarColor.valueOf(resultSet.getString("carColor").toString());
			int price = resultSet.getInt("price");
			CarCompany carCompany= CarCompany.valueOf(resultSet.getString("carCompany").toString());
			car = new Car(id, name, color, price,carCompany);
			cars.add(car);
		}
		// đóng kết nối
		jdbcUtils.disConnect();
		return cars;
	}

// ---------------------------------------------------- CREATE CAR ---------------------------------------------------------------------------

	// NHẬP XE FERRARI

	public boolean AddNewCarferrari(String name, CarColor color, int price, CarCompany carCompany, String rareAccessary,
			String carTypeRare) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "insert into Car(carName,carColor,`price`,carCompany,rareAccessary,carTypeRare)"
				+ "VALUE	(?,?,?,?,?,?)";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, CarCompany.Ferrari.toString());
		preparedStatement.setString(5, rareAccessary);
		preparedStatement.setString(6, carTypeRare);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã khởi tạo thành công!!!");
			return true;
		} else {
			System.out.println(" Khởi tạo thất bại.Mời bạn nhập lại");
			return false;
		}
	}

	// NHẬP XE FORD

	public boolean AddNewFord(String name, CarColor color, int price, CarCompany carCompany, String rareAccessary,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "insert into Car(carName,carColor,`price`,carCompany,rareAccessary,carFuelEnvironmental)"
				+ "VALUE	(?,?,?,?,?,?)";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, CarCompany.Ford.toString());
		preparedStatement.setString(5, rareAccessary);
		preparedStatement.setString(6, carFuelEnvironmental);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã khởi tạo thành công!!!");
			return true;
		} else {
			System.out.println(" Khởi tạo thất bại.Mời bạn nhập lại");
			return false;
		}

	}

	// NHẬP XE HONDA

	public boolean AddNewHonda(String name, CarColor color, int price, CarCompany carCompany,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "insert into Car(carName,carColor,`price`,carCompany,carFuelEnvironmental)"
				+ "VALUE	(?,?,?,?,?)";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, CarCompany.Honda.toString());
		preparedStatement.setString(5, carFuelEnvironmental);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã khởi tạo thành công!!!");
			return true;
		} else {
			System.out.println(" Khởi tạo thất bại.Mời bạn nhập lại");
			return false;
		}

	}

	// NHẬP XE MERCEDES

	public boolean AddNewMercedes(String name, CarColor color, int price, CarCompany carCompany, String carTypeRare,
			String rareAccessary, String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "insert into Car(carName,carColor,`price`,carCompany,carTypeRare,rareAccessary,carFuelEnvironmental)"
				+ "VALUE	(?,?,?,?,?,?,?)";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, CarCompany.Mercedes.toString());
		preparedStatement.setString(5, carTypeRare);
		preparedStatement.setString(6, rareAccessary);
		preparedStatement.setString(7, carFuelEnvironmental);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã khởi tạo thành công!!!");
			return true;
		} else {
			System.out.println(" Khởi tạo thất bại.Mời bạn nhập lại");
			return false;
		}

	}

	// NHẬP XE TOYOTA

	public boolean AddNewToyota(String name, CarColor color, int price, CarCompany carCompany, String carTypeRare,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "insert into Car(carName,carColor,`price`,carCompany,carTypeRare,carFuelEnvironmental)"
				+ "VALUE	(?,?,?,?,?,?)";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, CarCompany.Toyota.toString());
		preparedStatement.setString(5, carTypeRare);
		preparedStatement.setString(6, carFuelEnvironmental);

		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã khởi tạo thành công!!!");
			return true;
		} else {
			System.out.println(" Khởi tạo thất bại.Mời bạn nhập lại");
			return false;
		}

	}

	// ---------------------------------------------------- UPDATE CAR ---------------------------------------------------------------------------

	// UPDATE XE FERRARI

	public boolean UppdateNewCarferrari(int id, String name, CarColor color, int price, String rareAccessary,
			String carTypeRare) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "update Car\r\n" + "SET carName =?,carColor=?,`price`=?,rareAccessary=?,carTypeRare=?\r\n"
				+ "where carID=?;";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2,color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, rareAccessary);
		preparedStatement.setString(5, carTypeRare);
		preparedStatement.setInt(6, id);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã uppdate thành công!!!");
			return true;
		} else {
			System.out.println(" uppdate thất bại.Mời bạn nhập lại");
			return false;
		}
	}

	// UPDATE XE FORD
	public boolean UppdateNewFord(int id, String name, CarColor color, int price, String rareAccessary,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "update Car SET carName =?,carColor=?,`price`=?,carFuelEnvironmental=?,rareAccessary=? where carID=?;";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, carFuelEnvironmental);
		preparedStatement.setString(5, rareAccessary);
		preparedStatement.setInt(6, id);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã uppdate thành công!!!");
			return true;
		} else {
			System.out.println(" uppdate thất bại.Mời bạn nhập lại");
			return false;
		}

	}

	// UPDATE XE HONDA
	public boolean UppdateNewHonda(int id, String name, CarColor color, int price, String carFuelEnvironmental)
			throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "update Car SET carName =?,carColor=?,`price`=?,carFuelEnvironmental=? where carID=?;";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, carFuelEnvironmental);
		preparedStatement.setInt(6, id);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã uppdate thành công!!!");
			return true;
		} else {
			System.out.println(" uppdate thất bại.Mời bạn nhập lại");
			return false;
		}

	}

	// UPDATE XE MERCEDES
	public boolean UppdateNewMercedes(int id, String name, CarColor color, int price, String carFuelEnvironmental,
			String rareAccessary, String carTypeRare) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "update Car SET carName =?,carColor=?,`price`=?,carFuelEnvironmental=?,rareAccessary=?,carTypeRare=? where carID=?;";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, carFuelEnvironmental);
		preparedStatement.setString(5, rareAccessary);
		preparedStatement.setString(6, carTypeRare);
		preparedStatement.setInt(7, id);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã uppdate thành công!!!");
			return true;
		} else {
			System.out.println(" uppdate thất bại.Mời bạn nhập lại");
			return false;
		}

	}

	// UPDATE XE TOYOTA
	public boolean UppdateNewToyota(int id, String name, CarColor color, int price, String carFuelEnvironmental,
			String carTypeRare) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "update Car SET carName =?,carColor=?,`price`=?,carFuelEnvironmental=?,carTypeRare=? where carID=?;";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, color.toString());
		preparedStatement.setInt(3, price);
		preparedStatement.setString(4, carFuelEnvironmental);
		preparedStatement.setString(5, carTypeRare);
		preparedStatement.setInt(6, id);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã uppdate thành công!!!");
			return true;
		} else {
			System.out.println(" uppdate thất bại.Mời bạn nhập lại");
			return false;
		}

	}

// ---------------------------------------------------- DELETE CAR ---------------------------------------------------------------------------

	// DELETE XE
	public boolean DeleteCar(int id) throws ClassNotFoundException, SQLException {
		// kết nối database
		jdbcUtils.getConnect();
		// tạo câu lệnh sql:
		String sql = "delete from Car where carID=?;";
		// tạo đối tượng preparedStatement
		preparedStatement = jdbcUtils.getPreparedStatement(sql);
		preparedStatement.setInt(1, id);
		// tạo đối tương result
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println(" bạn đã xoá thành công!!!");
			return true;
		} else {
			System.out.println(" xoá thất bại.Mời bạn nhập lại");
			return false;
		}

	}

// ---------------------------------------------------- TÌM XE ĐẮT NHẤT ---------------------------------------------------------------------------

	
	
		public List<Car> MostExpensiveCar() throws ClassNotFoundException, SQLException {
			// kết nối Database
			jdbcUtils.getConnect();

			// tạo sql:
			String sql = "select * from Car order by price DESC limit 5;";
			// tạo đối tượng resultSet
			resultSet = jdbcUtils.getResultSet(sql);
			while (resultSet.next() == true) {
				int id = resultSet.getInt("carID");
				String name = resultSet.getString("carName");
				CarColor color = CarColor.valueOf(resultSet.getString("carColor").toString());
				int price = resultSet.getInt("price");
				CarCompany carCompany= CarCompany.valueOf(resultSet.getString("carCompany").toString());
				car = new Car(id, name, color, price,carCompany);
				cars.add(car);
			}
			// đóng kết nối
			jdbcUtils.disConnect();
			return cars;
		
	}
}
