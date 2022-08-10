package kr.ac.green.dao;

import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	public static void close(ResultSet rs){
		try{
			rs.close();
		}catch(Exception e){}
	}
	public static void close(Statement stmt){
		try{
			stmt.close();
		}catch(Exception e){}
	}
}
