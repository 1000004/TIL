package org.green.di;

public class Some {
	private String data;
	private Other other;
	
	public Some() {}
	public Some(String data, Other other) {
		super();
		this.data = data;
		this.other = other;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Other getOther() {
		return other;
	}
	public void setOther(Other other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "Some [data=" + data + ", other=" + other + "]";
	}
}
