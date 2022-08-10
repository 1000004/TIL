package kr.ac.green.dao;

import java.sql.Connection;
import java.util.Vector;

import kr.ac.green.dto.Student;

public interface IDAO {
	Connection connect();
	void disconnect(Connection con);
	
	int insert(Connection con, Student s);
	int updateById(Connection con, Student s);
	int deleteById(Connection con, String s_id);
	Vector<Student> getAll(Connection con);
	Student getStudentById(Connection con, String s_id);
}
