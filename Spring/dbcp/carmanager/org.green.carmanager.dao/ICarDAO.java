package org.green.carmanager.dao;

import java.sql.Connection;
import java.util.Vector;

import org.green.carmanager.dto.Car;

public interface ICarDAO {
	Connection connect();
	void disconnect(Connection con);
	
	int insertCar(Connection con, Car car);
	Vector<Car> getAll(Connection con);
}
