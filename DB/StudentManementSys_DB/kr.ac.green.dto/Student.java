package kr.ac.green.dto;
/*
CREATE TABLE student(
		s_id			CHAR(10)		PRIMARY KEY,
		s_name		VARCHAR(20)	NOT NULL,
		s_age			INT			NOT NULL,
		s_class		CHAR(1)		NOT NULL,
		s_gender		CHAR(1)		NOT NULL
	);
*/
public class Student {
	private String s_id;
	private String s_name;
	private int s_age;
	private String s_class;
	private String s_gender;
	public Student(){}
	public Student(String s_id, String s_name, int s_age, String s_class, String s_gender) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_age = s_age;
		this.s_class = s_class;
		this.s_gender = s_gender;
	}

	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_age() {
		return s_age;
	}
	public void setS_age(int s_age) {
		this.s_age = s_age;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public String getS_gender() {
		return s_gender;
	}
	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_age=" + s_age + ", s_class=" + s_class
				+ ", s_gender=" + s_gender + "]";
	}
}
