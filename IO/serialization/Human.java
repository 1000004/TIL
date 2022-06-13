public class Human implements Serializable{
	/*
		heap에는 멤버변수들만 올라간다
		Class 파일을 가지고 만든 Class 객체가 있다 형태 정보 1개로 유지(생성자 메서드 멤버변수 종류 객수 공통)
		메서드 호출시 참조
		Class 객체를 1개 가지고 나머지는 참조된다 (생성자 메서드 공통타입) 
	*/
	//private static final long serialVersionUID = 1L; serialVersionUID를 사용자가 지정
	private String name;
	private  transient int age;//직렬화에서 소거 직렬화를 넣고 싶지 않은 정보를 뺄 수 있다 transient를 멤버변수 타입 앞에 붙인다 0으로 나온다
	private boolean gender;
	private OptionalInfo info;
	

	public Human(String name, int age, boolean gender, OptionalInfo info) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.info = info;
	}

	public Human(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public OptionalInfo getInfo() {
		return info;
	}
	
	public void setInfo(OptionalInfo info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", gender=" + gender + ", info=" + info + "]";
	}

	
	
}
