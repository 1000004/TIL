package org.green.carmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.green.carmanager.dto.Car;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements RowMapper<Car>{

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new Car(rs.getInt("c_id"), rs.getString("c_model"), rs.getString("c_color"), rs.getInt("c_price"));
	}
	
}
