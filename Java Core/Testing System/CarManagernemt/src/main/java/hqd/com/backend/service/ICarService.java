package hqd.com.backend.service;

import java.sql.SQLException;
import java.util.List;

import hqd.com.entity.Car;
import hqd.com.entity.CarColor;
import hqd.com.entity.CarCompany;

public interface ICarService {
	
	public List<Car> GetListCar() throws ClassNotFoundException, SQLException;

	public boolean AddNewCarferrari(String name, CarColor color, int price, CarCompany carCompany, String rareAccessary,
			String carTypeRare) throws ClassNotFoundException, SQLException;

	public boolean AddNewFord(String name, CarColor color, int price, CarCompany carCompany, String rareAccessary,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException;

	public boolean AddNewHonda(String name, CarColor color, int price, CarCompany carCompany,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException;

	public boolean AddNewMercedes(String name, CarColor color, int price, CarCompany carCompany, String carTypeRare,
			String rareAccessary, String carFuelEnvironmental) throws ClassNotFoundException, SQLException;

	public boolean AddNewToyota(String name, CarColor color, int price, CarCompany carCompany, String carTypeRare,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException;

	public boolean UppdateNewCarferrari(int id, String name, CarColor color, int price, String rareAccessary,
			String carTypeRare) throws ClassNotFoundException, SQLException;

	public boolean UppdateNewFord(int id, String name, CarColor color, int price, String rareAccessary,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException;

	public boolean UppdateNewHonda(int id, String name, CarColor color, int price, String carFuelEnvironmental)
			throws ClassNotFoundException, SQLException;

	public boolean UppdateNewMercedes(int id, String name, CarColor color, int price, String carFuelEnvironmental,
			String rareAccessary, String carTypeRare) throws ClassNotFoundException, SQLException;

	public boolean UppdateNewToyota(int id, String name, CarColor color, int price, String carFuelEnvironmental,
			String carTypeRare) throws ClassNotFoundException, SQLException;

	public boolean DeleteCar(int id) throws ClassNotFoundException, SQLException;

	public List<Car> MostExpensiveCar() throws ClassNotFoundException, SQLException;

}
