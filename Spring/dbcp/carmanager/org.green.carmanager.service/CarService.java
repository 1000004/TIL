package org.green.carmanager.service;

import java.util.List;

import org.green.carmanager.dao.SpringCarDao;
import org.green.carmanager.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	private SpringCarDao dao;
//	private ICarDAO dao;

	public int insertCar(Car car) {
		int result = dao.insertCar(car);
		return result;
	}
	public List<Car> getAll(){
		List<Car> list = dao.getAll();
		return list;
	}
//	public int insertCar(Car car) {
//		Connection con = dao.connect();
//		int result = dao.insertCar(con, car);
//		dao.disconnect(con);
//		return result;
//	}
//	public Vector<Car> getAll(){
//		Connection con = dao.connect();
//		Vector<Car> list = dao.getAll(con);
//		dao.disconnect(con);
//		return list;
//	}
}
