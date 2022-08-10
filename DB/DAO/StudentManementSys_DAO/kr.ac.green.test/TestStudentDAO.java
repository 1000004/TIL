package kr.ac.green.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.ac.green.dao.StudentDAO;
import kr.ac.green.dto.Student;

public class TestStudentDAO {
	private static StudentDAO dao;
	private static Connection con;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = StudentDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		con = dao.connect();
		con.setAutoCommit(false);
	}

	@After
	public void tearDown() throws Exception {
		dao.disconnect(con);
	}

	@Test
	public void testInsert() {
		Student s= new Student("test_id_","text_name",5,"a","f");
		int result = dao.insert(con, s);
		
		Assert.assertEquals(1, result);
	}
	@Test
	public void testDeleteById(){
		int result =dao.deleteById(con, "test_id");
		
		Assert.assertEquals(1, result);
	}
}

