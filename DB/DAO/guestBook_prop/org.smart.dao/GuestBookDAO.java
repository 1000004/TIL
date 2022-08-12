package org.smart.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.smart.bean.GuestBook;

/*
 * DAO : Data Access Object
 * 
 * 1. Driver 로드
 * 2. 연결
 * 3. 질의
 * 4. 자원해제
 * 
 */

public class GuestBookDAO {
//	Singleton Pattern : 단 하나의 유일한 객체를 보장
//	1. 생성자를 private으로 만든다.
//  2. private static 한 자신 타입의 객체를 생성해놓는다.
//	3. 2에서 생성한 static 객체의 getter를 작성한다.
	
	private static GuestBookDAO instance = 
		new GuestBookDAO();
	
	private GuestBookDAO() {
//		1. 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public static GuestBookDAO getInstance() {
		return instance;
	}
	
//	연결	
	public Connection connect() {
//		java.sql.Connection
		Connection con = null;
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", // DBURL
				"root",	// UID 
				"sesfinkl"	// UPW
			);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return con;
	}
	
//	질의(1. 글쓰기)
	public int write(Connection con, GuestBook book) {
		int result = 0;
		// 질의하는 객체
		Statement stmt = null;
		
		/*
		 * 1. executeUpdate :: INSERT, DELETE, UPDATE
		 * 		return -> 변경된 행의 수
		 * 2. executeQuery :: SELECT
		 * 		return -> ResultSet
		 */
		
		String content = toSQLString(
			toEn(book.getContent())
		);
		String reg = toSQLString(
			toEn(book.getReg())
		);
		
		
		// euc_kr -> 8859_1
		String sql = "INSERT INTO guest_book (content, reg) " +
				"VALUES (" + content +", " + reg + ")";
		
		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			closeAll(stmt);
			closeAll(con);
		}
		
		return result;
	}
	
	
	public GuestBook[] readBook(Connection con) {
		GuestBook[] books = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = 
			"SELECT * FROM guest_book ORDER BY gid DESC";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// ResultSet 마지막줄로 이동
			rs.last();
			// 마지막줄의 번호 == 읽은 갯수
			int count = rs.getRow();
			books = new GuestBook[count];
			// 원상복귀
			rs.beforeFirst();			
			
			int idx = 0;
			while(rs.next()) {
				String gid = rs.getString("gid");
				String content = toKor(rs.getString("content"));
				String reg = toKor(rs.getString("reg"));
				
				GuestBook book = 
					new GuestBook(gid, content, reg);
				books[idx] = book;
				idx++;
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			closeAll(rs);
			closeAll(stmt);
			closeAll(con);
		}
		
		return books;
	}
	
	
//	SQL의 문자열은 '로 감싸져야 한다.
	private String toSQLString(String str) {
		return "'" + str + "'";
	}
	
//	자원해제
	public void closeAll(Connection con) {
		try {
			if(con != null) con.close();
		} catch (SQLException e) {}
	}
	public void closeAll(Statement stmt) {
		try {
			if(stmt != null) stmt.close();
		} catch(SQLException e) {}
	}
	public void closeAll(ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch(SQLException e){}
	}
	
//	euc_kr -> 8859_1 :: INSERT, UPDATE
	private String toEn(String str) {
		String en = null;
		try {
			en = new String(
				str.getBytes("euc_kr"), "8859_1"
			);
		} catch (UnsupportedEncodingException e) {}		
		return en;
	}
//	8859_1 -> euc-kr :: SELECT
	private String toKor(String str) {
		String kor = null;
		try {
			kor = new String(
				str.getBytes("8859_1"), "euc_kr"
			);
		} catch(UnsupportedEncodingException e) {}		
		return kor;
	}
}
