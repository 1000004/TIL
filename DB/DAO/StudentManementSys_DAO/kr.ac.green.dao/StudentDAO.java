package kr.ac.green.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.mysql.jdbc.UpdatableResultSet;

import kr.ac.green.dto.Student;

/*
 * java <-> Databass : JDB(Java DataBase Connectivity)
 * (자바에서 db 핸들링 - JDBC가 필요)
 * 필수 요소 : JDBC Driver(ex : mysql-connector-java-5.1.6.jar)
 * 배포 후 실행을 보장하기 위해 WEB-INF/lib 에 포함할 것
 * 
 * 1. 드라이버로드(1번만 수행하면 됨)
 * 2. 연결
 * 3. 질이(CRUD)
 * 4. 연결끊기 및 자원해제
 * 
 * 요청이 들어온경우 2->3->4 순서로 반복됨.
 * 
 * DAO 클래스(외부자원과 연결 객체) 같은 경우 싱글패턴을 적용한다.
 * 단 하나의 유일한 객체 보장하는 방법(private 생성자를 만든다)
 */
public class StudentDAO implements IDAO{
	private static final StudentDAO INSTATNCE = new StudentDAO();
	
//	private StudentDAO(){
		// 드라이버 등록
		// DB에 따라 드라이버 명 url이 변경
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e){
//			e.printStackTrace();
//		}
//	}
	
	public static StudentDAO getInstance(){
		return INSTATNCE;
	}
	//database 연결
	public Connection connect(){
		// jdnc:mysql://접속IP:포트번호/접근할 database이름
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "1234";
		Connection con = null;
		try{
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	//database 연결 끊기
	public void disconnect(Connection con){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//insert
	public int insert(Connection con, Student s){
		int result = 0;
		//질의날리는 객체
		Statement stmt = null;
		String sql = "INSERT INTO student (s_id, s_name, s_age, s_class, s_gender) VALUES ('%s', '%s', %d, '%s', '%s')";
		
		try {
			sql = String.format(sql, s.getS_id(), DBEncoding.toEn(s.getS_name()), s.getS_age(), s.getS_class(), s.getS_gender());
			stmt = con.createStatement();
			/*
			 * excuteUpdate(데이터베이스 내용변화) : insert, delete, update -> int(적용된 레코드 수)
			 * excuteQuery(데이터베이스 내용변화(x), 읽기) : select -> 결과값(테이블) -> ResultSet
			 */
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}finally{
			close(stmt);
		}
		return result;
	}
	//deleteById
	public int deleteById(Connection con, String s_id){
		int result = 0;
		String sql = String.format("DELETE FROM student WHERE s_id='%s'",s_id);
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(stmt);
		}
		return result;
	}
	private void close(Statement stmt){
		try{
			stmt.close();
		}catch(Exception e){}
	}
	//updateById
	public int updateById(Connection con, Student s){
		int result = 0;
		String sql = "UPDATE student SET s_name ='%s', s_age=%d, s_class ='%s', s_gender ='%s' WHERE s_id ='%s'";
		Statement stmt = null;
		try{
			sql = String.format(sql, DBEncoding.toEn(s.getS_name()), s.getS_age(), s.getS_class(), s.getS_gender(), s.getS_id());
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}finally{
			close(stmt);
		}
		return result;
	}
	//select
	public Vector<Student> getAll(Connection con){
		Vector<Student> list = new Vector<Student>();
		String sql = "SELECT * FROM student ORDER BY s_id";
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){//다음 레코드
				Student s = rowMopping(rs);
				list.add(s);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(stmt);
		}
		return list;
	}
	private void close(ResultSet rs){
		try{
			rs.close();
		}catch(Exception e){}
	}
	//아이디로 학생 한명 구하는 메서드
	//getStudentById
	//존재하면 해당 student 객체, 존재하지 않는 아이디 : null
	
	public Student getStudentById(Connection con, String s_id){
		Student student = null;
		String sql = "SELECT * FROM student WHERE s_id='%s' ";
		sql = String.format(sql, s_id);
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				student = rowMopping(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return student;
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
