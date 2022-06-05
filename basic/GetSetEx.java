class Human {
	private String name;
	private int age;
	private String tel = "010-5409-8756";
	private boolean female;	//남자 :false, 여자 : true
	private boolean feelSoGood = true;
	//getter/setter
	//getter
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
		//boolean is~
	public boolean isFemale(){
		return female;
	}
	public String getTel(){
		if(feelSoGood){
			return tel;
		}else{
			return "112";
		}
	}
	//setter
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setFemale(boolean feamale){
		this.female = female;
	}

	public void printInfo(){
		String info = "name : " + name + "\n";
		info += "age" + age + "\n";
		info += "female : " + female;

		System.out.println(info);
	}
}

public class  GetSetEx {
	public static void main(String[] args) {
		Human h = new Human();
		h.setName("춘식");
		h.setAge(3);
		h.setFemale(true);

		h.printInfo();

		// h.age = 20; 외부에서 마음데로 바꿈
		h.setAge(20); // 어디서 누가 바꾸는가 알수 있다 객체 내부에서 소유자가 결정권을 가짐

		String humanName = h.getName();
		System.out.println(humanName);
		


	}
}
