package org.green.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class BeforeVSDBCP {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String uid = "root";
	private static String pw ="1234";
	private static BasicDataSource ds = new BasicDataSource();
	static {
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(uid);
		ds.setPassword(pw);
		ds.setInitialSize(20);
		ds.setMaxActive(20);
		ds.setMinIdle(20);
		ds.setMaxIdle(20);
	}
	public static void usingDBCP() {
		long time = System.currentTimeMillis();
		Connection con = null;
		for(int i=0; i<1000; i++) {
			try {
				con = ds.getConnection();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				}catch (Exception e) {}
			}
		}
		time = System.currentTimeMillis() - time;
		System.out.println("dbcp : " + time);
	}
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void before() {
		Connection con = null;
		long time = System.currentTimeMillis();
		for(int i=0; i<1000; i++) {
			try {
				con = DriverManager.getConnection(url, uid, pw);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				}catch(Exception e) {}
			}
		}
		time = System.currentTimeMillis() - time;
		System.out.println("before : " + time);
	}
	public static void main(String[] args) {
		before();
		usingDBCP();
	}
}
