package kr.ac.green;

public class MovieReview {
	private int num;
	private String title;
	private int point;
	private String password;
	private String review;
	private static int count = 1;
	public MovieReview() {
		this.num = count++;//동기화 필요
	}
	public MovieReview(int num) {
		setNum(num);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof MovieReview)){
			return false;
		}
		MovieReview mr = (MovieReview)o;
		return num == mr.getNum();
	}
}
