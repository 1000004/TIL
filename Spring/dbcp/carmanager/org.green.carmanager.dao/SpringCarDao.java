package org.green.carmanager.dao;



import java.util.List;

import org.green.carmanager.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringCarDao {
	@Autowired
	private JdbcTemplate jdbcTmp;
	
	@Autowired
	private CarMapper rowMapper;
	
	@Value("#{sql['cars.insert']}")
	private String insert;
	
	@Value("#{sql['cars.getAll']}")
	private String getAll;
	
	@Value("#{sql['cars.find']}")
	private String find;
	
	@Value("#{sql['cars.findByModel']}")
	private String findByModel;
	
	public int insertCar(Car car) {
		return jdbcTmp.update(insert, car.getC_model(), car.getC_color(), car.getC_price());
	}
	
	public List<Car> getAll(){
		return jdbcTmp.query(getAll, rowMapper);
	}
	public Car find(int c_id){
		return jdbcTmp.query(find, rowMapper, c_id).get(0);
	}
	// %sonata%
	// %'sonata'%
	public List<Car> findByModel(String c_model){
		return jdbcTmp.query(findByModel, rowMapper, "%" + c_model +"%");
	}
//	class CarMapper implements RowMapper<Car>{
//		
//		@Override
//		public Car mapRow(ResultSet rs, int rowNum) throws SQLException{
//			return new Car(rs.getInt("c_id"), rs.getString("c_model"), rs.getString("c_color"), rs.getInt("c_price"));
//		}
//	}
}
