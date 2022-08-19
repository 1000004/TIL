package org.green.carmanager.dto;

public class Car {
	private int c_id;
	private String c_model;
	private String c_color;
	private int c_price;
	public Car() {}
	//insert
	public Car(String c_model, String c_color, int c_price) {
		super();
		this.c_model = c_model;
		this.c_color = c_color;
		this.c_price = c_price;
	}
	public Car(int c_id, String c_model, String c_color, int c_price) {
		super();
		this.c_id = c_id;
		this.c_model = c_model;
		this.c_color = c_color;
		this.c_price = c_price;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_model() {
		return c_model;
	}
	public void setC_model(String c_model) {
		this.c_model = c_model;
	}
	public String getC_color() {
		return c_color;
	}
	public void setC_color(String c_color) {
		this.c_color = c_color;
	}
	public int getC_price() {
		return c_price;
	}
	public void setC_price(int c_price) {
		this.c_price = c_price;
	}
	@Override
	public String toString() {
		return "Car [c_id=" + c_id + ", c_model=" + c_model + ", c_color=" + c_color + ", c_price=" + c_price + "]";
	}
}
