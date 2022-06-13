public class Human implements Serializable{
	
	//private static final long serialVersionUID = 1L; serialVersionUID를 사용자가 지정
	private String name;
	private  transient int age;//직렬화에서 소거
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
