package hqd.com.backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import hqd.com.backend.repository.CarRepository;
import hqd.com.backend.repository.ICarRepository;
import hqd.com.entity.Car;
import hqd.com.entity.CarColor;
import hqd.com.entity.CarCompany;

public class CarService implements ICarService{

	private ICarRepository repository;

	public CarService() throws FileNotFoundException, IOException {
		repository = new CarRepository();
	}

	public List<Car> GetListCar() throws ClassNotFoundException, SQLException {
		return repository.GetListCar();
	}

	public boolean AddNewCarferrari(String name, CarColor color, int price, CarCompany carCompany, String rareAccessary,
			String carTypeRare) throws ClassNotFoundException, SQLException {
		
		return repository.AddNewCarferrari(name, color, price, carCompany, rareAccessary, carTypeRare);
	}

	public boolean AddNewFord(String name, CarColor color, int price, CarCompany carCompany, String rareAccessary,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.AddNewFord(name, color, price, carCompany, rareAccessary, carFuelEnvironmental);
	}

	public boolean AddNewHonda(String name, CarColor color, int price, CarCompany carCompany,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.AddNewHonda(name, color, price, carCompany, carFuelEnvironmental);
	}

	public boolean AddNewMercedes(String name, CarColor color, int price, CarCompany carCompany, String carTypeRare,
			String rareAccessary, String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.AddNewMercedes(name, color, price, carCompany, carTypeRare, rareAccessary, carFuelEnvironmental);
	}

	public boolean AddNewToyota(String name, CarColor color, int price, CarCompany carCompany, String carTypeRare,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.AddNewToyota(name, color, price, carCompany, carTypeRare, carFuelEnvironmental);
	}

	public boolean UppdateNewCarferrari(int id, String name, CarColor color, int price, String rareAccessary,
			String carTypeRare) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.UppdateNewCarferrari(id, name, color, price, rareAccessary, carTypeRare);
	}

	public boolean UppdateNewFord(int id, String name, CarColor color, int price, String rareAccessary,
			String carFuelEnvironmental) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.UppdateNewFord(id, name, color, price, rareAccessary, carFuelEnvironmental);
	}

	public boolean UppdateNewHonda(int id, String name, CarColor color, int price, String carFuelEnvironmental)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.UppdateNewHonda(id, name, color, price, carFuelEnvironmental);
	}

	public boolean UppdateNewMercedes(int id, String name, CarColor color, int price, String carFuelEnvironmental,
			String rareAccessary, String carTypeRare) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.UppdateNewMercedes(id, name, color, price, carFuelEnvironmental, rareAccessary, carTypeRare);
	}

	public boolean UppdateNewToyota(int id, String name, CarColor color, int price, String carFuelEnvironmental,
			String carTypeRare) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.UppdateNewToyota(id, name, color, price, carFuelEnvironmental, carTypeRare);
	}

	public boolean DeleteCar(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.DeleteCar(id);
	}

	public List<Car> MostExpensiveCar() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.MostExpensiveCar();
	}

}
