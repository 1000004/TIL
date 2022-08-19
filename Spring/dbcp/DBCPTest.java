package org.green.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPTest {
	private BasicDataSource ds;
	
	public DBCPTest() {
		ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("1234");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		
		ds.setInitialSize(10);
		ds.setMaxActive(10);
		ds.setMinIdle(10);
		ds.setMaxIdle(10);
	}
	
	public int insert(String value) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = ds.getConnection();
			pStmt = con.prepareStatement("INSERT INTO dummy (testValue) VALUES (?)");
			pStmt.setString(1, value);
			result = pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pStmt.close();
			}catch (Exception e) {}
			try {
				con.close();//끊기는것이 아닌 반납
			}catch (Exception e) {}
		}
		return result;
	}
	public static void main(String[] args) {
		DBCPTest test = new DBCPTest();
		System.out.println(test.insert("abc"));
	}
}
