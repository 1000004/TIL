package org.green.carmanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.apache.commons.dbcp.BasicDataSource;
import org.green.carmanager.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class MySqlCarDao implements ICarDAO {
	@Autowired
	private BasicDataSource ds;
//	public MySqlCarDao() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public Connection connect() {
		Connection con = null;
		try {
//			con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/test",
//				"root",
//				"1234"
//			);
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void disconnect(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertCar(Connection con, Car car) {
		String sql = "INSERT INTO cars (c_model, c_color, c_price) VALUES (?,?,?)";
		PreparedStatement pStmt = null;
		int result = 0;
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, car.getC_model());
			pStmt.setString(2, car.getC_color());
			pStmt.setInt(3, car.getC_price());
			
			result = pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pStmt);
		}
		return result;
	}

	@Override
	public Vector<Car> getAll(Connection con) {
		String sql = "SELECT * FROM cars ORDER BY c_id DESC";
		Vector<Car> list = new Vector<Car>();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = con.prepareStatement(sql);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				list.add(new Car(
					rs.getInt("c_id"),
					rs.getString("c_model"),
					rs.getString("c_color"),
					rs.getInt("c_price")
				));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pStmt);
		}
		return list;
	}
	private void close(Statement stmt) {
		try {
			stmt.close();
		}catch(Exception e) {}
	}
	private void close(ResultSet rs) {
		try {
			rs.close();
		}catch (Exception e) {}
	}

}
