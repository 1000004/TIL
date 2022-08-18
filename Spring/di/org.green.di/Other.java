package org.green.di;

public class Other {
	private int num;

	public Other() {}
	public Other(int num) {
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
		return "Other [num=" + num + "]";
	}
	
}
