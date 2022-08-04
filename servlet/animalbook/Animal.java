package kr.ac.green;

public class Animal {
	private int a_num;
	private String a_name;
	private int a_lifespan;
	private String a_habitat;
	private String a_feature;
	private static int count=1;
	public Animal(){
		a_num = count;
		count++;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public int getA_lifespan() {
		return a_lifespan;
	}
	public void setA_lifespan(int a_lifespan) {
		this.a_lifespan = a_lifespan;
	}
	public String getA_habitat() {
		return a_habitat;
	}
	public void setA_habitat(String a_habitat) {
		this.a_habitat = a_habitat;
	}
	public String getA_feature() {
		return a_feature;
	}
	public void setA_feature(String a_feature) {
		this.a_feature = a_feature;
	}
}
