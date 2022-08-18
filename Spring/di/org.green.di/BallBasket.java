package org.green.di;

import java.util.Vector;

public class BallBasket {
	private Vector<Ball> list;

	public Vector<Ball> getList() {
		return list;
	}
	public void setList(Vector<Ball> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "BallBasket [list=" + list + "]";
	}
	
}
