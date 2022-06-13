public class OptionalInfo implements Serializable{
	private String addr;
	private String tel;
	private String email;
	public OptionalInfo(String addr, String tel, String email){
		super();
		this.addr = addr;
		this.tel = tel;
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "OptionalInfo [addr=" + addr + ", tel=" + tel + ", email=" + email + "]";
	}
}
