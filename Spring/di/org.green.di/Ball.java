package org.green.di;

public class Ball {
	private int num;

	public Ball() {}

	public Ball(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Ball [num=" + num + "]";
	}
	
}
