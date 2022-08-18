package org.green.di;

import java.util.Hashtable;

public class BallBox {
	private Hashtable<String, Ball> table;

	public Hashtable<String, Ball> getTable() {
		return table;
	}

	public void setTable(Hashtable<String, Ball> table) {
		this.table = table;
	}

	@Override
	public String toString() {
		return "BallBox [table=" + table + "]";
	}
	
}
