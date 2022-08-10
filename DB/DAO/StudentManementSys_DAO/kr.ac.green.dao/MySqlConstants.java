package kr.ac.green.dao;

public interface MySqlConstants {
	String URL = "jdbc:mysql://localhost:3306/test";
	String UID = "root";
	String PASSWORD = "1234";
	
	String INSERT_SQL = "INSERT INTO student(s_id, s_name, s_age, s_class, s_gender) VALUES (?,?,?,?,?)";
	String UPDATE_SQL_BY_ID = "UPDATE student STE s_name = ? s_age = ? s_class = ? s_gender = ? WHERE s_id = ?";
	String DELETE_SQL_BY_ID = "DELETE FROM student WHERE s_id = ?";
	String GET_ALL_SQL = "SELECT * FROM student ORDER BY s_id";
	String GET_STUDENT_BY_ID = "SELECT * FROM student WHERE s_id= ? ";
}
