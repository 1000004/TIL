package org.green.second;

public class MyBean {
	private String bean_name;
	private int bean_num;
	private String bean_password;
	
	public MyBean() {}
	public MyBean(String bean_name, int bean_num, String bean_password) {
		super();
		this.bean_name = bean_name;
		this.bean_num = bean_num;
		this.bean_password = bean_password;
	}
	public String getBean_name() {
		return bean_name;
	}
	public void setBean_name(String bean_name) {
		this.bean_name = bean_name;
	}
	public int getBean_num() {
		return bean_num;
	}
	public void setBean_num(int bean_num) {
		this.bean_num = bean_num;
	}
	public String getBean_password() {
		return bean_password;
	}
	public void setBean_password(String bean_password) {
		this.bean_password = bean_password;
	}
	@Override
	public String toString() {
		return "MyBean [bean_name=" + bean_name + ", bean_num=" + bean_num + ", bean_password=" + bean_password + "]";
	}
	
	
}
