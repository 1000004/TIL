package org.login.bean;

public class Member {
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_nick;
	
	public Member(){}
	public Member(String u_id){
		super();
		this.u_id = u_id;
	}
	public Member(String u_id, String u_pw, String u_name, String u_nick) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_nick = u_nick;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	@Override
	public String toString() {
		return "Member [u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_nick=" + u_nick + "]";
	}
	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof Member)){
			return false;
		}
		Member temp = (Member) o;
		return u_id.equals(temp.getU_id());
	}
}
