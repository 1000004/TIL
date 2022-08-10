package kr.ac.green.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.UpdatableResultSet;

import kr.ac.green.dto.Student;

public class HyperStudentDAO implements IDAO, MySqlConstants {

	@Override
	public Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(
				URL, UID, PASSWORD
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void disconnect(Connection con) {
		try{
			con.close();
		}catch(SQLException e){}

	}

	@Override
	public int insert(Connection con, Student s) {
		int result = 0;
		PreparedStatement pStmt = null;
		try{
			pStmt = con.prepareStatement(INSERT_SQL);
			pStmt.setString(1, s.getS_id());
			pStmt.setString(2, DBEncoding.toEn(s.getS_name()));
			pStmt.setInt(3, s.getS_age());
			pStmt.setString(4, s.getS_class());
			pStmt.setString(5, s.getS_gender());
			
			result = pStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pStmt);
		}
		return result;
	}

	@Override
	public int updateById(Connection con, Student s) {
		int result = 0;
		PreparedStatement pStmt = null;
		try{
			pStmt = con.prepareStatement(UPDATE_SQL_BY_ID);
			pStmt.setString(1, DBEncoding.toEn(s.getS_name()));
			pStmt.setInt(2, s.getS_age());
			pStmt.setString(3, s.getS_class());
			pStmt.setString(4, s.getS_gender());
			pStmt.setString(5, s.getS_id());
			
			result = pStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pStmt);
		}
		return result;
	}

	@Override
	public int deleteById(Connection con, String s_id) {
		int result = 0;
		PreparedStatement pStmt = null;
		try{
			pStmt = con.prepareStatement(DELETE_SQL_BY_ID);
			pStmt.setString(1, s_id);
			result = pStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pStmt);
		}
		return result;
	}

	@Override
	public Vector<Student> getAll(Connection con) {
		Vector<Student> list = new Vector<Student>();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try{
			pStmt = con.prepareStatement(GET_ALL_SQL);
			rs = pStmt.executeQuery();
			while(rs.next()){
				Student s = rowMopping(rs);
				list.add(s);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pStmt);
		}
		return list;
	}

	@Override
	public Student getStudentById(Connection con, String s_id) {
		Student s = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try{
			pStmt = con.prepareStatement(GET_STUDENT_BY_ID);
			pStmt.setString(1, s_id);
			rs = pStmt.executeQuery();
			if(rs.next()){
				s = rowMopping(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pStmt);
		}
		return s;
	}
	
	private Student rowMopping(ResultSet rs) throws SQLException, UnsupportedEncodingException {
		String s_id = rs.getString("s_id");//geString 문자열로 가져온다
		String s_name = DBEncoding.toKor(rs.getString("s_name"));
		int s_age = rs.getInt("s_age");//geInt 정수로 가져온다
		String s_class = rs.getString("s_class");
		String s_gender = rs.getString("s_gender");
		
		Student s = new Student();
		s.setS_id(s_id);
		s.setS_name(s_name);
		s.setS_age(s_age);
		s.setS_class(s_class);
		s.setS_gender(s_gender);
		return s;
	}

}
