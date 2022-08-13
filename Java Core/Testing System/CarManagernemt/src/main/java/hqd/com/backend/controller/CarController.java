package hqd.com.backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import hqd.com.backend.service.CarService;
import hqd.com.backend.service.ICarService;
import hqd.com.entity.Car;
import hqd.com.entity.CarColor;
import hqd.com.entity.CarCompany;

public class CarController {
	private static Logger logger= Logger.getLogger(CarController.class);
	private ICarService service;

	public CarController() throws FileNotFoundException, IOException {
		service = new CarService();
	}

	public List<Car> GetListCar() throws ClassNotFoundException, SQLException {
		logger.debug("danh sách xe");
		logger.info("info log");
		return service.GetListCar();
	}

	public boolean AddNewCarferrari(String name, CarColor color, int price, CarCompany carCompany, String rareAccessary,
			String carTypeRare) throws ClassNotFoundException, SQLException {
		return service.AddNewCarferrari(name, color, price, carCompany, rareAccessary, carTypeRare);
	}

	public boolean AddNewFord(String name, CarColor color, int price, CarCompany carCompany, String rareAccessary,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		return service.AddNewFord(name, color, price, carCompany, rareAccessary, carFuelEnvironmental);
	}

	public boolean AddNewHonda(String name, CarColor color, int price, CarCompany carCompany,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		return service.AddNewHonda(name, color, price, carCompany, carFuelEnvironmental);
	}

	public boolean AddNewMercedes(String name, CarColor color, int price, CarCompany carCompany, String carTypeRare,
			String rareAccessary, String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		return service.AddNewMercedes(name, color, price, carCompany, carTypeRare, rareAccessary, carFuelEnvironmental);
	}

	public boolean AddNewToyota(String name, CarColor color, int price, CarCompany carCompany, String carTypeRare,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException{
		return service.AddNewToyota(name, color, price, carCompany, carTypeRare, carFuelEnvironmental);
	}

	public boolean UppdateNewCarferrari(int id, String name, CarColor color, int price, String rareAccessary,
			String carTypeRare) throws ClassNotFoundException, SQLException{
		return service.UppdateNewCarferrari(id, name, color, price, rareAccessary, carTypeRare);
	}

	public boolean UppdateNewFord(int id, String name, CarColor color, int price, String rareAccessary,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException{
		return service.UppdateNewFord(id, name, color, price, rareAccessary, carFuelEnvironmental);
	}

	public boolean UppdateNewHonda(int id, String name, CarColor color, int price, String carFuelEnvironmental)
			throws ClassNotFoundException, SQLException{
		return service.UppdateNewHonda(id, name, color, price, carFuelEnvironmental);
	}

	public boolean UppdateNewMercedes(int id, String name, CarColor color, int price, String carFuelEnvironmental,
			String rareAccessary, String carTypeRare) throws ClassNotFoundException, SQLException{
		return service.UppdateNewMercedes(id, name, color, price, carFuelEnvironmental, rareAccessary, carTypeRare);
	}

	public boolean UppdateNewToyota(int id, String name, CarColor color, int price, String carFuelEnvironmental,
			String carTypeRare) throws ClassNotFoundException, SQLException{
		return service.UppdateNewToyota(id, name, color, price, carFuelEnvironmental, carTypeRare);
	}

	public boolean DeleteCar(int id) throws ClassNotFoundException, SQLException{
		return service.DeleteCar(id);
	}

	public List<Car> MostExpensiveCar() throws ClassNotFoundException, SQLException{
		return service.MostExpensiveCar();
	}

}
